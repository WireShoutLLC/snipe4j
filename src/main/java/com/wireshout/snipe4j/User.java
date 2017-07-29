package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class User extends SnipeObject {
	private String first_name;
	private String last_name;
	private String username;
	private String password; //You wont be able to see this obviously
	private String email;
	private boolean activated;
	private User manager; //manager. This returns an empty string when not assigned and a full block of info when it is assigned. Should be null when not assigned and just id and name when it is
	private Location location;
	private String phone; //Not returned in the API
	private String jobtitle;
	private Company company;
	private Department department;
	private String permissions; //This is weird...
	private String employee_num;
	private String notes;
	private Department department_id; //TODO: figure out if this is supported in the API
	private boolean two_factor_activated;
	/*
    "assets_count": 0,
    "licenses_count": 0,
    "accessories_count": 2,
    "consumables_count": 1,
    */
	private LocalDateTime last_login;
	private ArrayList<Group> groups;

	public User(SnipeInstance snipe, int id) {
		super(snipe, id, "users");
		HashMap<String, Object> detail = refresh();
		//TODO impl everything
		if(detail.get("manager") != null) {
			JSONObject obj =  (JSONObject) detail.get("manager");
			Long tmpid = (Long) obj.get("id");
			manager = new User(snipe, tmpid.intValue());
		}
		if(detail.get("location") != null) {
			JSONObject obj =  (JSONObject) detail.get("location");
			Long tmpid = (Long) obj.get("id");
			location = new Location(snipe, tmpid.intValue());
		}
		if(detail.get("company") != null) {
			JSONObject obj =  (JSONObject) detail.get("company");
			Long tmpid = (Long) obj.get("id");
			company = new Company(snipe, tmpid.intValue());
		}
		/* This needs fixed in the API
		if(detail.get("department") != null) {
			JSONObject obj =  (JSONObject) detail.get("department");
			Long tmpid = (Long) obj.get("id");
			department = new Department(snipe, tmpid.intValue());
		}
		*/
	}
	
	public User(SnipeInstance snipe, UserFactory create) {
		super(snipe, create);
	}
}
