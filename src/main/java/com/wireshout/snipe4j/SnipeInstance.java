package com.wireshout.snipe4j;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SnipeInstance {
	private String url;
	private String apiKey;
	
	public SnipeInstance(String endpoint, String key) {
		url = endpoint;
		apiKey = key;
	}
}
