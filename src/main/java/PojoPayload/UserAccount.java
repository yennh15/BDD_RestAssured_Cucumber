package PojoPayload;

import java.util.List;

public class UserAccount {
	
	public String userId;
	public String username;
	public List<Book> books; 
	
	public UserAccount() {
		
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	

	
}
