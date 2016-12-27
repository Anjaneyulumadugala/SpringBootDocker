package com.model;

import java.util.Date;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class JDBCMongoConnections {
	public static void main(String[] args) {

	    try {

		// Connect to MongoDB
		MongoClient mongo = new MongoClient("localhost", 27017);

		//Get database
		MongoDatabase db = mongo.getDatabase("EmpDB");

		// Get table from 'EmpDB'
		MongoCollection<Document> table = db.getCollection("employee");

		// Inserting data
		Document document = new Document();
		document.put("name", "anji");
		document.put("age", 28);
		document.put("createdDate", new Date());
		table.insertOne(document);

		// Searching and displaying
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "anji");

		FindIterable<Document> cursor = table.find(searchQuery);
		MongoCursor<Document> curs=cursor.iterator();
		while (curs.hasNext()) {
			System.out.println(curs.next());
		}

		// update the data
		BasicDBObject query = new BasicDBObject();
		query.put("name", "anji");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", "anjaneyulu");

		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);

		table.updateOne(query, updateObj);

		// Search and Display
		BasicDBObject searchQuery2
		    = new BasicDBObject().append("name", "anjaneyulu");

		FindIterable<Document> cursor2 = table.find(searchQuery2);
		MongoCursor<Document> cur=cursor2.iterator();
		while (cur.hasNext()) {
			System.out.println(cur.next());
		}

		// Done
		mongo.close();
		System.out.println("Done");

	    } catch (MongoException e) {
		e.printStackTrace();
	    }

	  }
}
