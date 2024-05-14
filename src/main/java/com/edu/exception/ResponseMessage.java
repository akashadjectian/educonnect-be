package com.edu.exception;

public class ResponseMessage {
	String responseMessage;

	public String getresponseMessage() {
		return responseMessage;
	}

	public void setresponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "responseMessage [responseMessage=" + responseMessage + "]";
	}

	public ResponseMessage(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}

	public ResponseMessage() {
		super();
		
	}
		

}
