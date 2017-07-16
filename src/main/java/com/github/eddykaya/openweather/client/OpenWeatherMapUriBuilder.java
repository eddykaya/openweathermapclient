package com.github.eddykaya.openweather.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

class OpenWeatherMapUriBuilder {

	private static final String QUERY_PARAM_NAME = "q";

	private static final String OPENWEATHERMAP_BASE_URL = "http://api.openweathermap.org";

	private static final String OPENWEATHERMAP_API_PATH = "/data";

	private static final String API_KEY_PARAM = "APPID";

	private String apiVersion;

	private String forecastPath;

	private String apiKey;

	private List<String> queryParams = new ArrayList<>();

	OpenWeatherMapUriBuilder withVersion(final String apiVersion) {
		this.apiVersion = apiVersion;
		return this;
	}

	OpenWeatherMapUriBuilder withForecast() {
		forecastPath = "/weather";
		return this;
	}

	OpenWeatherMapUriBuilder withQuery(final String query) {
		queryParams.add(query);
		return this;
	}

	OpenWeatherMapUriBuilder withApiKey(final String apiKey) {
		this.apiKey = apiKey;
		return this;
	}

	URI toUri() {
		return UriComponentsBuilder
			.fromUriString(OPENWEATHERMAP_BASE_URL)
			.path(OPENWEATHERMAP_API_PATH)
			.path("/" + apiVersion)
			.path(forecastPath)
			.queryParam(QUERY_PARAM_NAME, getQueryParamsFormatted())
			.queryParam(API_KEY_PARAM, apiKey)
			.build().toUri();
	}

	private String getQueryParamsFormatted() {
		StringBuilder queryParamsFormatted = new StringBuilder();

		queryParams.forEach(q -> queryParamsFormatted.append(q + ","));

		return queryParamsFormatted.toString();
	}
}
