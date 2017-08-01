package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class StatusLabel extends SnipeObject {
	private StatusLabelType type;
	private String color;
	private boolean show_in_nav;
	private String notes;
	

	private final static String ENDPOINT = "statuslabels";
	
	public StatusLabel(SnipeInstance snipe, int id) {
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
