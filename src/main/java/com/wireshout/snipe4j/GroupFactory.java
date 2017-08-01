package com.wireshout.snipe4j;

public class GroupFactory extends SnipeObjectFactory {
	public GroupFactory(String name) {
		super(name);
	}
	
	public Group create(SnipeInstance snipe) {
		return (Group) this.create(snipe, Group.class);
	}
}
