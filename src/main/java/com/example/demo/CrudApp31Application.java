package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CrudApp31Application extends SpringBootServletInitializer {

	@Autowired
	private static Environment env; 
	
	public static void main(String[] args) {
		
		SpringApplication.run(CrudApp31Application.class, args);
		System.out.println(env.getProperty("server.port")+"LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLl");
		
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CrudApp31Application.class);
    }

}
