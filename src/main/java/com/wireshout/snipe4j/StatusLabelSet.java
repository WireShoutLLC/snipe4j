package com.wireshout.snipe4j;

public class StatusLabelSet extends SnipeObjectSet {
	public StatusLabelSet(SnipeInstance snipe) {
		super(snipe, StatusLabel.class, "statuslabels");
	}
}
