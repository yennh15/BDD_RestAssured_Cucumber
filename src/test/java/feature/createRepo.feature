Feature: Validate Create Repository & Delete Repository 

Scenario Outline: Verify Create Repo API 
	Given   Starting Test Case "Verify Create Repo API" 
	Given   Create Repo Payload with "<name>" and "<description>" 
	When    User calls "/user/repos" Post API Call with "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" Token 
	Then    API call got Successfully with status Code 201 
	And    Verify Repository "name" is "<name>" 
	And    Verify Repository "description" is "<description>" 
	And    Ending Test Case 

Examples: 
	| name | description |
	| YenTestRepo11x1 | This is Yen Test Repo | 
	| YenTestRepo111x1 | This is Yen Test Repo1 |	
		
Scenario Outline: Verify Delete Repo API 
	When User calls "/repos/" Delete API Call with "<name>" Repository name and "yen91study" user and  "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" Token 
	Then API call got Successfully with status Code 204 
	And Ending Test Case 

Examples: 
	| name | description |
	| YenTestRepo11x1 | This is Yen Test Repo | 
	| YenTestRepo111x1 | This is Yen Test Repo1 | 
