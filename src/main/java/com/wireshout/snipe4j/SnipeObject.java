package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

abstract class SnipeObject {
	private SnipeInstance snipe;
	private int id;
	private String name;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private String endpoint;
	private boolean deleted;
	
	protected SnipeObject(SnipeInstance conn_snipe, int const_id, String const_endpoint) {
		snipe = conn_snipe;
		id = const_id;
		endpoint = const_endpoint;
		deleted = false;
	}

	public SnipeObject(SnipeInstance conn_snipe, SnipeObjectFactory create) {
		snipe = conn_snipe;
		//TODO
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean setName(String name) {
		//TODO
		return false;
	}
	
	public LocalDateTime getCreatedAt() {
		return created_at;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updated_at;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	protected HashMap<String, Object> refresh() {
		String requestOutput = snipe.makeGetRequest(endpoint + "/" + getId());
		
		JSONParser parser = new JSONParser();
		HashMap<String, Object> payload = null;
		try {
			payload = (JSONObject) parser.parse(requestOutput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String rawName = (String) payload.get("name");
		String rawCreatedTime = (String) payload.get("created_at"); //This is wrong, see issue #3799
		String rawUpdatedTime = (String) payload.get("updated_at"); //This is wrong, see issue #3799
		
		name = rawName;
		created_at = SnipeDateTimeUtility.convert(rawCreatedTime);
		updated_at = SnipeDateTimeUtility.convert(rawUpdatedTime);
		
		return payload;
	}
	
	protected boolean delete() {
		boolean requestOutput = snipe.makeDeleteRequest(endpoint + "/" + getId());
		
		name = null;
		created_at = null;
		updated_at = null;
		deleted = true;
		
		return requestOutput;
	}
}
