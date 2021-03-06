package RestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;

import PojoPayload.ObjectMapperCustom;
import TestingCommon.BaseUrl;
import TestingCommon.BookBaseTest;
import TestingCommon.RestFWLogger;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonRestMethod {
	public Response getRequest(String requestURI) {
		RestFWLogger.info("Base URL is - " + BookBaseTest.getBaseURL());
		RestFWLogger.info("Resouce path is - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(BookBaseTest.getBaseURL(requestURI));
		RestFWLogger.info("Response is - " + response.getBody().asString());
		return response;
	}

	public Response getRequestWithToken(String requestURI, String bearerToken) {
		RestFWLogger.info("Base URL is - " + BookBaseTest.getBaseURL());
		RestFWLogger.info("Resouce path is - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.get(BookBaseTest.getBaseURL(requestURI));
		RestFWLogger.info("Response is - " + response.getBody().asString());
		return response;
	}

	public Response postRequest(String requestURI, Object requestPayLoad) throws JsonProcessingException {
		RestFWLogger.info("Base URL is - " + BookBaseTest.getBaseURL());
		RestFWLogger.info("Resouce path is - " + requestURI);
		RestFWLogger.info("Request payload is - " + ObjectMapperCustom.ObjectMapper(requestPayLoad));
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(BookBaseTest.getBaseURL(requestURI));
		RestFWLogger.info("Response is - " + response.getBody().asString());
		return response;
	}

	public Response postRequest(String requestURI, Object requestPayLoad, String bearerToken)
			throws JsonProcessingException {
		RestFWLogger.info("Base URL is - " + BookBaseTest.getBaseURL());
		RestFWLogger.info("Resouce path is - " + requestURI);
		RestFWLogger.info("Request payload is - " + ObjectMapperCustom.ObjectMapper(requestPayLoad));
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.post(BookBaseTest.getBaseURL(requestURI));
		RestFWLogger.info("Resouce path is - " + response.getBody().asString());
		return response;
	}

	public Response putRequest(String requestURI, String requestPayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		return response;
	}

	public  Response deleteRequest(String requestURI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}

	public  Response deleteRequestWithPayload(String requestURI, String requestPayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}

	public  Response deleteRequest(String requestURI, String bearerToken) {
		RestFWLogger.info("Base URL is - " + BaseUrl.getBaseURL());
		RestFWLogger.info("Resouce path is - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.delete(BaseUrl.getBaseURL(requestURI));
		return response;
	}

	public  Response deleteRequestWithPayload(String requestURI, Object requestPayLoad, String bearerToken)
			throws JsonProcessingException {
		RestFWLogger.info("Base URL is - " + BaseUrl.getBaseURL());
		RestFWLogger.info("Resouce path is - " + requestURI);
		RestFWLogger.info("Request payload is - " + ObjectMapperCustom.ObjectMapper(requestPayLoad));
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.delete(BookBaseTest.getBaseURL(requestURI));
		RestFWLogger.info("Response path is - " + response.getBody().asString());
		return response;
	}
}
