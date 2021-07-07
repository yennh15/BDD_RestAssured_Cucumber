package TestingCommon;

import io.restassured.path.json.JsonPath;

public class CommonUtilFunctions {
	public static JsonPath jsonPath;
	
	
	public static String getResponseKeyValue(String response_body, String response_key) {
		jsonPath = new JsonPath(response_body); 
		return jsonPath.get(response_key);
	}
}
