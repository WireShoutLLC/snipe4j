package com.wireshout.snipe4j;

public class Category extends SnipeObject {
	private CategoryType type;
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
}
