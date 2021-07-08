package PojoPayload;

public class Token {

	public String token;
	public String expires;
	public String status;
	public String result;
	
	public Token() {
		
	}
	public Token(String token, String expires, String status, String result) {
		super();
		this.token = token;
		this.expires = expires;
		this.status = status;
		this.result = result;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	

}
