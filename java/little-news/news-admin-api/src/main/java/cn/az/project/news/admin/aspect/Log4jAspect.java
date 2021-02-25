package cn.az.project.news.admin.aspect;

import cn.az.project.news.admin.service.ILogService;
import cn.az.project.news.core.jwt.JwtUtil;
import cn.az.project.news.core.properties.CommonProperties;
import cn.az.project.news.core.utils.CommonUtil;
import cn.az.project.news.core.utils.IpUtil;
import cn.az.project.news.db.entity.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Liz
 * @version 2019/10/26
 */
@Slf4j
@Aspect
@Component
public class Log4jAspect {

    @Resource
    private CommonProperties properties;

    @Resource
    private ILogService logService;

    @Pointcut("@annotation(cn.az.project.news.core.annotation.Log4j)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result;
        long beginTime = System.currentTimeMillis();
        // 执行方法
        result = point.proceed();
        // 获取 request
        HttpServletRequest request = CommonUtil.getHttpServletRequest();
        // 设置 IP 地址
        String ip = IpUtil.getIpAddr(request);
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        if (properties.getLog()) {
            // 保存日志
            String token = (String) SecurityUtils.getSubject().getPrincipal();
            String username = "";
            if (StringUtils.isNotBlank(token)) {
                username = JwtUtil.getUsername(token);
            }
            Log log4j = new Log();
            log4j.setUsername(username);
            log4j.setIp(ip);
            log4j.setTime(time);
            logService.saveLog(point, log4j);
        }
        return result;
    }
}
