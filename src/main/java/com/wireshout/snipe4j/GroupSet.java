package com.wireshout.snipe4j;

public class GroupSet extends SnipeObjectSet {
	public GroupSet(SnipeInstance snipe) {
		super(snipe, Group.class, "groups");
	}
}
