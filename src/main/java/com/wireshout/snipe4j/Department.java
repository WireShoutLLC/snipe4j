package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Department extends SnipeObject {
	private final static String ENDPOINT = "departments";
	
	//Implemented
	private Company company;
	private User manager;
	private Location location;
	
	//TODO: Implement
	//private String users_count; //This should probably be an int
	
	public Department(SnipeInstance snipe, int id) {
		super(snipe, id);
		HashMap<String, Object> detail = refresh(getEndpoint());
		if(detail.get("company") != null) {
			JSONObject obj =  (JSONObject) detail.get("company");
			Long tmpid = (Long) obj.get("id");
			company = new Company(snipe, tmpid.intValue());
		}
		if(detail.get("manager") != null) {
			JSONObject obj =  (JSONObject) detail.get("manager");
			Long tmpid = (Long) obj.get("id");
			manager = new User(snipe, tmpid.intValue());
		}
		if(detail.get("location") != null) {
			JSONObject obj =  (JSONObject) detail.get("location");
			Long tmpid = (Long) obj.get("id");
			location = new Location(snipe, tmpid.intValue());
		}
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		//This is broken, Issue #3860
		return super.delete(getEndpoint());
	}
}
