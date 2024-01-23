package com.self.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.self.Model.Post;
import com.self.Repository.PostReppository;
import com.self.Repository.SearchRepository;

@RestController
public class PostController {

	@Autowired
	private PostReppository postReppository;
	
	@Autowired
	private SearchRepository searchRepository;
	
	@GetMapping("/getAllPosts")
	public List<Post> getAllPost(){
		return postReppository.findAll();
	}
	
	@GetMapping("/posts/{text}")
	public List<Post> Search(@PathVariable String text){
		return searchRepository.findByText(text);
		}
	
	@PostMapping("/addPost")
	public Post addPost(@RequestBody Post post) {
		return postReppository.save(post);
	}
}
