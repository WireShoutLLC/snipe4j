package com.wireshout.snipe4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Asset extends CheckoutLocation implements Checkoutable {
	private int id;
	private String name;
	private String asset_tag;
	private String serial;
	private StatusLabel status_label;
	private Category category;
	private Model model;
	private String model_number;
	//private Manufacturer manufacturer; //This is found out based on Model
	private Supplier supplier;
	private String notes;
	private String order_number;
	private Company company; //TODO: this might be a problem in the API if it doesnt return an ID
	private Location location;
	private Location rtd_location; //TODO: Wat?
	private String image; //This is a URL
	private CheckoutLocation assigned_to;
	private String warranty; //This is a string "<n> months"
	private LocalDate warranty_expires; //Requires purchase_date to be set
	private LocalDate purchase_date;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private LocalDateTime last_checkout;
	private LocalDate expected_checkin;
	private String purchase_cost;
	
	//private boolean requestable; //This seems to have been removed?
	//TODO: assigned_to - need to figure out to what objects can an asset be checked out to
	
	public boolean checkout(CheckoutLocation location) {
		//TODO: Implement note, expected_checkin, checkout_at, and name
		return false;
	}
	
	public boolean checkin() {
		return false;
	}
	
	public boolean checkin(String note) {
		return false;
	}

	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}
