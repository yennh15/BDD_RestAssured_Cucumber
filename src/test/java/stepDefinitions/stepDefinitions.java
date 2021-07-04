package stepDefinitions;




import com.fasterxml.jackson.core.JsonProcessingException;

import PojoPayload.ObjectMapperCustom;
import PojoPayload.PojoManager;
import RestMethod.CommonRestMethod;
import TestingCommon.BaseUrl;
import TestingCommon.CommonUtilFunctions;
import TestingCommon.RestFWLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.*;

import org.junit.Assert; 

public class stepDefinitions extends CommonUtilFunctions{
	String payload;
	String endpoint;
	Response response; 

	@Given("Create Repo Payload with {string} and {string}")
	public void create_repo_payload(String name, String description) throws JsonProcessingException {
		payload = ObjectMapperCustom
				.ObjectMapper(PojoManager.getCreateRepoPOJOObject(name, description));
		
		System.out.println("This is the payload" + payload);
	}

	@When("User calls {string} Post API Call with {string} Token")
	public void user_calls_post_api_call(String directory, String token) {
		
		response = CommonRestMethod.postRequest(directory, payload, token);
	}

	@Then("API call got Successfully with status Code {int}")
	public void api_call_got_successfully_with_status_code(Integer status) {
		Assert.assertEquals(Integer.valueOf(status), Integer.valueOf(response.getStatusCode()));
	
	}

	@Then("Verify Repository {string} is {string}")
	public void verify_created(String jsonKey, String jsonValue) {
		System.out.println(response.getBody().asString());
		Assert.assertEquals(jsonValue, CommonUtilFunctions.getResponseKeyValue(response.getBody().asString(), jsonKey));
	}
	
	
	@When("User calls {string} Delete API Call with {string} Repository name and {string} user and  {string} Token")
	public void user_calls_delete_api_call_with_repo_name_and_token(String endpoint, String repoName, String userName, String token) {
		response = CommonRestMethod.deleteRequest(endpoint+userName+"/"+repoName,token);
	}
	
	@Given("Starting Test Case {string}")
	public void starting_test_case(String testCaseName) {
	    RestFWLogger.initLogger();
	    RestFWLogger.startTestCase(testCaseName);
	}
	@Then("Ending Test Case")
	public void ending_test_case() {
		RestFWLogger.endTestCase();
	}
	
	
	
	

}
