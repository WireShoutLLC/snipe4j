package com.wireshout.snipe4j;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class Model extends SnipeObject {
	private String model_number;
	private Category category; //This returns a eula_text field, which might come in handy for the Category bit. use_default_eula, checkin_email, and require_acceptance are not booleans
	private Manufacturer manufacturer;
	private Depreciation depreciation;
	private String image;
	private int assets_count;
	private FieldSet fieldset;
	private String notes;
	private int eol; //TODO: This seems really horrible. Is returned when none is set as "None", or "n months" when it is set

	private final static String ENDPOINT = "models";
	
	public Model(SnipeInstance snipe, int id) {
		super(snipe, id);
		HashMap<String, Object> detail = refresh(getEndpoint());
		if(detail.get("manufacturer") != null) {
			JSONObject obj =  (JSONObject) detail.get("manufacturer");
			Long tmpid = (Long) obj.get("id");
			manufacturer = new Manufacturer(snipe, tmpid.intValue());
		}
		if(detail.get("category") != null) {
			JSONObject obj =  (JSONObject) detail.get("category");
			Long tmpid = (Long) obj.get("id");
			category = new Category(snipe, tmpid.intValue());
		}
		if(detail.get("depreciation") != null) {
			JSONObject obj =  (JSONObject) detail.get("depreciation");
			Long tmpid = (Long) obj.get("id");
			depreciation = new Depreciation(snipe, tmpid.intValue());
		}
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
