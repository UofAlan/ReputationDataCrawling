package com.alan.github.repostories.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.alan.github.model.GitInfo;
import com.alan.github.repostories.CustomRepository;
@Configuration
public class CustomRepositoryImpl implements CustomRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;


	@Override
	public List<GitInfo> getByNameorTheFirstFileName(String name, String firstFileName) {
		Criteria c1 = Criteria.where("name").is(name);
		Criteria c2 = Criteria.where("firstFileName").is(firstFileName);
		Query query = new Query(new Criteria().orOperator(c1,c2));
		List<GitInfo> list = mongoTemplate.find(query, GitInfo.class,"apache_git");
		return list;
		
	}
	
	

}
