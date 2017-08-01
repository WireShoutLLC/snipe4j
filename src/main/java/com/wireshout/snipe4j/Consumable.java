package com.wireshout.snipe4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Consumable extends SnipeObject implements Checkoutable {
	private final static String ENDPOINT = "consumables";
	
	private Category category;
	private Company company;
	private String item_no;
	private Location location;
	private Manufacturer manufacturer;
	private int min_amt;
	private String model_number;
	private int remaining;
	private String order_number;
	private String purchase_cost;
	private LocalDate purchase_date;
	private int qty;
	private boolean user_can_checkout; //What is this for?
	
	public Consumable(SnipeInstance snipe, int id) {
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
