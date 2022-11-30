package com.spring.mongodb.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongodb.domain.User;
import com.spring.mongodb.domain.repositories.UserRepository;
import com.spring.mongodb.domain.service.exception.NotFoundException;
import com.spring.mongodb.dto.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(()-> new NotFoundException("Objeto não encontrado!"));
	}
	public User insert(User user) {
		return userRepository.insert(user);
	}
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	public User update(User user) {
		Optional<User> newUser = userRepository.findById(user.getId());
		updateData(newUser.get(), user);
		return userRepository.save(newUser.get());
	}
	public void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}
	public User fromDto(UserDto userDto) {
		return new User(userDto.getId(), userDto.getName(),userDto.getEmail());
	}

}
