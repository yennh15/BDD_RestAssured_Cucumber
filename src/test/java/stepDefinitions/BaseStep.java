package stepDefinitions;

import apiEngine.Endpoints;
import cucumber.ScenarioContext;
import cucumber.TestContext;

public class BaseStep {
	private Endpoints endpoints;
	private ScenarioContext scenarioContext;
	 
    public BaseStep(TestContext testContext) {
    	
    	endpoints = testContext.getEndpoints();
    	scenarioContext = testContext.getScenarioContext();
    	
    }
 
    public Endpoints getEndPoints() {
        return endpoints;
    }
    
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
