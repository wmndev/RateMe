package com.rateme.app.platform.db.prepare;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;

import com.eyooya.app.platform.db.service.sequence.SequenceService;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class PrepareMongoTest {

	private static MongoClient client;

	@Autowired
	private SequenceService seqService;

	public static void prepareBusiness(SequenceService seqService) {
		try {
			client = new MongoClient("127.0.0.1", 27017);
			DB db = client.getDB("test-yooya");
			DBCollection businessDB = db.getCollection("business");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void prepareReviews(SequenceService seqService) {
		try {
			client = new MongoClient("127.0.0.1", 27017);
			DB db = client.getDB("test-yooya");
			DBCollection reviews = db.getCollection("reviews");
			reviews.drop();
			reviews.insert(dbObjectFromJson("{'_id':'"
					+ seqService.getNextSequence("reviews")
					+ "', '_class': 'review', 'createdByMemeberId': '1000', 'reviewingEmployeeId':'4000000', 'score':'4'}"));
			reviews.insert(dbObjectFromJson("{'_id':'"
					+ seqService.getNextSequence("reviews")
					+ "', '_class': 'review', 'createdByMemeberId': '1000', 'reviewingEmployeeId':'4000000', 'score':'4'}"));
			reviews.insert(dbObjectFromJson("{'_id':'"
					+ seqService.getNextSequence("reviews")
					+ "', '_class': 'review', 'createdByMemeberId': '1000', 'reviewingEmployeeId':'4000000', 'score':'4'}"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static DBObject dbObjectFromJson(String json) {
		return (DBObject) JSON.parse(json);
	}

}
