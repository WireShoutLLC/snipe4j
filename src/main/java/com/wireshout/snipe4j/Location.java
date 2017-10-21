package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Location extends SnipeObject {
	private final static String ENDPOINT = "locations";
	
	//Implemented
	private String address;
	private String city;
	private String state;
	private String country;
	private String zip;
	private Location parent;
	
	//TODO: Implement
	//private int assets_checkedout;
	//private int assets_default;
	//private ArrayList<Asset> assets;
	//private ArrayList<Location> children;
	
	public Location(SnipeInstance snipe, int id) {
		super(snipe, id);
		HashMap<String, Object> detail = refresh(getEndpoint());
		if(detail.get("address") != null) {
			address = (String) detail.get("address");
		}
		if(detail.get("city") != null) {
			city = (String) detail.get("city");
		}
		if(detail.get("state") != null) {
			state = (String) detail.get("state");
		}
		if(detail.get("country") != null) {
			country = (String) detail.get("country");
		}
		if(detail.get("zip") != null) {
			zip = (String) detail.get("zip");
		}
		if(detail.get("parent") != null) {
			JSONObject obj =  (JSONObject) detail.get("parent");
			Long tmpid = (Long) obj.get("id");
			parent = new Location(snipe, tmpid.intValue());
		}
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
