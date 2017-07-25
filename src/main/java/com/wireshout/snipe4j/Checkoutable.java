package com.wireshout.snipe4j;

public abstract interface Checkoutable {
	public boolean checkout(CheckoutLocation location);
	public boolean checkin();
	public void refresh();
}
