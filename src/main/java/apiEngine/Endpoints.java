package apiEngine;

import com.fasterxml.jackson.core.JsonProcessingException;

import PojoPayload.AuthorizationRequest;
import PojoPayload.ListOfBookForUser;
import PojoPayload.RemoveBookRequest;
import RestMethod.CommonRestMethod;
import configs.ConfigReader;
import io.restassured.response.Response;

public class Endpoints {
	
	public static Response authenticateUser(AuthorizationRequest authRequest) throws JsonProcessingException {
		return CommonRestMethod.postRequest("/Account/v1/GenerateToken",authRequest);
	}
	
	public static Response getBooks() throws JsonProcessingException {
		return CommonRestMethod.getRequest("/BookStore/v1/Books");
	}
	public static Response addBooks(ListOfBookForUser listOfBookForUser, String bearerToken) throws JsonProcessingException {
		return CommonRestMethod.postRequest("/BookStore/v1/Books", listOfBookForUser, bearerToken);
	}
	
	public static Response removeBook(RemoveBookRequest removeBookRequest, String bearerToken) throws JsonProcessingException {
		 return CommonRestMethod.deleteRequestWithPayload("/BookStore/v1/Book", removeBookRequest, bearerToken);
    }
 
    public static Response getUserAccount(String bearerToken) {
    	return CommonRestMethod.getRequestWithTokenAndParam("/Account/v1/User", bearerToken, ConfigReader.getInstance().getUserID());
    }
}
