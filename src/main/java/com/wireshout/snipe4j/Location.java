package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
}
