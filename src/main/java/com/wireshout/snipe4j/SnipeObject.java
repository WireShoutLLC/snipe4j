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
	private boolean deleted;
	
	protected SnipeObject(SnipeInstance conn_snipe, int const_id) {
		snipe = conn_snipe;
		id = const_id;
		deleted = false;
	}
	
	public static String getEndpoint() {
		return null;
	}

	public SnipeInstance getSnipe() {
		return snipe;
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
	
	protected HashMap<String, Object> refresh(String endpoint) {
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
		
		//This can be changed back after #3799 is fixed
		Object objcreated = payload.get("created_at");
		if(objcreated == null) {
			//This is annoying... need to figure something better out
			created_at = null;
		} else if(objcreated instanceof String) {
			created_at = SnipeDateTimeUtility.convert((String) objcreated);
		} else {
			JSONObject jsoncreated = (JSONObject) objcreated;
			created_at = SnipeDateTimeUtility.convert((String) jsoncreated.get("datetime"));
		}
		
		//This can be changed back after #3799 is fixed
		Object objupdated = payload.get("updated_at");
		if(objcreated == null) {
			//This is annoying... need to figure something better out
			updated_at = null;
		} else if(objupdated instanceof String) {
			updated_at = SnipeDateTimeUtility.convert((String) objupdated);
		} else {
			JSONObject jsonupdated = (JSONObject) objupdated;
			updated_at = SnipeDateTimeUtility.convert((String) jsonupdated.get("datetime"));
		}
		
		return payload;
	}
	
	protected boolean delete(String endpoint) {
		boolean requestOutput = snipe.makeDeleteRequest(endpoint + "/" + getId());
		
		name = null;
		created_at = null;
		updated_at = null;
		deleted = true;
		
		return requestOutput;
	}
}
