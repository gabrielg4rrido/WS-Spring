package com.garr.ws.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garr.ws.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Gabriel", "gabriel@gmail.com", "(21) 99680-4512", "1234");
		
		return ResponseEntity.ok().body(u);
	}
	
}
