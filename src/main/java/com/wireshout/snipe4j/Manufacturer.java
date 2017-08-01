package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Manufacturer extends SnipeObject {
	private final static String ENDPOINT = "manufacturers";
	
	private String url;
	private String support_url;
	private String support_phone;
	private String support_email;
	private int assets_count; //This is returned as a String, not an int (see also #3791)
	private int licenses_count; //This is returned as a String, not an int (see also #3791)
	private int consumables_count; //This is returned as a String, not an int (see also #3791)
	private int accessories_count; //This is returned as a String, not an int (see also #3791)

	public Manufacturer(SnipeInstance snipe, int id) {
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
