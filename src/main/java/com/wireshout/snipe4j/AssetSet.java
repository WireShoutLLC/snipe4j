package com.wireshout.snipe4j;

public class AssetSet extends SnipeObjectSet {
	public AssetSet(SnipeInstance snipe) {
		super(snipe, Asset.class, "hardware");
	}
}
