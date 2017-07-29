package com.wireshout.snipe4j;

import java.time.LocalDateTime;

abstract class SnipeObject {
	private SnipeInstance snipe;
	private int id;
	private String name;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	protected SnipeObject(SnipeInstance conn_snipe, int const_id) {
		snipe = conn_snipe;
		setId(const_id);
	}

	public SnipeObject(SnipeInstance conn_snipe, SnipeObjectFactory create) {
		snipe = conn_snipe;
	}

	public int getId() {
		return id;
	}

	private int setId(int id) {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean setName(String name) {
		//TODO
		return false;
	}
	
	public LocalDateTime getCreatedAt() {
		//SnipeDateTimeUtility.convert(createdString)
		return created_at;
	}
	
	public LocalDateTime getUpdatedAt() {
		//SnipeDateTimeUtility.convert(updatedString)
		return updated_at;
	}
}
