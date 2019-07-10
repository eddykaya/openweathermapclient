package com.github.eddykaya.openweather;

import java.util.Locale;
import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.eddykaya.openweather.client.OpenWeatherClient;
import com.github.eddykaya.openweather.entities.external.CurrentWeather;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class OpenWeatherClientTest {

	private static final String TEST_API_KEY = "d0e7eff721cf0870e5db46cc783b53e5";

	private OpenWeatherClient clientUnderTest;

	@BeforeMethod
	public void beforeMethod() {
		clientUnderTest = new OpenWeatherClient(TEST_API_KEY);
	}

	@Test
	public void returnsEmptyOptionalIfZipCodeNotFound() {
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("1111111",
			Locale.GERMANY);

		assertFalse(actualResponse.isPresent());
	}

	@Test
	public void returnsCurrentWeatherForExistingZipCode() {
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("76137", Locale.GERMANY);

		assertTrue(actualResponse.isPresent());
	}

	@Test
	public void returnsHumidity() {
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("76137", Locale.GERMANY);

		assertTrue(actualResponse.get().getHumidity() != 0);
	}

	@Test
	public void returnsPressure() {
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("76137", Locale.GERMANY);

		assertTrue(actualResponse.get().getPressure() != 0);
	}

	/**
	 * This test demonstrates that client works behind a proxy. It is disabled because I don't know if the proxy
	 * will exist forever, so if you need to test the proxy functionality provide your own proxy server.
	 */
	@Test(enabled = false)
	public void returnsCurrentWeatherForExistingZipCodeViaProxy() {
		clientUnderTest = new OpenWeatherClient(TEST_API_KEY, "61.6.41.111", 53281,"","");
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("76137", Locale.GERMANY);
		assertTrue(actualResponse.isPresent());
	}

}