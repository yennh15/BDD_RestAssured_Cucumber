package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import PojoPayload.AuthorizationRequest;
import PojoPayload.Book;
import PojoPayload.Books;
import PojoPayload.BooksISBN;
import PojoPayload.CollectionOfIsbns;
import PojoPayload.ListOfBookForUser;
import PojoPayload.ObjectManager;
import PojoPayload.Token;
import PojoPayload.UserAccount;
import TestingCommon.BookBaseTest;
import apiEngine.Endpoints;
import apiEngine.IRestResponse;
import configs.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class bookStepDefinitions {
	String payload;
	String jsonString;
	String bookId;

	Book book;

	Response response;
	
	private static Token tokenResponse;
	private static Books booksResponse; 
	private static IRestResponse<BooksISBN> addedBookResponse; 
	private static IRestResponse<UserAccount> userAccount; 

	@Given("I am authorized user")
	public void i_am_authorized_user() throws JsonProcessingException {
		System.setProperty("tenvironment", "dev");
		AuthorizationRequest authRequest = new AuthorizationRequest(BookBaseTest.getUserName(),
				BookBaseTest.getPassword());
		tokenResponse = Endpoints.authenticateUser(authRequest).getBody();

	}

	@Given("A List of Books are available")
	public void a_list_of_books_are_available() throws JsonMappingException, JsonProcessingException {
		booksResponse = Endpoints.getBooks().getBody();
		book = booksResponse.books.get(2);
	
	}

	@When("I add a book to my reading list")
	public void i_add_a_book_to_my_reading_list() throws JsonProcessingException {

		CollectionOfIsbns collectionOfIsbn = new CollectionOfIsbns(book.getIsbn());
		ArrayList<CollectionOfIsbns> collectionOfIsbns = new ArrayList<CollectionOfIsbns>();
		collectionOfIsbns.add(collectionOfIsbn);
		ListOfBookForUser listOfBookForUser = new ListOfBookForUser(ConfigReader.getInstance().getUserID(),
				collectionOfIsbns);

		addedBookResponse = Endpoints.addBooks(listOfBookForUser, tokenResponse.getToken());

	}

	@Then("The book is added")
	public void the_book_is_added() {
		Assert.assertTrue(addedBookResponse.isSuccessful());
		Assert.assertEquals(201, addedBookResponse.getStatusCode());
		Assert.assertEquals(book.getIsbn(), addedBookResponse.getBody().books.get(0).isbn);
	}

	@When("I remove a book from my reading list")
	public void i_remove_a_book_from_my_reading_list() throws JsonProcessingException {
		response = Endpoints
				.removeBook(ObjectManager.getRemoveBookRequest(book.getIsbn(), ConfigReader.getInstance().getUserID()), tokenResponse.token);
	}

	@Then("The book is removed")
	public void the_book_is_removed() {
		Assert.assertEquals(204, response.getStatusCode());
		userAccount = Endpoints.getUserAccount(tokenResponse.token);
		Assert.assertEquals(200, userAccount.getStatusCode());
		List<Book> books = userAccount.getBody().books;
		boolean check = false; 
		for (Book _book : books) {
			if (_book.isbn.equals(book.getIsbn())) {
				check = true; 
				break; 
			}
		}
		
		Assert.assertFalse(check);
	}

}
