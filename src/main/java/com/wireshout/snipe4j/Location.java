package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Location extends SnipeObject {
	private final static String ENDPOINT = "locations";
	
	private String address;
	private String city;
	private String state;
	private String country;
	private int assets_checkedout;
	private int assets_default;
	private ArrayList<Asset> assets;
	private Location parent_id;
	private ArrayList<Location> children;
	//UI shows ZIP
	
	public Location(SnipeInstance snipe, int id) {
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
