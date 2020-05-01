package cn.az.project.miaosha.annotation.access;

import cn.az.project.miaosha.constant.AccessKey;
import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.result.CodeMessage;
import cn.az.project.miaosha.result.Result;
import cn.az.project.miaosha.service.MiaoshaUserService;
import cn.az.project.miaosha.service.RedisService;
import cn.az.project.miaosha.util.BeanUtil;
import cn.az.project.miaosha.util.CommonUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Optional;

/**
 * @author az
 * @date 2020/4/23
 */
@Slf4j
@Component
public class AccessLimitInterceptor extends HandlerInterceptorAdapter {

    private MiaoshaUserService miaoshaUserService;

    private RedisService redisService;

    @Autowired
    public void setMiaoshaUserService(MiaoshaUserService miaoshaUserService) {
        this.miaoshaUserService = miaoshaUserService;
    }

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }


    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        if (handler instanceof HandlerMethod) {
            MiaoshaUser mu = miaoshaUserService.getByToken(response, CommonUtil.getToken(request).orElse(""));

            UserContext.set(mu);
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit al = hm.getMethodAnnotation(AccessLimit.class);
            if (Objects.isNull(al)) {
                return true;
            }
            int seconds = al.seconds(), maxCount = al.maxCount();
            boolean needLogin = al.needLogin();

            String key = request.getRequestURI();
            if (needLogin) {
                if (Objects.isNull(mu)) {
                    render(response, CodeMessage.SESSION_ERROR);
                    return false;
                }
                key += "_" + mu.getId();
            }
            AccessKey ak = AccessKey.withExpire(seconds);
            Optional<Integer> countOptional = BeanUtil.toBean(redisService.get(ak + key), Integer.class);
            if (countOptional.isEmpty()) {
                redisService.set(ak + key, String.valueOf(1));
            } else if (countOptional.get() < maxCount) {
                redisService.incr(ak + key);
            } else {
                render(response, CodeMessage.ACCESS_LIMIT_REACHED);
                return false;
            }
        }
        return true;
    }

    private void render(HttpServletResponse res, CodeMessage cm) {
        res.setContentType("application/json;charset=UTF-8");
        String str = JSON.toJSONString(Result.error(cm));
        try (OutputStream out = res.getOutputStream()) {
            out.write(str.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
