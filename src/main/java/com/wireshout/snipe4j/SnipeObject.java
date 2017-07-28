package com.wireshout.snipe4j;

import java.time.LocalDateTime;

abstract class SnipeObject {
	private int id;
	private String name;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	protected SnipeObject(int const_id, String const_name, LocalDateTime const_created_at, LocalDateTime const_updated_at) {
		id = const_id;
		name = const_name;
		created_at = const_created_at;
		updated_at = const_updated_at;
	}

	public int getId() {
		return id;
	}
	
	public int getName() {
		return name;
	}
	
	public boolean setName(String name) {
		return false;
	}
	
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
}
