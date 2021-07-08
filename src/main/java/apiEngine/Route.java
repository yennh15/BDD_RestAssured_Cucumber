package apiEngine;

import configs.ConfigReader;

public class Route {
	private static final String BOOKSTORE = "/BookStore";
	private static final String ACCOUNT = "/Account";
	private static final String VERSION = "/v1";

	public static String generateToken() {
		return ACCOUNT + VERSION + "/GenerateToken";
	}

	public static String books() {
		return BOOKSTORE + VERSION + "/Books";
	}

	public static String book() {
		return BOOKSTORE + VERSION + "/Book";
	}

	public static String userAccount() {
		return ACCOUNT + VERSION + "/User" + "/" + ConfigReader.getInstance().getUserID();
	}
}
