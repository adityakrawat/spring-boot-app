package com.springboot.springbootapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class WelcomeController {
	

	@RequestMapping(value="/")
	public String welcome() {
		return "This is default page.";
	}
}