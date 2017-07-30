package com.wireshout.snipe4j;

public class UserSet extends SnipeObjectSet {
	public UserSet(SnipeInstance snipe) {
		super(snipe, User.class, "users");
	}
}
