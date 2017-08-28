package com.alan.github.pipelines;



import org.springframework.stereotype.Component;

import com.alan.github.model.GitInfo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component("GitInfoPipeline")
public class GitInfoPipeline implements PageModelPipeline<GitInfo> {

	private MongoClient mongoClient = new MongoClient();
    private DB db = mongoClient.getDB("mydb");
    private DBCollection collection = db.getCollection("apache_git");
	@Override
	public void process(GitInfo gitInfo, Task task) {
		
		DBObject object = (BasicDBObject) JSON.parse(gitInfo.toJson());
		collection.insert(object);
		
		
	}

}
