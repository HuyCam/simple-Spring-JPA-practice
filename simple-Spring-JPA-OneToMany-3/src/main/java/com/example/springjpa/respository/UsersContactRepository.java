package com.example.springjpa.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springjpa.model.UsersContact;

public interface UsersContactRepository extends JpaRepository<UsersContact, Integer> {

}
