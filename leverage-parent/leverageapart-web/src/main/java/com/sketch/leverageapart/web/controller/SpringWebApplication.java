package com.sketch.leverageapart.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {
	public static void main(String[] args) {
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        SpringApplication.run(SpringWebApplication.class, args);
    }
}