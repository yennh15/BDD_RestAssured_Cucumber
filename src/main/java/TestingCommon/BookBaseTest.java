package TestingCommon;

import configs.ConfigReader;

public class BookBaseTest {
	public final static String baseURI = ConfigReader.getInstance().getBaseUrl();
	private final static String  userName= ConfigReader.getInstance().getUserName();
	private final static String  password= ConfigReader.getInstance().getPassword();
	

	public static String getBaseURL() {
		return baseURI;
	}

	public static String getBaseURL(String resourcePath) {
		return baseURI+resourcePath;
	}
	
	public static String getUserName() {
		return userName;
	}
	public static String getPassword() {
		return password;
	}
}
