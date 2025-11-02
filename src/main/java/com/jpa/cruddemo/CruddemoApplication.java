package com.jpa.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.cruddemo.entity.Student;
import com.jpa.cruddemo.entity.StudentDAO;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println("ingresando estudiantes...");

			Student theStudent1 = new Student("Smith","Realidad Virtual");
			studentDAO.save(theStudent1);
			Student theStudent2 = new Student("Panfilo","Ingeniero de Sistemas");
			studentDAO.save(theStudent2);
			Student theStudent3 = new Student("Tootee","Sports");
			studentDAO.save(theStudent3);
			System.out.println("Estudiante agregado:" + theStudent1.getId());

			for(Student theStudent: studentDAO.findAll()){
				System.out.println("El estudiante es:" + theStudent);
			}
		};
	}

}
