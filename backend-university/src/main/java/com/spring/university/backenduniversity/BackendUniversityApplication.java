package com.spring.university.backenduniversity;

import com.spring.university.backenduniversity.dao.StudentDAO;
import com.spring.university.backenduniversity.persistence.entity.Address;
import com.spring.university.backenduniversity.persistence.entity.Person;
import com.spring.university.backenduniversity.persistence.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendUniversityApplication {

	private final StudentDAO service;

	public BackendUniversityApplication(StudentDAO service) {
		this.service = service;
	}

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(BackendUniversityApplication.class, args).getBeanDefinitionNames();
		/*for(String str : beanDefinitionNames) {
			System.out.println(str);
		}*/
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			Address address = new Address("Calle 1", "123", "1623", "23", "2", "Mexico");
			Person student = new Student(null, "David", "Barcenas", "asdf1234", address);
			Person save = service.save(student);
			System.out.println(save.toString());
		};
	}
}
