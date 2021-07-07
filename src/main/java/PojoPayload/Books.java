package PojoPayload;

import java.util.List;

public class Books {

	public List<Book> books;
	
	public Books() {
	
	}

	public Books(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
