package com.spring.university.backenduniversity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BackendUniversityApplication {

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(BackendUniversityApplication.class, args).getBeanDefinitionNames();
	}
}
