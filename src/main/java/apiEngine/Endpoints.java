package apiEngine;

import com.fasterxml.jackson.core.JsonProcessingException;

import PojoPayload.AuthorizationRequest;
import PojoPayload.Books;
import PojoPayload.BooksISBN;
import PojoPayload.ErrorResponse;
import PojoPayload.ListOfBookForUser;
import PojoPayload.NewUserReponse;
import PojoPayload.RemoveBookRequest;
import PojoPayload.Token;
import PojoPayload.UserAccount;
import PojoPayload.UserRequest;
import RestMethod.CommonRestMethod;
import io.restassured.response.Response;

public class Endpoints {
	Response response;
	CommonRestMethod commonRestMethod ;
	public  Endpoints() {
		
		commonRestMethod = new CommonRestMethod(); 
	}

	public  IRestResponse<Token> authenticateUser(AuthorizationRequest authRequest)
			throws JsonProcessingException {
		response = commonRestMethod.postRequest(Route.generateToken(), authRequest);
		return new RestResponse<Token>(Token.class, response);
	}

	public  IRestResponse<Books>  getBooks() throws JsonProcessingException {
		response = commonRestMethod.getRequest(Route.books());
		return new RestResponse<Books>(Books.class, response);
	}

	public  IRestResponse<BooksISBN> addBooks(ListOfBookForUser listOfBookForUser, String bearerToken)
			throws JsonProcessingException {
		response =commonRestMethod.postRequest(Route.books(), listOfBookForUser, bearerToken);
		return new RestResponse<BooksISBN>(BooksISBN.class, response);
	}

	public  Response removeBook(RemoveBookRequest removeBookRequest, String bearerToken)
			throws JsonProcessingException {
		return commonRestMethod.deleteRequestWithPayload(Route.book(), removeBookRequest, bearerToken);
	}

	public  IRestResponse<UserAccount> getUserAccount(String bearerToken) {
		response= commonRestMethod.getRequestWithToken(Route.userAccount(), bearerToken);
		return new RestResponse<UserAccount>(UserAccount.class, response);
	}
	
	public  IRestResponse<NewUserReponse> createUser(UserRequest requestPayLoad) throws JsonProcessingException {
		response= commonRestMethod.postRequest(Route.newUser(), requestPayLoad);
		return new RestResponse<NewUserReponse>(NewUserReponse.class, response);
	}
	
	public  IRestResponse<ErrorResponse> createUserError(UserRequest requestPayLoad) throws JsonProcessingException {
		response= commonRestMethod.postRequest(Route.newUser(), requestPayLoad);
		return new RestResponse<ErrorResponse>(ErrorResponse.class, response);
	}
}
