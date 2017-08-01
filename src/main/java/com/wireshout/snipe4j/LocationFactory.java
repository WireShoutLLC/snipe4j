package com.wireshout.snipe4j;

public class LocationFactory extends SnipeObjectFactory {
	public LocationFactory(String name) {
		super(name);
	}
	
	public Location create(SnipeInstance snipe) {
		return (Location) this.create(snipe, Location.class);
	}
}
