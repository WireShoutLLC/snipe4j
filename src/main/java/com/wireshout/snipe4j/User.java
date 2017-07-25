package com.wireshout.snipe4j;

public class User extends CheckoutLocation {
	private int id;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String email;
	private boolean active;
	private String locale = "en";
	private User manager; //manager_id
	private Location location; //location_id
	private String phone;
	private String jobtitle;
	private Company company; //company_id
	private String employee_num;
	private String notes;
	private Department department_id; //TODO: figure out if this is supported in the API
}
