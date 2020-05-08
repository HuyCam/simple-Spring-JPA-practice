package com.example.springjpa.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.model.Users;
import com.example.springjpa.respository.UserRespository;

@RestController
public class UserResource {
	@Autowired
	private UserRespository userRepo;
	
	@GetMapping("/user")
	public List<Users> getAll() {
		return userRepo.findAll();
	}
	
//	@GetMapping("/{name}")
//	public List<Users> getUser(@PathVariable("name") String name) {
//
//		return new ArrayList<Users>();
//	}
	
	@GetMapping(value="/user/{id}")
	@ResponseBody
	public Users getId(@PathVariable("id")  Integer id) throws EntityNotFoundException{
		System.out.println(id);
		Users u = userRepo.getOne(id);
		System.out.println(u.getName());
		if (u == null) {
			u = new Users();
		}
		return u;
	}
	
	@PostMapping(value="/user")
	@ResponseBody
	public Users saveUser(@RequestBody Users user)  {
		userRepo.save(user);
		return user;
	}
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		
		return "Hey";
	}
	
}
