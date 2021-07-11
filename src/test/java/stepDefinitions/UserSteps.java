package stepDefinitions;


import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import PojoPayload.ErrorResponse;
import PojoPayload.NewUserReponse;
import PojoPayload.UserRequest;
import TestingCommon.RestFWLogger;
import apiEngine.IRestResponse;
import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class UserSteps extends BaseStep{
	private  IRestResponse<NewUserReponse> userAccountResponse; 
	
	private  IRestResponse<ErrorResponse> errorResponse; 
	private  String userName; 
	
	public UserSteps(TestContext testContext) {
		
		super(testContext);
	}

	
	@When("I create user with username {string} and password {string}")
	public void i_create_user_with_username_and_password(String userName, String password) throws JsonProcessingException {
	
		RestFWLogger.info("I create user with username - "+ userName+ " password "+ password);
		UserRequest user = new UserRequest(userName, password);
		userAccountResponse = getEndPoints().createUser(user); 
		this.userName = userName; 
	}
	@Then("The user is created")
	public void the_user_is_created() {
		RestFWLogger.info("The user is created");
		Assert.assertEquals(201, userAccountResponse.getStatusCode());
		Assert.assertEquals(userName, userAccountResponse.getBody().username);
	}
	
	@When("I create existing user with username {string} and password {string}")
	public void i_create_existing_user_with_username_and_password(String userName, String password) throws JsonProcessingException {

		RestFWLogger.info("I create existing user with username - "+ userName+ " password "+ password);
		UserRequest user = new UserRequest(userName, password);
		errorResponse = getEndPoints().createUserError(user); 
		this.userName = userName; 
	}
	
	@Then("The user is not created")
	public void the_user_is_not_created() {
		RestFWLogger.info("The user is not created");
		Assert.assertEquals(406, errorResponse.getStatusCode());
		Assert.assertEquals(1204, errorResponse.getBody().code);
		Assert.assertEquals("User exists!", errorResponse.getBody().message);
	}


}
