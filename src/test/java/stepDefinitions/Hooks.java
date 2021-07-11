package stepDefinitions;

import TestingCommon.RestFWLogger;
import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void BeforeSteps() {
		  RestFWLogger.initLogger();
		  RestFWLogger.startTestCase();
	}

	@After
	public void AfterSteps() {
		RestFWLogger.endTestCase();
	}

}
