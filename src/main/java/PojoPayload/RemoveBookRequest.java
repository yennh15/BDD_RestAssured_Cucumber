package PojoPayload;

public class RemoveBookRequest {

	public String isbn;
	public String userId;

	public RemoveBookRequest() {

	}

	public RemoveBookRequest(String isbn, String userId) {
		super();
		this.isbn = isbn;
		this.userId = userId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
