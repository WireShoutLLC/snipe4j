package com.wireshout.snipe4j;

public class ConsumableFactory extends SnipeObjectFactory {
	public ConsumableFactory(String name) {
		super(name);
	}
	
	public Consumable create(SnipeInstance snipe) {
		return (Consumable) this.create(snipe, Consumable.class);
	}
}
