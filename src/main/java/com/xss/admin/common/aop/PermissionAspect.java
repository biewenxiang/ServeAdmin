package com.xss.admin.common.aop;

import com.xss.admin.common.exception.NoPermissionException;
import com.xss.admin.common.model.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限管理（非法访问）
 */
@Aspect
@Component
public class PermissionAspect {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(UserAccess)")
    public void userAccess() {
    }

    @Before(value = "userAccess()&&" +
            "@annotation(userAccessAnnotation)", argNames = "userAccessAnnotation")
    public void checkPermission(UserAccess userAccessAnnotation) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            if (user.getRoleid()!=null&&user.getRoleid()!=4) {
                logger.info("user" +user.getUsername()+"NO_ACCESS");
                throw new NoPermissionException("NO_ACCESS");
            }
        }
    }


}
