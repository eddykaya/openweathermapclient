package com.github.eddykaya.openweather.client.exceptions;

/**
 * This exception is thrown if we can not find a resource on the openweathermap API (e.g. API responds with a 404 error)
 */
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
