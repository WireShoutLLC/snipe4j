package com.wireshout.snipe4j;

public class Asset extends CheckoutLocation implements Checkoutable {
	private int id;
	private String assetTag;
	//TODO: assigned_to - need to figure out to what objects can an asset be checked out to
	private Category category;
	private Company company; //TODO: this might be a problem in the API if it doesnt return an ID
	private String created_at; //TODO: make this a proper Date/Time format
	private String eol; //TODO: make this a proper Date/Time format
	private String expected_checkin; //TODO: make this a proper Date/Time format
	private String image; //TODO: is this a URL or something else?
	private String last_checkout; //TODO: make this a proper Date/Time format
	private Location location;
	private Manufacturer manufacturer;
	private Model model; //TODO: this might be a problem in the API if it doesnt return an ID. See also "model_number" field
	private String name;
	private String notes;
	private String order_number;
	private String purchase_cost;
	private String purchase_date; //TODO: make this a proper Date/Time format
	private String serial;
	private StatusLabel status_label;
	private int warranty_months; //TODO: This seems wrong
	private boolean requestable;
	private boolean archived;
	private Location rtd_location_id; //TODO: Wat?
	
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
}
