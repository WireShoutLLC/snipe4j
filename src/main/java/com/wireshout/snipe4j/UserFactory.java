package com.wireshout.snipe4j;

public class UserFactory extends SnipeObjectFactory {
	public UserFactory(String name) {
		super(name);
	}
	
	public User create(SnipeInstance snipe) {
		return (User) this.create(snipe, User.class);
	}
}
