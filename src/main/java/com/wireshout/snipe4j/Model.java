package com.wireshout.snipe4j;

public class Model {
	private int id;
	private String name;
	private String model_number;
	private Category category; //This returns a eula_text field, which might come in handy for the Category bit. use_default_eula, checkin_email, and require_acceptance are not booleans
	private Manufacturer manufacturer; //manufacturer_id
	private Depreciation depreciation; //TODO: this is REALLY horrible. It returns "No" when not set, and when it is, it returns the object, but also with a "user_id" parameter???
	private String image;
	private int assets_count;
	private FieldSet fieldset;
	private String notes;
	private int eol; //TODO: This seems really horrible. Is returned when none is set as "None", or "n months" when it is set
	
}
