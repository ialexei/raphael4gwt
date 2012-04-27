package org.sgx.espinillo.client.impl1.util;

public class Util {

	public static boolean notNull(Object o) {
		if(o==null||o.toString().equals(""))
			return false;
		else
			return true;
	}

	public static boolean isInteger(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Double parseDouble(String val,  double def) {
		try {
			return Double.parseDouble(val);
		} catch (Exception e) {
			return def;
		}
	}
	
	public static int parseInt(String val, int def) {
		try {
			return Integer.parseInt(val);
		} catch (Exception e) {
			return def;
		}
	}

	public static boolean isDouble(String val) {
		try {
			Double.parseDouble(val);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
}
