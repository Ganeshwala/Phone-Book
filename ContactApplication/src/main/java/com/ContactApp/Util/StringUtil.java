package com.ContactApp.Util;

/*
 * This class contains utility methods related to String Operation
 */
public class StringUtil {

	public static String toCommaSeparatedString(Object[] items) {
		StringBuilder sb = new StringBuilder();
		for(Object o:items) {
			sb.append(o).append(",");
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
}
