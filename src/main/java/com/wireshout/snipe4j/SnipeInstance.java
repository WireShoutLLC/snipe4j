package com.wireshout.snipe4j;

import org.apache.http.client.HttpClient;

public class SnipeInstance {
	private String url;
	private String apiKey;
	private HttpClient connection;
	
	public SnipeInstance(String endpoint, String key) {
		url = endpoint;
		apiKey = key;
	}
}
