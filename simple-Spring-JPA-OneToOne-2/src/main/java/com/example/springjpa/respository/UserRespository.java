package com.example.springjpa.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springjpa.model.Users;

//@RepositoryRestResource(path="/user")
//@Respository
public interface UserRespository extends JpaRepository<Users, Integer> {
	List<Users> findByName(String name);
}

