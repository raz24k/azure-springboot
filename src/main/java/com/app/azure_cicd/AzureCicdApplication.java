package com.app.azure_cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AzureCicdApplication {

	public void run(String args[]) throws Exception
	{
		// Print statement when method is called
		System.out.println("HEllo world");
	}
	public static void main(String[] args) {
		SpringApplication.run(AzureCicdApplication.class, args);
	}

}
