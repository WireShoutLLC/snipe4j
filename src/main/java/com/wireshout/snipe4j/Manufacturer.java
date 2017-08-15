package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Manufacturer extends SnipeObject {
	private final static String ENDPOINT = "manufacturers";
	
	//Implemented
	private String url;
	private String support_url;
	private String support_phone;
	private String support_email;
	
	//TODO: Implement
	private int assets_count; //This is returned as a String, not an int (see also #3791)
	private int licenses_count; //This is returned as a String, not an int (see also #3791)
	private int consumables_count; //This is returned as a String, not an int (see also #3791)
	private int accessories_count; //This is returned as a String, not an int (see also #3791)

	public Manufacturer(SnipeInstance snipe, int id) {
		super(snipe, id);
		HashMap<String, Object> detail = refresh(getEndpoint());
		if(detail.get("url") != null) {
			url = (String) detail.get("url");
		}
		if(detail.get("support_url") != null) {
			support_url = (String) detail.get("support_url");
		}
		if(detail.get("support_phone") != null) {
			support_phone = (String) detail.get("support_phone");
		}
		if(detail.get("support_email") != null) {
			support_email = (String) detail.get("support_email");
		}
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
