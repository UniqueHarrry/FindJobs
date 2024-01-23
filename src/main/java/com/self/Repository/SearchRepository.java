package com.self.Repository;

import java.util.List;

import com.self.Model.Post;

public interface SearchRepository {

	List<Post> findByText(String text);
}
