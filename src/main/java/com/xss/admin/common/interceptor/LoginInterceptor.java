package com.xss.admin.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		HttpSession session = request.getSession();
		//nginx用80端口
		int port = request.getServerName().equals("localhost") ? request.getLocalPort() : 80;
		String redirect = "http://" + request.getServerName() + ":" + port + "/loginview";
		if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/loginview")||request.getRequestURI().equals("/getUserInfo")) {
			return true;
		} else if (session.getAttribute("user") != null) {
			return true;
		} else {
			//response.sendRedirect(redirect);//跳转登录界面
			return true;
		}
	}
}
