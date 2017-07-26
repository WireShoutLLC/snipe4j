package com.wireshout.snipe4j;

import java.time.LocalDateTime;

public class Department {
	private int id;
	private String name;
	private Company company;
	private User manager;
	private Location location;
	private String users_count; //This should probably be an int
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
}
