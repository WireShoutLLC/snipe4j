package com.wireshout.snipe4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SnipeInstance {
	private String url;
	private String apiKey;
	
	public SnipeInstance(String endpoint, String key) {
		url = endpoint;
		apiKey = key;
	}

	public AssetList getAssets() {
		AssetList resultList = new AssetList();
		try {
			HttpResponse response;
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url + "/hardware");

			request.addHeader("Authorization", "Bearer " + apiKey);
			request.addHeader("Accept", "application/json");
			
			response = client.execute(request);

			System.out.println("Response Code : "
			                + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
}
