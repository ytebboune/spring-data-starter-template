package com.commonstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BaseApplication {

	public static void main(String[] args) {
		/**
		 * Application entry point
		 */
		SpringApplication.run(BaseApplication.class);
	}
	
}
