package com.reactive.anvl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.anvl.entity.Role;
import com.reactive.anvl.repos.RoleRepository;

import reactor.core.publisher.Flux;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getRoles() {
		return roleRepository.findAll().switchIfEmpty(Flux.empty()).toStream().collect(Collectors.toList());
	}

}
