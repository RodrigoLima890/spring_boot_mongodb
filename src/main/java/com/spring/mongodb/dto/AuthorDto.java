package com.spring.mongodb.dto;

import java.io.Serializable;

import com.spring.mongodb.domain.User;

public class AuthorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDto() {
	}
	public AuthorDto(User author) {
		this.id = author.getId();
		this.name = author.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
