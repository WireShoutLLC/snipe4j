package com.wireshout.snipe4j;

import org.apache.http.message.BasicNameValuePair;

public class StatusLabelFactory extends SnipeObjectFactory {
	public StatusLabelFactory(String name, boolean deployable, boolean pending, boolean archived) {
		super(name);
		super.add(new BasicNameValuePair("deployable", deployable + ""));
		super.add(new BasicNameValuePair("pending", pending + ""));
		super.add(new BasicNameValuePair("archived", archived + ""));
	}
	
	public void setColor(String color) {
		super.add(new BasicNameValuePair("color", color));
	}
	
	public void setShowInNav(boolean show) {
		super.add(new BasicNameValuePair("show_in_nav", show + ""));
	}
	
	public void setNotes(String notes) {
		super.add(new BasicNameValuePair("notes", notes));
	}
	
	public StatusLabel create(SnipeInstance snipe) {
		return (StatusLabel) this.create(snipe, StatusLabel.class);
	}
}
