package com.reactive.anvl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.anvl.entity.Role;
import com.reactive.anvl.service.RoleService;

@RestController
@RequestMapping("/v1")
public class RoleController {

	@Autowired
	private RoleService service;

	@GetMapping(value = "/roles")
	public ResponseEntity<List<Role>> getRoles() {
		return ResponseEntity.ok(service.getRoles());
	}

}
