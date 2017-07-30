package com.wireshout.snipe4j;

public class ConsumableSet extends SnipeObjectSet {
	public ConsumableSet(SnipeInstance snipe) {
		super(snipe, Consumable.class, "consumables");
	}
}
