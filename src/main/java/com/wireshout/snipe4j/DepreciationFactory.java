package com.wireshout.snipe4j;

public class DepreciationFactory extends SnipeObjectFactory {
	public DepreciationFactory(String name) {
		super(name);
	}
	
	public Depreciation create(SnipeInstance snipe) {
		return (Depreciation) this.create(snipe, Depreciation.class);
	}
}
