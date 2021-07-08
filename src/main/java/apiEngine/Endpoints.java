package apiEngine;

import com.fasterxml.jackson.core.JsonProcessingException;

import PojoPayload.AuthorizationRequest;
import PojoPayload.Books;
import PojoPayload.BooksISBN;
import PojoPayload.ISBNUserId;
import PojoPayload.ListOfBookForUser;
import PojoPayload.RemoveBookRequest;
import PojoPayload.Token;
import PojoPayload.UserAccount;
import RestMethod.CommonRestMethod;
import io.restassured.response.Response;

public class Endpoints {
	static Response response;

	public static IRestResponse<Token> authenticateUser(AuthorizationRequest authRequest)
			throws JsonProcessingException {
		response = CommonRestMethod.postRequest(Route.generateToken(), authRequest);
		return new RestResponse(Token.class, response);
	}

	public static IRestResponse<Books>  getBooks() throws JsonProcessingException {
		response = CommonRestMethod.getRequest(Route.books());
		return new RestResponse(Books.class, response);
	}

	public static IRestResponse<BooksISBN> addBooks(ListOfBookForUser listOfBookForUser, String bearerToken)
			throws JsonProcessingException {
		response =CommonRestMethod.postRequest(Route.books(), listOfBookForUser, bearerToken);
		return new RestResponse(BooksISBN.class, response);
	}

	public static Response removeBook(RemoveBookRequest removeBookRequest, String bearerToken)
			throws JsonProcessingException {
		return CommonRestMethod.deleteRequestWithPayload(Route.book(), removeBookRequest, bearerToken);
	}

	public static IRestResponse<UserAccount> getUserAccount(String bearerToken) {
		response= CommonRestMethod.getRequestWithToken(Route.userAccount(), bearerToken);
		return new RestResponse(UserAccount.class, response);
	}
}
