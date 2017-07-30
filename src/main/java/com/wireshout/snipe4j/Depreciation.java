package com.wireshout.snipe4j;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Depreciation extends SnipeObject {
	private String months;
	
	public Depreciation(SnipeInstance snipe, int id) {
		super(snipe, id, "depreciations");
		HashMap<String, Object> detail = refresh();
		if(detail.get("months") != null) {
			months = (String) detail.get("months");
		}
	}
	
	public Depreciation(SnipeInstance snipe, DepreciationFactory create) {
		super(snipe, create);
	}
}
