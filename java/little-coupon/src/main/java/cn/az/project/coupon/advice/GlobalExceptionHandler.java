package cn.az.project.coupon.advice;

import cn.az.project.coupon.domain.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author az
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public RestResponse errorHandler(HttpServletRequest request, Exception ex) {
        return RestResponse.init().code(HttpStatus.INTERNAL_SERVER_ERROR).message(ex.getMessage()).data(request.getRequestURL().toString());
    }
}
