package com.self.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.self.Model.Post;

public interface PostReppository extends MongoRepository<Post, String> {

//	List<Post> findByText(String text);

}
