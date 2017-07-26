package com.wireshout.snipe4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consumable implements Checkoutable {
	private int id;
	private String name;
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
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private boolean user_can_checkout; //What is this for?
	
}
