package com.wireshout.snipe4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Component extends SnipeObject implements Checkoutable {
	private final static String ENDPOINT = "components";
	
	private String serial_number;
	private Location location;
	private int qty; //This is returned as a string with a number in it
	private int min_qty; //This is returned as a string with a number in it
	private Category category;
	private String order_number;
	private LocalDate purchase_date;
	private String purchase_cost;
	private int remaining; //Returned as an int.
	private Company company;
	
	public Component(SnipeInstance snipe, int id) {
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
