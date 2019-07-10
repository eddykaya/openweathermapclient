package com.github.eddykaya.openweather.client;

import java.net.URI;
import java.util.Locale;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.github.eddykaya.openweather.client.exceptions.ResourceNotFoundException;
import com.github.eddykaya.openweather.entities.external.CurrentWeather;
import com.github.eddykaya.openweather.entities.internal.OpenWeatherExample;

/**
 * A client that can query the openweathermap API for the current weather
 */
public class OpenWeatherClient {

	private final String apiKey;

	private final RestTemplateFactory restTemplateFactory = new RestTemplateFactory();

	private RestTemplate restTemplate;

	/**
	 * You need to provide a API Key to access the openweathermap API, see https://openweathermap.org/api
	 * @param apiKey a valid API Key
	 */
	public OpenWeatherClient(String apiKey) {
		this.apiKey = apiKey;
		this.restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new HttpClientErrorHandler());
	}

	/**
	 * This constructor enforces usage of a http proxy with authentication
	 * @param apiKey your openweathermap API Key
	 * @param httpProxyHost the host of your http proxy, not <code>null</code>
	 * @param httpProxyPort the port of your http proxy, not <code>null</code>
	 * @param httpProxyUser the username of your http proxy, not <code>null</code>
	 * @param httpProxyPass the password of your http proxy, not <code>null</code>
	 */
	public OpenWeatherClient(String apiKey, String httpProxyHost, int httpProxyPort, String httpProxyUser, String
		httpProxyPass) {
		this(apiKey);

		SimpleClientHttpRequestFactory requestFactory = restTemplateFactory.getRequestFactoryWithProxyAuth(
			httpProxyHost, httpProxyPort,
			httpProxyUser, httpProxyPass);

		restTemplate = new RestTemplate(requestFactory);
		restTemplate.setErrorHandler(new HttpClientErrorHandler());
	}

	/**
	 * Fetches the current weather at the given zipCode in the given locale
	 * @param zipCode the zipCode you want to query
	 * @param country the country where the zipCode is in.
	 * @return a {@link Optional} providing either the current weather. It is empty if the zipCode could not be found.
	 */
	public Optional<CurrentWeather> fetchCurrentWeatherAt(String zipCode, Locale country) {
		Optional<CurrentWeather> response;

		response = findWeatherForCurrentCityAtOpenweathermap(zipCode, country.getCountry());

		return response;
	}

	private Optional<CurrentWeather> findWeatherForCurrentCityAtOpenweathermap(final String zipCode, final String
		countryCode) {
		URI requestUri = new OpenWeatherMapUriBuilder()
			.withVersion("2.5")
			.withApiKey(apiKey)
			.withForecast()
			.withQuery(zipCode)
			.withQuery(countryCode)
			.toUri();

		try {
			ResponseEntity<OpenWeatherExample> forEntity = restTemplate.getForEntity(requestUri, OpenWeatherExample.class);

			OpenWeatherExample body = forEntity.getBody();

			return Optional.of(CurrentWeather.builder()
					.currentTemperature(body.getMain().getTemp())
					.humidity(body.getMain().getHumidity())
					.pressure(body.getMain().getPressure())
				.build());
		} catch (ResourceNotFoundException e) {
			return Optional.empty();
		}
	}

}
