package cn.az.wx.project.monitor.controller;

import cn.az.wx.common.constant.Constants;
import cn.az.wx.common.utils.StringUtil;
import cn.az.wx.framework.aspectj.lang.annotation.Log;
import cn.az.wx.framework.aspectj.lang.enums.BusinessType;
import cn.az.wx.framework.redis.RedisCache;
import cn.az.wx.framework.security.LoginUser;
import cn.az.wx.framework.web.controller.BaseController;
import cn.az.wx.framework.web.domain.AjaxResult;
import cn.az.wx.framework.web.page.TableDataInfo;
import cn.az.wx.project.monitor.domain.SysUserOnline;
import cn.az.wx.project.system.service.ISysUserOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 在线用户监控
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/online")
public class SysUserOnlineController extends BaseController {

    @Autowired
    private ISysUserOnlineService userOnlineService;

    @Autowired
    private RedisCache redisCache;

    @PreAuthorize("@ss.hasPermi('monitor:online:list')")
    @GetMapping("/list")
    public TableDataInfo list(String ipaddr, String userName) {
        Collection<String> keys = redisCache.keys(Constants.LOGIN_TOKEN_KEY + "*");
        List<SysUserOnline> userOnlineList = new ArrayList<>();
        for (String key : keys) {
            LoginUser user = redisCache.getCacheObject(key);
            if (StringUtil.isNotEmpty(ipaddr) && StringUtil.isNotEmpty(userName)) {
                if (StringUtil.equals(ipaddr, user.getIpaddr()) && StringUtil.equals(userName, user.getUsername())) {
                    userOnlineList.add(userOnlineService.selectOnlineByInfo(ipaddr, userName, user));
                }
            } else if (StringUtil.isNotEmpty(ipaddr)) {
                if (StringUtil.equals(ipaddr, user.getIpaddr())) {
                    userOnlineList.add(userOnlineService.selectOnlineByIpaddr(ipaddr, user));
                }
            } else if (StringUtil.isNotEmpty(userName) && StringUtil.isNotNull(user.getUser())) {
                if (StringUtil.equals(userName, user.getUsername())) {
                    userOnlineList.add(userOnlineService.selectOnlineByUserName(userName, user));
                }
            } else {
                userOnlineList.add(userOnlineService.loginUserToUserOnline(user));
            }
        }
        Collections.reverse(userOnlineList);
        userOnlineList.removeAll(Collections.singleton(null));
        return getDataTable(userOnlineList);
    }

    /**
     * 强退用户
     */
    @PreAuthorize("@ss.hasPermi('monitor:online:forceLogout')")
    @Log(title = "在线用户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{tokenId}")
    public AjaxResult forceLogout(@PathVariable String tokenId) {
        redisCache.deleteObject(Constants.LOGIN_TOKEN_KEY + tokenId);
        return AjaxResult.success();
    }
}
