Feature: Validate Adding Book and Deleting Book

Background: User generates token for Authorization
Given Starting Test Case "Verify Add book" 
Given I am authorized user


Scenario: the Authorized user can Add and Remove a book
Given A List of Books are available 
When I add a book to my reading list
Then The book is added 
When I remove a book from my reading list
Then The book is removed 
