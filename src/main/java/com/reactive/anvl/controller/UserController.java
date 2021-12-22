package com.reactive.anvl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.anvl.entity.User;
import com.reactive.anvl.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/users")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(service.getUsers());
	}

	@PostMapping(value = "/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		service.saveUser(user);
	}

	@GetMapping(value = "/users/name/{name}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<User> getUserById(@PathVariable String name) {
		return service.getUserByName(name);
	}

}
