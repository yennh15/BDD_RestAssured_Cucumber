package TestingCommon;

public class BaseUrl {
	public final static String baseURI = "https://api.github.com";

	public static String getBaseURL() {
		return baseURI;
	}

	public static String getBaseURL(String resourcePath) {
		return baseURI+resourcePath;
	}
}
