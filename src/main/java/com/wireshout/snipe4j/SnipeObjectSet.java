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
					int id = ((Long) ((JSONObject) o).get("id")).intValue();
					this.add((SnipeObject) creates.getConstructor(SnipeInstance.class,int.class).newInstance(snipe, id));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
