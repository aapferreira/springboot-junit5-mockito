package com.example.sjm.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sjm.domain.User;

@RequestMapping(value = "/user")
@RestController
public class UserResource {
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable int id) {
		return ResponseEntity.ok().body(new User(1, "Augusto", "a@gmail.com", "123"));
	}

}
