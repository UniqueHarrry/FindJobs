package com.self.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.self.Model.Post;


@Component
public class SearchReposotorImp implements SearchRepository {

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter mongoConverter;
	
	@Override
	public List<Post> findByText(String text) {

		final List<Post> post = new ArrayList<>();

		MongoDatabase database = mongoClient.getDatabase("Harshal");
		MongoCollection<Document> collection = database.getCollection("FindJob");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				new Document("$search", new Document("text", new Document("query", text).append("path", "techs"))),
				new Document("$limit", 5L)));
		result.forEach(doc -> post.add(mongoConverter.read(Post.class,doc)));

		return post;
	}

}
