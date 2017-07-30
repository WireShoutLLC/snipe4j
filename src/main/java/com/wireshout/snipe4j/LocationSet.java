package com.wireshout.snipe4j;

public class LocationSet extends SnipeObjectSet {
	public LocationSet(SnipeInstance snipe) {
		super(snipe, Location.class, "locations");
	}
}
