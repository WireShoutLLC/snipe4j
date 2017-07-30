package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Supplier extends SnipeObject {
	private String address;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String fax;
	private String phone;
	private String email;
	private String contact;
	private String image;
	private int assets_count;
	private int licenses_count;

	public Supplier(SnipeInstance snipe, int id) {
		super(snipe, id, "suppliers");
		HashMap<String, Object> detail = refresh();
		//TODO impl everything
	}
	
	public Supplier(SnipeInstance snipe, SupplierFactory create) {
		super(snipe, create);
	}
}
