package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Location extends SnipeObject {
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
		super(snipe, id, "locations");
		HashMap<String, Object> detail = refresh();
		//TODO impl address things, asset number things, assets, parents, and children
	}
	
	public Location(SnipeInstance snipe, LocationFactory create) {
		super(snipe, create);
	}
}
