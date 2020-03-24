package cn.az.card.merchant.advice;

import cn.az.card.merchant.domain.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author az
 * @date 2020/3/18
 */
@RestControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(Exception.class)
    public RestResponse exception(HttpServletRequest request, Exception ex) {
        return RestResponse.init().code(HttpStatus.INTERNAL_SERVER_ERROR).message(ex.getMessage()).data(request.getRequestURL().toString());
    }
}
