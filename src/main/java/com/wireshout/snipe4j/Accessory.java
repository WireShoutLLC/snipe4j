package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Accessory extends SnipeObject implements Checkoutable {
	private final static String ENDPOINT = "accessories";
	
	private Company company;
	private Manufacturer manufacturer;
	private String model_number; //This is NOT a Model object, just a String field
	private Category category;
	private Location location;
	private String notes;
	private int qty; //API returns this as a string
	private String purchase_date; //TODO: make date/time format
	private String purchase_cost;
	private String order_number;
	private int min_qty; //0 makes this null, otherwise API returns a string with a number
	private boolean user_can_checkout;
	
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
		//TODO: impl model_number, notes, qty, purchase stuff, order_number, min_qty, and user_can_checkout
	}
	
	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
