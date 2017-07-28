package com.wireshout.snipe4j;

import java.time.LocalDateTime;

public class Department extends SnipeObject {
	private Company company;
	private User manager;
	private Location location;
	private String users_count; //This should probably be an int
	
}
