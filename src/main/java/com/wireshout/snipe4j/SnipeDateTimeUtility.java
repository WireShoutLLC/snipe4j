package com.wireshout.snipe4j;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SnipeDateTimeUtility {
	public static LocalDateTime convert(String snipeDateTime) {
		//Format is "YYYY-MM-DD HH:MM:SS"
		String[] contents = snipeDateTime.split(" ");
		String dateRaw = contents[0];
		String[] dateContents = dateRaw.split("-");
		int year = Integer.parseInt(dateContents[0]);
		int month = Integer.parseInt(dateContents[1]);
		int day = Integer.parseInt(dateContents[2]);
		String timeRaw = contents[1];
		String[] timeContents = timeRaw.split(":");
		int hour = Integer.parseInt(timeContents[0]);
		int minute = Integer.parseInt(timeContents[1]);
		int second = Integer.parseInt(timeContents[2]);
		
		LocalDateTime result = LocalDateTime.of(year, month, day, hour, minute, second);
		return result;
	}
}
