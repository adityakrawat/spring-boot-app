package com.springboot.springbootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootAppApplication implements ApplicationRunner {

	public static final Logger logger = LoggerFactory.getLogger(SpringBootAppApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Default message for Application Runner");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
