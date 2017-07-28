package com.wireshout.snipe4j;

import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AssetFactory extends SnipeObjectFactory {
	public static Asset get(SnipeInstance snipe, int id) {
		String response = snipe.makeGetRequest("hardware/" + id);
		JSONParser parser = new JSONParser();
		JSONObject assetResponse = null;
		try {
			assetResponse = (JSONObject) parser.parse(response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int assetID = (Integer) assetResponse.get("id");
		String assetName = (String) assetResponse.get("name");
		JSONObject assetCreatedAt = (JSONObject) assetResponse.get("created_at");
		JSONObject assetUpdatedAt = (JSONObject) assetResponse.get("updated_at");
		String createdString = (String) assetCreatedAt.get("datetime");
		String updatedString = (String) assetUpdatedAt.get("datetime");
		LocalDateTime created_at = SnipeDateTimeUtility.convert(createdString);
		LocalDateTime updated_at = SnipeDateTimeUtility.convert(updatedString);
		
		Asset result = new Asset(assetID, assetName, created_at, updated_at);
		
		return null;
	}
}
