package com.wireshout.snipe4j;

import java.util.HashMap;

public class Category extends SnipeObject {
	private final static String ENDPOINT = "categories";
	
	//Implemented
	private CategoryType type;
	
	//TODO: Implement
	private boolean use_default_eula;
	private boolean require_acceptance;
	//private boolean checkin_email; //This looks like it's been removed?
	//How can I see custom EULAs?
	/*
	Why are these count's necessary since we already know what type the category is?
	
	
            "assets_count": 1,
            "accessories_count": 0,
            "consumables_count": 0,
            "components_count": 0,
	 */
	
	public Category(SnipeInstance snipe, int id) {
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
