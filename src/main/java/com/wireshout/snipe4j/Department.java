package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Department extends SnipeObject {
	private final static String ENDPOINT = "departments";
	private Company company;
	private User manager;
	private Location location;
	private String users_count; //This should probably be an int
	
	public Department(SnipeInstance snipe, int id) {
		super(snipe, id);
		HashMap<String, Object> detail = refresh(getEndpoint());
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
