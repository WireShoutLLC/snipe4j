package com.wireshout.snipe4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Runner {
	public static void main(String[] args) throws Exception {
		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("snipe4j.properties");
		defaultProps.load(in);
		in.close();

		Properties applicationProps = new Properties(defaultProps);
		
		String apiEndpoint = applicationProps.getProperty("apiEndpoint");
		String apiKey = applicationProps.getProperty("apiKey");
		SnipeInstance mims = new SnipeInstance(apiEndpoint, apiKey);
		//Company singleCompany = new Company(mims, 3);
		Accessory singleAccessory = new Accessory(mims, 1);
	}
}
