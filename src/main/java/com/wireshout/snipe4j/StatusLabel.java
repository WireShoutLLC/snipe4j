package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class StatusLabel extends SnipeObject {
	private boolean deployable;
	private boolean pending;
	private boolean archived;
	private String color;
	private boolean show_in_nav;
	private String notes;
	

	private final static String ENDPOINT = "statuslabels";
	
	public StatusLabel(SnipeInstance snipe, int id) {
		super(snipe, id);
		HashMap<String, Object> detail = refresh(getEndpoint());
		if(detail.get("notes") != null) {
			notes = (String) detail.get("notes");
		}
		if(detail.get("color") != null) {
			color = (String) detail.get("color");
		}
		if(detail.get("deployable") != null) {
			if(detail.get("deployable") instanceof String) {
				deployable = Boolean.parseBoolean((String) detail.get("deployable"));
			} else {
				deployable = Boolean.parseBoolean(((Long) detail.get("deployable")).intValue() + "");
			}
		}
		if(detail.get("archived") != null) {
			if(detail.get("archived") instanceof String) {
				archived = Boolean.parseBoolean((String) detail.get("archived"));
			} else {
				archived = Boolean.parseBoolean(((Long) detail.get("archived")).intValue() + "");
			}
		}
		if(detail.get("pending") != null) {
			if(detail.get("pending") instanceof String) {
				pending = Boolean.parseBoolean((String) detail.get("pending"));
			} else {
				pending = Boolean.parseBoolean(((Long) detail.get("pending")).intValue() + "");
			}
		}
		if(detail.get("show_in_nav") != null) {
			if(detail.get("show_in_nav") instanceof String) {
				show_in_nav = Boolean.parseBoolean((String) detail.get("show_in_nav"));
			} else {
				show_in_nav = Boolean.parseBoolean(((Long) detail.get("show_in_nav")).intValue() + "");
			}
		}
		if(detail.get("type") != null) {
			String type = (String) detail.get("type");
			if(type.equals("undeployable")) {
				deployable = false;
				pending = false;
				archived = false;
			} else if(type.equals("deployable")) {
				deployable = true;
				pending = false;
				archived = false;
			} else if(type.equals("pending")) {
				deployable = false;
				pending = true;
				archived = false;
			} else if(type.equals("archived")) {
				deployable = false;
				pending = false;
				archived = true;
			} else {
				System.out.println("ERROR: Unknown status type.");
			}
		}
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
