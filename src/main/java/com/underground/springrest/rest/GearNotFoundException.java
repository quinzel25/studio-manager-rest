package com.underground.springrest.rest;

public class GearNotFoundException extends RuntimeException{
	public GearNotFoundException() {
	}

	public GearNotFoundException(String message) {
		super(message);
	}

	public GearNotFoundException(Throwable cause) {
		super(cause);
	}

	public GearNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public GearNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


}
