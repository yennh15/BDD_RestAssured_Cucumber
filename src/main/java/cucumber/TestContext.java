package cucumber;

import apiEngine.Endpoints;
import configs.ConfigReader;
import enums.Context;

public class TestContext {
	private Endpoints endpoints;
	private ScenarioContext scenarioContext; 

	public TestContext() {
		System.setProperty("tenvironment", "dev");
		endpoints = new Endpoints();
		scenarioContext = new ScenarioContext(); 
		scenarioContext.setContext(Context.USER_ID, ConfigReader.getInstance().getUserID());
	}
	public Endpoints getEndpoints() {
		return endpoints; 
	}
	
	public ScenarioContext getScenarioContext() {
		 return scenarioContext;
		 }
}
