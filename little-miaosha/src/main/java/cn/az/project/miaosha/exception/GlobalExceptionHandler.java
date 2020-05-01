package cn.az.project.miaosha.exception;

import cn.az.project.miaosha.result.CodeMessage;
import cn.az.project.miaosha.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author az
 * @since 2020-04-13
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error(e.getMessage(), e);
        if (e instanceof GlobalException) {
            return Result.error(((GlobalException) e).getCodeMessage());
        } else if (e instanceof BindException) {
            return Result.error(CodeMessage.BIND_ERROR);
        } else {
            return Result.error(CodeMessage.SERVER_ERROR);
        }
    }
}
