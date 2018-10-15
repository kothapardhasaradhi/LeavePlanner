package com.wipro.util;

public class StringUtil {

	public static String notNull(String value) {
		if (null == value) {
			value = "";
		}
		return value.trim();
	}
}
