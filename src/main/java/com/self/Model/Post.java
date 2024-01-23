package com.self.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "FindJob")
@Data
public class Post {
	
	private String profile;
	private String desc;
	private int exp;
	private String techs[];

}
