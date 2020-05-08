package com.example.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.springjpa.respository.UserRespository;

//@EnableJpaRepositories(basePackageClasses = UserRespository.class)
@EnableJpaRepositories(basePackages = "com.example.springjpa.respository")
@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

}
