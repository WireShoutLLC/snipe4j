package com.wireshout.snipe4j;

import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AssetFactory extends SnipeObjectFactory {
	public AssetFactory(String name) {
		super(name);
	}
	
	public Asset create(SnipeInstance snipe) {
		return (Asset) this.create(snipe, Asset.class);
	}
}
