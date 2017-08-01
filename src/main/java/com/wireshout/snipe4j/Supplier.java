package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Supplier extends SnipeObject {
	private final static String ENDPOINT = "suppliers";
	
	private String address;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String fax;
	private String phone;
	private String email;
	private String contact;
	private String image;
	private int assets_count;
	private int licenses_count;

	public Supplier(SnipeInstance snipe, int id) {
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
