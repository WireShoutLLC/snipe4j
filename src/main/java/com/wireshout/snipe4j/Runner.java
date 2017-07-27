package com.wireshout.snipe4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Runner {
	public static void main(String[] args) throws Exception {
		// create and load default properties
		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("snipe4j.properties");
		defaultProps.load(in);
		in.close();

		// create application properties with default
		Properties applicationProps = new Properties(defaultProps);
		
		String apiEndpoint = applicationProps.getProperty("apiEndpoint");
		String apiKey = applicationProps.getProperty("apiKey");
		SnipeInstance mims = new SnipeInstance(apiEndpoint, apiKey);
		AssetList allAssets = mims.getAssets();
	}
}
