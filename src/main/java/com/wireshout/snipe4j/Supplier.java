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
	//private String zip //Issue 3853
	private String fax;
	private String phone;
	private String email;
	private String contact;
	private String image;
	//private String notes; //Issue 3853
	private int assets_count;
	private int licenses_count;

	public Supplier(SnipeInstance snipe, int id) {
		super(snipe, id);
		HashMap<String, Object> detail = refresh(getEndpoint());
		if(detail.get("address") != null) {
			address =  (String) detail.get("address");
		}
		if(detail.get("address2") != null) {
			address2 =  (String) detail.get("address2");
		}
		if(detail.get("city") != null) {
			city =  (String) detail.get("city");
		}
		if(detail.get("state") != null) {
			state =  (String) detail.get("state");
		}
		if(detail.get("country") != null) {
			country =  (String) detail.get("country");
		}
		/*if(detail.get("zip") != null) {
			zip =  (String) detail.get("zip");
		}*/
		if(detail.get("fax") != null) {
			fax =  (String) detail.get("fax");
		}
		if(detail.get("phone") != null) {
			phone =  (String) detail.get("phone");
		}
		if(detail.get("email") != null) {
			email =  (String) detail.get("email");
		}
		if(detail.get("contact") != null) {
			contact =  (String) detail.get("contact");
		}
		if(detail.get("image") != null) {
			image =  (String) detail.get("image");
		}
		/*if(detail.get("notes") != null) {
			notes =  (String) detail.get("notes");
		}*/
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
