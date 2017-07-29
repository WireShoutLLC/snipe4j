package com.wireshout.snipe4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class License extends SnipeObject implements Checkoutable {
	private Company company;
	private Manufacturer manufacturer;
	private String product_key;
	private String order_number;
	private String purchase_order; //Why does this differ from order_number, and if we want PO numbers, why not across everything?
	private LocalDate purchase_date;
	private String purchase_cost;
	private Depreciation depreciation;
	private String notes;
	private LocalDate expiration_date;
	private int total_seats; //API returns a number in a string
	private int remaining_qty;
	private int min_qty;
	private String license_name;
	private String license_email;
	private boolean maintained;
	private Supplier supplier;
	private boolean user_can_checkout; //What is this for?

	
	public License(SnipeInstance snipe, int id) {
		super(snipe, id, "license");
		HashMap<String, Object> detail = refresh();
		if(detail.get("company") != null) {
			JSONObject obj =  (JSONObject) detail.get("company");
			Long tmpid = (Long) obj.get("id");
			company = new Company(snipe, tmpid.intValue());
		}
		if(detail.get("depreciation") != null) {
			JSONObject obj =  (JSONObject) detail.get("depreciation");
			Long tmpid = (Long) obj.get("id");
			depreciation = new Depreciation(snipe, tmpid.intValue());
		}
		if(detail.get("supplier") != null) {
			JSONObject obj =  (JSONObject) detail.get("supplier");
			Long tmpid = (Long) obj.get("id");
			supplier = new Supplier(snipe, tmpid.intValue());
		}
		if(detail.get("manufacturer") != null) {
			JSONObject obj =  (JSONObject) detail.get("manufacturer");
			Long tmpid = (Long) obj.get("id");
			manufacturer = new Manufacturer(snipe, tmpid.intValue());
		}
	}
	
	public License(SnipeInstance snipe, LicenseFactory create) {
		super(snipe, create);
	}
}
