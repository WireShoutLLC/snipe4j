package com.wireshout.snipe4j;

public enum CategoryType {
	Accessory("accessory"), 
	Asset("asset"), 
	Component("component"), 
	Consumable("consumable");
	
    private String apiValue;

    CategoryType(String apiValue) {
        this.apiValue = apiValue;
    }

    public String apiValue() {
        return apiValue;
    }
}
