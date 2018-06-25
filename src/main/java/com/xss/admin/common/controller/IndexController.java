package com.xss.admin.common.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {



	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
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
