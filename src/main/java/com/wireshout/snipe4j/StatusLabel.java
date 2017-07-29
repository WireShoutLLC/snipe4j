package com.wireshout.snipe4j;

import java.time.LocalDateTime;

public class StatusLabel extends SnipeObject {
	private StatusLabelType type;
	private String color;
	private boolean show_in_nav;
	private String notes;
	
	public StatusLabel(SnipeInstance snipe, int id) {
		super(snipe, id, "statuslabels");
		refresh();
		//impl everything 
	}
	
	public StatusLabel(SnipeInstance snipe, StatusLabelFactory create) {
		super(snipe, create);
	}
}
