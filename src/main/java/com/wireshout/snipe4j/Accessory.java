package com.wireshout.snipe4j;

import java.time.LocalDateTime;

public class Accessory implements Checkoutable, SnipeObject {
	private int id;
	private String name;
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
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private boolean user_can_checkout;
}
