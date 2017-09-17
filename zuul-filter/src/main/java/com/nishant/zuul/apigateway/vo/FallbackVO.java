package com.nishant.zuul.apigateway.vo;

public class FallbackVO {

	private String clientID;
	private String requestedURL;
	private String message;

	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getRequestedURL() {
		return requestedURL;
	}
	public void setRequestedURL(String requestedURL) {
		this.requestedURL = requestedURL;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
