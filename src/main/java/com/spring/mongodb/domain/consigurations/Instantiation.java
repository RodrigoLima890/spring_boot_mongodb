package com.spring.mongodb.domain.consigurations;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.spring.mongodb.domain.Post;
import com.spring.mongodb.domain.User;
import com.spring.mongodb.domain.repositories.PostRepository;
import com.spring.mongodb.domain.repositories.UserRepository;
import com.spring.mongodb.dto.AuthorDto;
@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex,bob));
		Post post1 = new Post(null, sdf.parse("21/11/2022"),"Vou Viajar!", "Viajarei amanhã para SP.",new AuthorDto(bob));
		Post post2 = new Post(null, sdf.parse("22/11/2022"),"Cheguei!", "Cheguie agora de manhã.",new AuthorDto(bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	
	}
	

}
