package com.wireshout.snipe4j;

//COMPARED WITH API

public class Accessory implements Checkoutable {
	private int id;
	private String name;
	private Company company;
	private Manufacturer manufacturer;
	private String model_number; //This is NOT a Model object, just a String field
	private Category category;
	private Location location;
	private String notes;
	private int qty; //API returns this as a string
	private String purchase_date; //TODO: make date/time format
	private String purchase_cost;
	private String order_number;
	private int min_qty; //0 makes this null, otherwise API returns a string with a number
	//These might be merged into an interface
	/* "created_at": {
        "datetime": "2017-07-25 12:26:44",
        "formatted": "2017-07-25 12:26PM"
    },
    "updated_at": {
        "datetime": "2017-07-25 12:31:35",
        "formatted": "2017-07-25 12:31PM"
    },
    "available_actions": {
        "checkout": true,
        "checkin": false,
        "update": true,
        "delete": true
    },
    "user_can_checkout": true */
}
