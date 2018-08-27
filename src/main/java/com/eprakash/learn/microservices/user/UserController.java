package com.eprakash.learn.microservices.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	UserDaoService userDaoService;

	
	
	@GetMapping("/users")
	public List<User> findAll() {
		 System.out.println(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
		 System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
		 System.out.println(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
			
		return userDaoService.findAll();
	}

// save
	@PostMapping(path="/users")
	public ResponseEntity<Object> save(@RequestBody User user) {
		
		User savedUser= userDaoService.save(user);
		
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
	                .toUri();
	
	        return ResponseEntity.created(location).build();
		
	}
	// findbyid
	
	@GetMapping(path="/users/{id}")
	public User getUserById(@PathVariable int id) {
		
		User userById = userDaoService.getUserById(id);
		if(userById==null){
			throw new UserNotFoundException("id "+id);
		}
		return userById;
		
	}
	

	@DeleteMapping(path="/users/{id}")
	public User deleteUserById(@PathVariable int id) {
		
		User userById = userDaoService.deleteUserById(id);
		if(userById==null){
			throw new UserNotFoundException("id "+id);
		}
		return userById;
		
	}
	

	

}
