package com.wireshout.snipe4j;

import java.time.LocalDateTime;

public class Manufacturer extends SnipeObject {
	private String url;
	private String support_url;
	private String support_phone;
	private String support_email;
	private int assets_count; //This is returned as a String, not an int (see also #3791)
	private int licenses_count; //This is returned as a String, not an int (see also #3791)
	private int consumables_count; //This is returned as a String, not an int (see also #3791)
	private int accessories_count; //This is returned as a String, not an int (see also #3791)
}
