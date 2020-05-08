package com.example.springjpa.src;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.model.Users;
import com.example.springjpa.model.UsersContact;
import com.example.springjpa.respository.UserRespository;
import com.example.springjpa.respository.UsersContactRepository;

@RequestMapping("/usercontact")
@RestController
public class UsersContactResource {
	@Autowired
	private UsersContactRepository usersContactRepository;
	
    @Autowired
	private UserRespository userRepo;
	
//	public UsersContactResource(UsersContactRepository usersContactRepository) {
//		this.usersContactRepository = usersContactRepository;
//	}
	
	
	@GetMapping(value = "/all")
	public List<UsersContact> getUsersContact() {
		return usersContactRepository.findAll();
	}
	
	// OnetoOne demonstration
	@PostMapping(value="/update/{name}")
	public List<UsersContact> update(@PathVariable("name") String name) {
		UsersContact usersContact = new UsersContact();
		
		
		
//		users.setId();
//		users.setTeamName();
//		users.setSalary(10000);
//		users.setName();
		usersContact.setPhoneNo(111111);
		usersContact = usersContactRepository.save(usersContact);
		
		Users users = new Users(usersContact.getId(),name, 85000,"Development");
		usersContact.setUser(users);
		
		usersContactRepository.save(usersContact);
//		userRepo.save(users);
		
		
		return usersContactRepository.findAll();
	}
	
	@EntityGraph(attributePaths = "phoneNo")
	@GetMapping(value = "/usercontact/{id}")
	public Optional<UsersContact> getcontact(@PathVariable("id") Integer id) {
		return usersContactRepository.findById(id);
	}
}
