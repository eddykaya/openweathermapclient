package de.eddykaya.openweather;

import java.util.Locale;
import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.eddykaya.openweather.client.OpenWeatherClient;
import de.eddykaya.openweather.entities.external.CurrentWeather;

public class OpenWeatherClientTest {

	private static final String TEST_API_KEY = "d0e7eff721cf0870e5db46cc783b53e5";

	private OpenWeatherClient clientUnderTest;

	@BeforeMethod
	public void beforeMethod() {
		clientUnderTest = new OpenWeatherClient(TEST_API_KEY);
	}

	@Test
	public void returnsEmptyOptionalIfCityNotFound() {
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("Can't find this damn city",
			Locale.GERMANY);
		Assert.assertFalse(actualResponse.isPresent());
	}

	@Test
	public void returnsCurrentWeatherForExistingCity() {
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("London", Locale.UK);
		Assert.assertTrue(actualResponse.isPresent());
	}

}