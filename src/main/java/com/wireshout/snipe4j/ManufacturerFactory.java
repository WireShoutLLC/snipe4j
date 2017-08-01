package com.wireshout.snipe4j;

public class ManufacturerFactory extends SnipeObjectFactory {
	public ManufacturerFactory(String name) {
		super(name);
	}
	
	public Manufacturer create(SnipeInstance snipe) {
		return (Manufacturer) this.create(snipe, Manufacturer.class);
	}
}
