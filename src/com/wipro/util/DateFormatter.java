
	package com.wipro.util;

	public class DateFormatter {

	public static String validateDate(String date) {
	if (date.length() < 10) {
	int indexOf = date.indexOf("/");
	if (indexOf == 1) {
	date = "0".concat(date);
	} else {
	date = date.substring(0, (indexOf + 1)) + "0"
	+ date.substring((indexOf) + 1);
	}
	}
	return date;
	}
	}


