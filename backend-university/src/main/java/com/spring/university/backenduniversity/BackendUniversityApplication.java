package com.spring.university.backenduniversity;

import com.spring.university.backenduniversity.dao.StudentDAO;
import com.spring.university.backenduniversity.persistence.entity.Address;
import com.spring.university.backenduniversity.persistence.entity.User;
import com.spring.university.backenduniversity.persistence.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			/*Address address = new Address("Calle 2", "345", "9876", "", "", "Mexico");
			User student = new Student(null, "Angelica", "Juarez", "3456juyik", address);
			User save = service.save(student);
			System.out.println(save.toString());*/
			List<User> students = (List<User>) service.findAll();
			students.forEach(System.out::println);
		};
	}
}
