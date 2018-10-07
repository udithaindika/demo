package com.uditha.autogeneral.api;

public class ApiResponseMessage {
	public static final int ERROR = 1;
	public static final int INFO = 3;
	public static final int OK = 4;
	public static final int TOO_BUSY = 5;
	public static final int WARNING = 2;

	int code;
	String message;
	String type;

	public ApiResponseMessage(int code, String message) {
		this.code = code;
		switch (code) {
		case ERROR:
			setType("error");
			break;
		case WARNING:
			setType("warning");
			break;
		case INFO:
			setType("info");
			break;
		case OK:
			setType("ok");
			break;
		case TOO_BUSY:
			setType("too busy");
			break;
		default:
			setType("unknown");
			break;
		}
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getType() {
		return type;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setType(String type) {
		this.type = type;
	}
}
