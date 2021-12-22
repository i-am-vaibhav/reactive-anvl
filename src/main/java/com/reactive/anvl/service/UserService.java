/**
 * 
 */
package com.reactive.anvl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.reactive.anvl.entity.User;
import com.reactive.anvl.repos.UserRepository;

import reactor.core.publisher.Flux;

/**
 * @author Vaibhav
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.findAll().switchIfEmpty(Flux.empty()).toStream().collect(Collectors.toList());
	}

	public void saveUser(User user) {
		userRepository.save(user).subscribe();
	}

	public ResponseEntity<User> getUserByName(String name) {
		try {
			User user = userRepository.findByUserName(name).blockOptional().orElseThrow();
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
