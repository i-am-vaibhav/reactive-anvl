/**
 * 
 */
package com.reactive.anvl.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.anvl.entity.Role;

/**
 * @author Vaibhav
 *
 */
public interface RoleRepository extends ReactiveMongoRepository<Role, String> {

}
