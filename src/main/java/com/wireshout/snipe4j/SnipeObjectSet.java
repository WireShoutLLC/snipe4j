package com.wireshout.snipe4j;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

abstract class SnipeObjectSet extends LinkedHashSet<SnipeObject> {
	String endpoint;
	String queryString;
	SnipeInstance snipe;
	Class creates;
	
	public SnipeObjectSet(SnipeInstance const_snipe, Class const_creates, String const_endpoint) {
		super();
		endpoint = const_endpoint;
		queryString = "";
		snipe = const_snipe;
		creates = const_creates;
		fill();
	}

	public SnipeObjectSet(SnipeInstance const_snipe, Class const_creates, String const_endpoint, String const_queryString) {
		super();
		endpoint = const_endpoint;
		queryString = const_queryString;
		snipe = const_snipe;
		creates = const_creates;
		fill();
	}
	
	private void fill() {
		String rawResponse = snipe.makeGetRequest(endpoint, queryString);
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray) ((JSONObject) parser.parse(rawResponse)).get("rows");
			for(Object o: array){
				if (o instanceof JSONObject) {
					Object obj = ((JSONObject) o).get("id");
					int id = 0;
					//TODO: This can be switched back after Bug #3802 is fixed
					if(obj instanceof Long)
						id = ((Long) obj).intValue();
					else if(obj instanceof String)
						id = Integer.parseInt((String) obj);
					this.add((SnipeObject) creates.getConstructor(SnipeInstance.class,int.class).newInstance(snipe, id));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
