package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;

public class Accessory extends SnipeObject implements Checkoutable {
	private final static String ENDPOINT = "accessories";
	
	//Implemented
	private Company company;
	private Manufacturer manufacturer;
	private String model_number;
	private Category category;
	private Location location;
	private String notes;
	private String order_number;
	private int qty;
	
	//TODO: Implement
	//private String purchase_date; //TODO: make date/time format
	//private String purchase_cost;
	//private int min_qty; //0 makes this null, otherwise API returns a string with a number
	//private boolean user_can_checkout;
	
	public Accessory(SnipeInstance snipe, int id) {
		super(snipe, id);
		HashMap<String, Object> detail = refresh(getEndpoint());
		if(detail.get("company") != null) {
			JSONObject obj =  (JSONObject) detail.get("company");
			Long tmpid = (Long) obj.get("id");
			company = new Company(snipe, tmpid.intValue());
		}
		if(detail.get("manufacturer") != null) {
			JSONObject obj =  (JSONObject) detail.get("manufacturer");
			Long tmpid = (Long) obj.get("id");
			manufacturer = new Manufacturer(snipe, tmpid.intValue());
		}
		if(detail.get("model_number") != null) {
			model_number =  (String) detail.get("model_number");
		}
		if(detail.get("order_number") != null) {
			order_number =  (String) detail.get("order_number");
		}
		if(detail.get("qty") != null) {
			qty =  ((Long) detail.get("qty")).intValue();
		}
		if(detail.get("category") != null) {
			JSONObject obj =  (JSONObject) detail.get("category");
			Long tmpid = (Long) obj.get("id");
			category = new Category(snipe, tmpid.intValue());
		}
		if(detail.get("location") != null) {
			JSONObject obj =  (JSONObject) detail.get("location");
			Long tmpid = (Long) obj.get("id");
			location = new Location(snipe, tmpid.intValue());
		}
		if(detail.get("notes") != null) {
			notes =  (String) detail.get("notes");
		}
	}
	
	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean checkout(User user) {
		return checkout(user, 1);
	}
	
	public boolean checkout(User user, int qty) {
		List<NameValuePair> fields = new ArrayList<NameValuePair>();
		fields.add(new BasicNameValuePair("assigned_to", user.getId() + ""));
		
		for(int i = 0; i < qty; i++) {
			super.getSnipe().makePostRequest(ENDPOINT + "/" + this.getId() + "/checkout", fields);
		}
		
		
		
		return false;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
