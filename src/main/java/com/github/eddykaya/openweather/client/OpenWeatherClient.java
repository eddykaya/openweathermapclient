package com.github.eddykaya.openweather.client;

import java.net.URI;
import java.util.Locale;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.github.eddykaya.openweather.client.exceptions.ResourceNotFoundException;
import com.github.eddykaya.openweather.entities.external.CurrentWeather;
import com.github.eddykaya.openweather.entities.internal.OpenWeatherExample;

/**
 * A client that can query the openweathermap API for the current weather
 */
public class OpenWeatherClient {

	private final String apiKey;
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

			return Optional.of(CurrentWeather.builder().currentTemperature(forEntity.getBody().getMain().getTemp())
				.build());
		} catch (ResourceNotFoundException e) {
			return Optional.empty();
		}
	}

}
