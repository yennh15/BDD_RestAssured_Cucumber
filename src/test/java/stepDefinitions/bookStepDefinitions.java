package stepDefinitions;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import PojoPayload.AuthorizationRequest;
import PojoPayload.Book;
import PojoPayload.Books;
import PojoPayload.CollectionOfIsbns;
import PojoPayload.ListOfBookForUser;
import PojoPayload.ObjectManager;
import TestingCommon.BookBaseTest;
import TestingCommon.CommonUtilFunctions;
import apiEngine.Endpoints;
import configs.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;

public class bookStepDefinitions {
	String payload;
	Response authenticationResponse;
	String token;

	Response listBook;
	String jsonString;
	Book book; 
	Response addBook; 
	static String bookId;
	
	Response deleteBook; 
	
	private static Response response;
	@Given("I am authorized user")
	public void i_am_authorized_user() throws JsonProcessingException {
//		System.setProperty("tenvironment", "dev");
		
		AuthorizationRequest authRequest = new AuthorizationRequest(BookBaseTest.getUserName(), BookBaseTest.getPassword());
		authenticationResponse = Endpoints.authenticateUser(authRequest);
		token = CommonUtilFunctions.getResponseKeyValue(authenticationResponse.asString(), "token");
		System.out.println("This is token: " + token);
		
	}

	@Given("A List of Books are available")
	public void a_list_of_books_are_available() throws JsonMappingException, JsonProcessingException {
		listBook = Endpoints.getBooks();
		Books books = listBook.getBody().as(Books.class); 
		book = books.books.get(1);
		bookId = book.getIsbn(); 
	}

	@When("I add a book to my reading list")
	public void i_add_a_book_to_my_reading_list() throws JsonProcessingException {
		
		CollectionOfIsbns collectionOfIsbn = new CollectionOfIsbns(bookId); 
		ArrayList<CollectionOfIsbns>  collectionOfIsbns = new ArrayList<CollectionOfIsbns>(); 
		collectionOfIsbns.add(collectionOfIsbn); 
		ListOfBookForUser listOfBookForUser = new ListOfBookForUser(ConfigReader.getInstance().getUserID(),collectionOfIsbns); 
		
		addBook=Endpoints.addBooks(listOfBookForUser, token);
		
	}

	@Then("The book is added")
	public void the_book_is_added() {
		Assert.assertEquals(201, addBook.getStatusCode());
		
	}

	@When("I remove a book from my reading list")
	public void i_remove_a_book_from_my_reading_list() throws JsonProcessingException {
		deleteBook = Endpoints.removeBook(ObjectManager.getRemoveBookRequest(bookId, ConfigReader.getInstance().getUserID()), token); 
	}

	@Then("The book is removed")
	public void the_book_is_removed() {
		Assert.assertEquals(204, deleteBook.getStatusCode());
	}
	
}
