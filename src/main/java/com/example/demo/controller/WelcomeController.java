package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repo.loginrepo;
import com.example.demo.model.*;

@Controller
public class WelcomeController {
	@Autowired
	public loginrepo repo;
	@Autowired
	private BCryptPasswordEncoder encode;

	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@GetMapping("loginPage")
	public String login() {
		return "login";
	}

	@GetMapping("signUp")
	public String signup() {
		login login = new login();
		login.setEnable(true);
		login.setUser("kyaw");
		login.setPassword(encode.encode("kyaw"));
		login.setRole("ROLE_Student");
		repo.save(login);

		return "redirect:/";
	}
}
