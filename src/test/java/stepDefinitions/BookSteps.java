package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import PojoPayload.Book;
import PojoPayload.Books;
import PojoPayload.BooksISBN;
import PojoPayload.CollectionOfIsbns;
import PojoPayload.ListOfBookForUser;
import PojoPayload.ObjectManager;
import PojoPayload.UserAccount;
import TestingCommon.RestFWLogger;
import apiEngine.IRestResponse;
import configs.ConfigReader;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class BookSteps extends BaseStep {
	String payload;
	String jsonString;
	String bookId;
	String token; 
	Book book;

	Response response;
	private  Books booksResponse; 
	private  IRestResponse<BooksISBN> addedBookResponse; 
	private  IRestResponse<UserAccount> userAccount; 
	

	
	public BookSteps(TestContext testContext){
	     super(testContext);
	    }
	
	
	@Given("A List of Books are available")
	public void a_list_of_books_are_available() throws JsonMappingException, JsonProcessingException {
		RestFWLogger.info("Step A List of Books are available");
		booksResponse = getEndPoints().getBooks().getBody();
		book = booksResponse.books.get(2);
	
	}

	@When("I add a book to my reading list")
	public void i_add_a_book_to_my_reading_list() throws JsonProcessingException {
		RestFWLogger.info(" Step I add a book to my reading list");
		CollectionOfIsbns collectionOfIsbn = new CollectionOfIsbns(book.getIsbn());
		ArrayList<CollectionOfIsbns> collectionOfIsbns = new ArrayList<CollectionOfIsbns>();
		collectionOfIsbns.add(collectionOfIsbn);
		ListOfBookForUser listOfBookForUser = new ListOfBookForUser(ConfigReader.getInstance().getUserID(),
				collectionOfIsbns);
		token = getScenarioContext().getContext(Context.TOKEN).toString(); 
		addedBookResponse = getEndPoints().addBooks(listOfBookForUser,token );

	}

	@Then("The book is added")
	public void the_book_is_added() {
		RestFWLogger.info("Step The book is added");
		Assert.assertTrue(addedBookResponse.isSuccessful());
		Assert.assertEquals(201, addedBookResponse.getStatusCode());
		Assert.assertEquals(book.getIsbn(), addedBookResponse.getBody().books.get(0).isbn);
	}

	@When("I remove a book from my reading list")
	public void i_remove_a_book_from_my_reading_list() throws JsonProcessingException {
		response = getEndPoints()
				.removeBook(ObjectManager.getRemoveBookRequest(book.getIsbn(), ConfigReader.getInstance().getUserID()), token);
	}

	@Then("The book is removed")
	public void the_book_is_removed() {
		RestFWLogger.info("Step The book is removed");
		Assert.assertEquals(204, response.getStatusCode());
		userAccount = getEndPoints().getUserAccount(token);
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
