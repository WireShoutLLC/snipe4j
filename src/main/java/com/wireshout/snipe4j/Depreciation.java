package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Depreciation extends SnipeObject {
	private String months;
	private final static String ENDPOINT = "depreciations";
	
	public Depreciation(SnipeInstance snipe, int id) {
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
