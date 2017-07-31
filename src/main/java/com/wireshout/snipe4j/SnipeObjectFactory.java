package com.wireshout.snipe4j;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public abstract class SnipeObjectFactory {
	private List<NameValuePair> fields;
	
	public SnipeObjectFactory() {
		fields = new ArrayList<NameValuePair>();
		fields.add(new BasicNameValuePair("name", ""));
	}
	
	public SnipeObjectFactory(String name) {
		fields = new ArrayList<NameValuePair>();
		fields.add(new BasicNameValuePair("name", name));
	}
	
	public SnipeObjectFactory(String name, List<NameValuePair> custom) {
		fields = new ArrayList<NameValuePair>();
		fields.add(new BasicNameValuePair("name", name));
		fields.addAll(custom);
	}
	
	protected SnipeObject create(SnipeInstance snipe, Class type) {
		SnipeObject create;
		try {
			String endpoint = (String) type.getMethod("getEndpoint").invoke(null, null);
			SnipeResponse response = snipe.makePostRequest(endpoint, fields);
			if(response.wasSuccessful()) {
				int id = response.getPostID();
				create = (SnipeObject) type.getConstructor(SnipeInstance.class, int.class).newInstance(snipe, id);
				return create;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	protected void add(NameValuePair field) {
		fields.add(field);
	}
}
