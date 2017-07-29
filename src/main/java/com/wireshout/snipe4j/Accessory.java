package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Accessory extends SnipeObject implements Checkoutable {
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
		super(snipe, id, "accessories");
		HashMap<String, Object> detail = refresh();
		int company_id = (Integer) detail.get("company");
		company = new Company(snipe, company_id);
	}
	
	public Accessory(SnipeInstance snipe, AccessoryFactory create) {
		super(snipe, create);
	}
}
