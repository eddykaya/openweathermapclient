package de.eddykaya.openweather.client;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import de.eddykaya.openweather.client.exceptions.ResourceNotFoundException;

/**
 *
 */
public class HttpClientErrorHandler implements ResponseErrorHandler {
	@Override
	public boolean hasError(final ClientHttpResponse response) throws IOException {
		return response.getStatusCode().equals(HttpStatus.NOT_FOUND);
	}

	@Override
	public void handleError(final ClientHttpResponse response) throws IOException {
		throw new ResourceNotFoundException(response.getStatusText());
	}
}
