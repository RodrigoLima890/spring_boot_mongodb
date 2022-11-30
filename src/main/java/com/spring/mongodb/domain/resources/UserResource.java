package com.spring.mongodb.domain.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.mongodb.domain.User;
import com.spring.mongodb.domain.service.UserService;
import com.spring.mongodb.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	private ResponseEntity<List<UserDto>> findAll(){
		List<User> list = service.findAll();
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<UserDto> findById(@PathVariable String id) {
		User user = service.findById(id);
		UserDto userDto = new UserDto(user);
		return ResponseEntity.ok().body(userDto);
	}
	@PostMapping
	private ResponseEntity<Void> insert(@RequestBody UserDto userDto){
		User user = service.fromDto(userDto);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping("/{id}")
	private ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@PutMapping("/{id}")
	private ResponseEntity<Void> update(@RequestBody UserDto userDto, @PathVariable String id){
		User user = service.fromDto(userDto);
		user.setId(id);
		user = service.update(user);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}

