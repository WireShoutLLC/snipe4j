package com.wireshout.snipe4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SnipeResponse {
	private HttpResponse response;
	private String body = null;
	
	public SnipeResponse(HttpResponse const_response) {
		response = const_response;
		System.out.println("Response Code: " + getResponseCode());
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			body = result.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Response Body: " + getResponseText());
	}
	
	private int getResponseCode() {
		return response.getStatusLine().getStatusCode();
	}
	
	private String getResponseText() {
		return body;
	}
	
	private boolean wasAPISuccess() {
		JSONParser parser = new JSONParser();
		JSONObject payload = null;
		try {
			payload = (JSONObject) parser.parse(getResponseText());
			if(payload.containsKey("status")) {
				String status = (String) payload.get("status");
				if(status.equals("success")) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean wasSuccessful() {
		if(getResponseCode() == 200 && wasAPISuccess()) {
			return true;
		} else {
			return false;
		}
	}
	
	public HttpResponse getHttp() {
		return response;
	}
	
	public int getPostID() {
		if(getResponseCode() == 200 && wasAPISuccess()) {
			try {
				JSONParser parser = new JSONParser();
				JSONObject fullresp = (JSONObject) parser.parse(getResponseText());
				JSONObject payload = (JSONObject) fullresp.get("payload");
				return ((Long) payload.get("id")).intValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return 0;
		} else {
			return 0;
		}
	}
}
