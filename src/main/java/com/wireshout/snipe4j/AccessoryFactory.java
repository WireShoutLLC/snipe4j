package com.wireshout.snipe4j;

public class AccessoryFactory extends SnipeObjectFactory {
	public AccessoryFactory(String name) {
		super(name);
	}
	
	public Accessory create(SnipeInstance snipe) {
		return (Accessory) this.create(snipe, Accessory.class);
	}
}
