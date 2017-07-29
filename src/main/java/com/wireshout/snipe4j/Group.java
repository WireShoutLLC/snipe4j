package com.wireshout.snipe4j;

import java.time.LocalDateTime;

public class Group extends SnipeObject {
	private String permissions; //JSON object
	private int users_count;
	

	public Group(SnipeInstance snipe, int id) {
		super(snipe, id, "groups");
		refresh();
		//TODO: impl everything
	}
	
	public Group(SnipeInstance snipe, GroupFactory create) {
		super(snipe, create);
	}
}
