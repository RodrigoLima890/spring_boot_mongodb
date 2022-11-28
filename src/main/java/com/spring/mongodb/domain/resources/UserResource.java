package com.spring.mongodb.domain.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.domain.User;

@RestController
@RequestMapping("/users")
public class UserResource {
	@GetMapping
	private ResponseEntity<List<User>> findAll(){
		User peter = new User("1","Peter Parker", "peter@email.com");
		User jim = new User("2", "Jim Grey", "grey@email.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(peter, jim));
		return ResponseEntity.ok().body(list);
	}

}
