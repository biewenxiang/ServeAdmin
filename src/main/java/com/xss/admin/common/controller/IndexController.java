package com.xss.admin.common.controller;


import com.alibaba.fastjson.JSONObject;
import com.xss.modules.utils.ErrorMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class IndexController {



	@RequestMapping("/index")
	public String index(Model model) {

		return "index";
	}

	@RequestMapping("/test")
	public void test(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Object errorMsg = request.getParameter("name");
		ErrorMsg errorMsg1 = new ErrorMsg();
		response.setContentType("text/plain;charset=utf-8");
		response.setStatus(404);
		response.getWriter().write(JSONObject.toJSONString(errorMsg1));

	}
	@RequestMapping("/admin")
	public String admin(Model model) {
		return "admin";
	}


	@RequestMapping("/")
	public String index() {
		return "redirect:/admin";
	}
}
