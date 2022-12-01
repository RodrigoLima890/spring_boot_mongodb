package com.spring.mongodb.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongodb.domain.Post;
import com.spring.mongodb.domain.repositories.PostRepository;
import com.spring.mongodb.domain.service.exception.NotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> user = postRepository.findById(id);
		return user.orElseThrow(()-> new NotFoundException("Objeto não encontrado!"));
	}
}
