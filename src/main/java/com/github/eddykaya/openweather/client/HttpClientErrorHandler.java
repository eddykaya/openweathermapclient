package com.github.eddykaya.openweather.client;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import com.github.eddykaya.openweather.client.exceptions.ResourceNotFoundException;

class HttpClientErrorHandler implements ResponseErrorHandler {

	private ResponseErrorHandler defaultResponseErrorHandler = new DefaultResponseErrorHandler();

	@Override
	public boolean hasError(final ClientHttpResponse response) throws IOException {
		return defaultResponseErrorHandler.hasError(response);
	}

	@Override
	public void handleError(final ClientHttpResponse response) throws IOException {
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			throw new ResourceNotFoundException(response.getStatusText());
		} else {
			defaultResponseErrorHandler.handleError(response);
		}
	}
}
