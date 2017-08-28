package com.alan.github.tools;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DropCollection {
	private MongoClient mongoClient = new MongoClient();
    private DB db = mongoClient.getDB("mydb");
    void drop(String name) {
    	if (db.collectionExists(name)) {
            DBCollection myCollection = db.getCollection(name);
            myCollection.drop();
        }
    }
    
    
}
