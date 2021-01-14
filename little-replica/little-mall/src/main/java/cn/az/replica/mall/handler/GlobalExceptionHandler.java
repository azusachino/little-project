package cn.az.replica.mall.handler;

import cn.az.replica.mall.domain.R;
import cn.az.replica.mall.exception.MallException;
import cn.az.replica.mall.util.HttpUtil;
import cn.hutool.log.Log;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * GlobalExceptionHandler
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see RestControllerAdvice
 * @since 2020-03-24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Log log = Log.get();

    @ExceptionHandler(NoHandlerFoundException.class)
    public Object handle404Exception(NoHandlerFoundException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        if (HttpUtil.isAjax(request)) {
            return R.fail("您请求路径不存在，请检查url！", null);
        }
        return new ModelAndView("error/404");
    }

    /**
     * 处理自定义异常
     *
     * @param e       MallException
     * @param request HttpServletRequest
     */
    @ExceptionHandler({MallException.class})
    public Object handleBusinessException(MallException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        if (HttpUtil.isAjax(request)) {
            return R.fail(e.getMessage(), null);
        }
        return new ModelAndView("error/500", Map.of("msg", e.getMessage()));
    }

    /**
     * 处理Other异常
     *
     * @param e       Exception
     * @param request HttpServletRequest
     */
    @ExceptionHandler({Exception.class})
    public Object handleException(Exception e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        if (HttpUtil.isAjax(request)) {
            return R.fail("服务器内部错误！", null);
        }
        return new ModelAndView("error/500");
    }
}
