package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Location extends CheckoutLocation {
	private int id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String country;
	private int assets_checkedout;
	private int assets_default;
	private ArrayList<Asset> assets;
	private Location parent_id; //API returns this as a number in a string
	private ArrayList<Location> children;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	//UI shows ZIP
}
