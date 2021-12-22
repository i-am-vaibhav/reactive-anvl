/**
 * 
 */
package com.reactive.anvl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.reactive.anvl.entity.Role;
import com.reactive.anvl.entity.User;
import com.reactive.anvl.repos.RoleRepository;
import com.reactive.anvl.repos.UserRepository;

import reactor.core.publisher.Mono;

/**
 * @author Vaibhav
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setAddress("chrm");
		user.setEmail("vg@anvl.com");
		user.setPassword("superman");
		user.setUserName("vaibhav");
		Set<Role> roles = new HashSet<>();
		Optional<Role> blockOptional = createRole("ROLE_ADMIN");
		Optional<Role> blockOptional2 = createRole("ROLE_USER");
		roles.add(blockOptional.orElse(null));
		roles.add(blockOptional2.orElse(null));
		user.setRoles(roles);
		userRepository.save(user).subscribe();
		log.info("User created");
	}

	private Optional<Role> createRole(String string) {
		Role e = new Role();
		e.setName(string);
		e.setDescription(string);
		Mono<Role> save = roleRepository.save(e);
		return save.blockOptional();
	}

}
