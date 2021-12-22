/**
 * 
 */
package com.reactive.anvl.entity;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author Vaibhav
 *
 */
@Data
@Document
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Email(message = "user.email.invalid.msg")
	@NotBlank(message = "user.email.empty.msg")
	private String email;

	@NotBlank(message = "user.name.empty.msg")
	private String userName;

	private String address;

	@JsonIgnore
	private String password;

	private Set<Role> roles;

}
