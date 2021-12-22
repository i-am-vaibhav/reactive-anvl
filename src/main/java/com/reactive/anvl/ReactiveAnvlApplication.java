package com.reactive.anvl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * 
 * @author Vaibhav
 *
 */
@SpringBootApplication
@EnableReactiveMongoRepositories 
public class ReactiveAnvlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveAnvlApplication.class, args);
	}

}
