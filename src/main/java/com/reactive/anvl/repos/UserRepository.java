/**
 * 
 */
package com.reactive.anvl.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.anvl.entity.User;

import reactor.core.publisher.Mono;

/**
 * @author Vaibhav
 *
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {

	Mono<User> findByUserName(String name);
	
}
