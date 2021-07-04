package RestMethod;

import TestingCommon.BaseUrl;
import TestingCommon.RestFWLogger;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonRestMethod {
	public static Response getRequest(String requestURI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		return response;
	}

	public static Response postRequest(String requestURI, String requestPayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		return response;
	}

	public static Response postRequest(String requestURI, String requestPayLoad, String bearerToken) {
		RestFWLogger.info("Base URL is - " + BaseUrl.getBaseURL());
		RestFWLogger.info("Resouce path is - "+ requestURI);
		RestFWLogger.info("Request payload is - "+ requestPayLoad);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.post(BaseUrl.getBaseURL(requestURI));
		RestFWLogger.info("Resouce path is - "+ response.getBody().asString());
		return response;
	}

	public static Response putRequest(String requestURI, String requestPayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		return response;
	}

	public static Response deleteRequest(String requestURI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}

	public static Response deleteRequestWithPayload(String requestURI, String requestPayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}

	public static Response deleteRequest(String requestURI, String bearerToken) {
		RestFWLogger.info("Base URL is - " + BaseUrl.getBaseURL());
		RestFWLogger.info("Resouce path is - "+ requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.delete(BaseUrl.getBaseURL(requestURI));
		return response;
	}
}
