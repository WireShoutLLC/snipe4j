package com.wireshout.snipe4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	
	//private boolean requestable; //This seems to have been removed?
	//TODO: assigned_to - need to figure out to what objects can an asset be checked out to
	
	public Asset(SnipeInstance snipe, int id) {
		super(snipe, id);
	}
	
	public Asset(SnipeInstance snipe, AssetFactory create) {
		super(snipe, create);
	}
}
