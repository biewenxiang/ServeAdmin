package com.xss.admin.common.exception;

import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统全局异常管理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 参数为空异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({NoPermissionException.class})
    public String requestMissingServletRequest(Exception ex) {
        logger.error("request Exception:", ex);
        return "权限不足";
    }

    /**
     * 特别说明： 可以配置指定的异常处理,这里处理所有
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String errorHandler(HttpServletRequest request, Exception e) {
        logger.error("errorHandler Exception:", e);
        return "error";
    }
//    @ExceptionHandler(value = NoHandlerFoundException.class)
//    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        logger.error("errorHandler Exception:", e);
//        return "404";
//    }

}