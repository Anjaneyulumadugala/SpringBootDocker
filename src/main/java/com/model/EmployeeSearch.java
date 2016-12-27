package com.model;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class EmployeeSearch {
	public boolean searchEmployee(String name)
	{
		MongoClient mongo = new MongoClient("localhost", 27017);
		//Get database
		MongoDatabase db = mongo.getDatabase("EmpDB");
		// Get table from 'EmpDB'
		MongoCollection<Document> table = db.getCollection("employee");
		
		BasicDBObject searchQuery = new BasicDBObject().append("name", name);
		FindIterable<Document> cursor = table.find(searchQuery);
		MongoCursor<Document> curs=cursor.iterator();
		if(curs.hasNext()) {
			mongo.close();
			return true;
		}
		mongo.close();
		return false;
	}
}
