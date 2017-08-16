package com.wireshout.snipe4j;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class Category extends SnipeObject {
	private final static String ENDPOINT = "categories";
	
	//Implemented
	private CategoryType type;
	
	//TODO: Implement
	//private boolean use_default_eula; //These are 0/1 for some reason???
	//private boolean require_acceptance; //These are 0/1 for some reason???
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
		if(detail.get("category_type") != null) {
			String const_type =  (String) detail.get("category_type");
			if(const_type.equals(CategoryType.Accessory.apiValue())) {
				type = CategoryType.Accessory;
			} else if(const_type.equals(CategoryType.Asset.apiValue())) {
				type = CategoryType.Asset;
			} else if(const_type.equals(CategoryType.Component.apiValue())) {
				type = CategoryType.Component;
			} else if(const_type.equals(CategoryType.Consumable.apiValue())) {
				type = CategoryType.Consumable;
			} else {
				System.out.println("ERROR: Invalid Category Type!");
			}
		} else {
			System.out.println("ERROR: API did not return category type");
		}
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
