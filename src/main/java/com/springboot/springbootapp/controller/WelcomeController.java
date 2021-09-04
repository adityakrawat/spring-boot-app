package com.springboot.springbootapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class WelcomeController {
	
	@Value("${spring.application.name}")
	private String name;
	
	@RequestMapping(value="/")
	public String welcome() {
		return "This is default page for " + name ;
	}
}