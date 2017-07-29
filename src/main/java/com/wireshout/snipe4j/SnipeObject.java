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
		
		if(payload.containsKey("status") && (String) payload.get("status") == "error") {
			throw new NullPointerException((String) payload.get("messages"));
		}
		
		name = (String) payload.get("name");
		
		JSONObject objcreated = (JSONObject) payload.get("created_at");
		created_at = SnipeDateTimeUtility.convert((String) objcreated.get("datetime"));
		
		JSONObject objupdated = (JSONObject) payload.get("updated_at");
		updated_at = SnipeDateTimeUtility.convert((String) objupdated.get("datetime"));
		
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
