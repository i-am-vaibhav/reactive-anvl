/**
 * 
 */
package com.reactive.anvl.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.anvl.entity.User;

/**
 * @author Vaibhav
 *
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
