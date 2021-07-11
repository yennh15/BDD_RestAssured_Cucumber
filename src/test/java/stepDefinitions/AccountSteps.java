package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;

import PojoPayload.AuthorizationRequest;
import TestingCommon.BookBaseTest;
import TestingCommon.RestFWLogger;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;

public class AccountSteps extends BaseStep {
	public AccountSteps(TestContext testContext) {
		super(testContext);
	}

	@Given("I am authorized user")
	public void i_am_authorized_user() throws JsonProcessingException {
		// System.setProperty("tenvironment", "dev");
		AuthorizationRequest authRequest = new AuthorizationRequest(BookBaseTest.getUserName(),
				BookBaseTest.getPassword());
		RestFWLogger.info("Step I am authorized user");
		String token = getEndPoints().authenticateUser(authRequest).getBody().token;
		getScenarioContext().setContext(Context.TOKEN, token);
		
		
	}
}
