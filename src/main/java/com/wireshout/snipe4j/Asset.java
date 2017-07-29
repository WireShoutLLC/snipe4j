package com.wireshout.snipe4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class Asset extends SnipeObject implements Checkoutable {
	private String asset_tag;
	private String serial;
	private StatusLabel status_label;
	private Category category;
	private Model model;
	private String model_number;
	//private Manufacturer manufacturer; //This is found out based on Model
	private Supplier supplier;
	private String notes;
	private String order_number;
	private Company company; //TODO: this might be a problem in the API if it doesnt return an ID
	private Location location;
	private Location rtd_location; //TODO: Wat?
	private String image; //This is a URL
	private CheckoutLocation assigned_to;
	private String warranty; //This is a string "<n> months"
	private LocalDate warranty_expires; //Requires purchase_date to be set
	private LocalDate purchase_date;
	private LocalDateTime last_checkout;
	private LocalDate expected_checkin;
	private String purchase_cost;
	//custom_fields found out off of model
	
	//private boolean requestable; //This seems to have been removed?
	//TODO: assigned_to - need to figure out to what objects can an asset be checked out to
	
	public Asset(SnipeInstance snipe, int id) {
		super(snipe, id, "hardware");
		HashMap<String, Object> detail = refresh();
		if(detail.get("company") != null) {
			JSONObject obj =  (JSONObject) detail.get("company");
			Long tmpid = (Long) obj.get("id");
			company = new Company(snipe, tmpid.intValue());
		}
		if(detail.get("category") != null) {
			JSONObject obj =  (JSONObject) detail.get("category");
			Long tmpid = (Long) obj.get("id");
			category = new Category(snipe, tmpid.intValue());
		}
		if(detail.get("location") != null) {
			JSONObject obj =  (JSONObject) detail.get("location");
			Long tmpid = (Long) obj.get("id");
			location = new Location(snipe, tmpid.intValue());
		}
		if(detail.get("rtd_location") != null) {
			JSONObject obj =  (JSONObject) detail.get("rtd_location");
			Long tmpid = (Long) obj.get("id");
			rtd_location = new Location(snipe, tmpid.intValue());
		}
		if(detail.get("status_label") != null) {
			JSONObject obj =  (JSONObject) detail.get("status_label");
			Long tmpid = (Long) obj.get("id");
			status_label = new StatusLabel(snipe, tmpid.intValue());
		}
		/* This needs to get fixed in snipe since it's not a snipeobject type yet
		if(detail.get("model") != null) {
			JSONObject obj =  (JSONObject) detail.get("model");
			Long tmpid = (Long) obj.get("id");
			status_label = new Model(snipe, tmpid.intValue());
		}
		*/ 
		if(detail.get("supplier") != null) {
			JSONObject obj =  (JSONObject) detail.get("supplier");
			Long tmpid = (Long) obj.get("id");
			supplier = new Supplier(snipe, tmpid.intValue());
		}
		//TODO: impl asset_tag, serial, notes, order_number, image, assigned_to, warranty, warrenty_expires, purchase info, last_checkout, and expected_checkin
	}
	
	public Asset(SnipeInstance snipe, AssetFactory create) {
		super(snipe, create);
	}
}
