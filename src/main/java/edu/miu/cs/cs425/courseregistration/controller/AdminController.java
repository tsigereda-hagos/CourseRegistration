package edu.miu.cs.cs425.courseregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("")
	public String showMainAdminPage() {
		return "main-admin";
	}
}