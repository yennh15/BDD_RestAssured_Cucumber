Feature: Validate Create User


Scenario Outline: User can be created
When I create user with username "<userName>" and password "<password>"
Then The user is created

Examples: 
	| userName | password |
	| test123456789123 | Test1@11 | 
	| test1234567891234 | Test1@11 | 

Scenario Outline: Existing user can not be created
When I create existing user with username "<userName>" and password "<password>"
Then The user is not created

Examples: 
	| userName | password |
	| test123456789 | Test1@11 | 