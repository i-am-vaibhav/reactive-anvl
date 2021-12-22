package com.reactive.anvl.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;
/**
 * 
 * @author Vaibhav
 *
 */
@Data
@RequiredArgsConstructor
@Document
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@NotBlank(message = "role.name.empty.msg")
	private String name;

	private String description;

}