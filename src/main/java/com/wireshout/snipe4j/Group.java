package com.wireshout.snipe4j;

import java.time.LocalDateTime;

public class Group extends SnipeObject {
	private String permissions; //JSON object
	private int users_count;
	private final static String ENDPOINT = "groups";
	
	public Group(SnipeInstance snipe, int id) {
		super(snipe, id);
		refresh(getEndpoint());
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
