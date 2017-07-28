package com.wireshout.snipe4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
