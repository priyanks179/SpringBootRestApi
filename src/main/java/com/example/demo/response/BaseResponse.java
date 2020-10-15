package com.example.demo.response;


public class BaseResponse {
	protected int status;
	protected String message;
	public BaseResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
	public BaseResponse() {
		// TODO Auto-generated constructor stub
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
