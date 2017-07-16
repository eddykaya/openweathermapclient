package de.eddykaya.openweather;

import java.util.Locale;
import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.eddykaya.openweather.client.OpenWeatherClient;
import de.eddykaya.openweather.entities.external.CurrentWeather;

/**
 *
 */
public class OpenWeatherClientTest {

	private OpenWeatherClient clientUnderTest;

	@BeforeMethod
	public void beforeMethod() {
		clientUnderTest = new OpenWeatherClient("");
	}

	@Test
	public void returnsEmptyOptionalIfCityNotFound() {
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("Can't find this damn city",
			Locale.GERMANY);
		Assert.assertFalse(actualResponse.isPresent());
	}

	@Test
	public void returnsCurrentWeatherForExistingCity() {
		Optional<CurrentWeather> actualResponse = clientUnderTest.fetchCurrentWeatherAt("Karlsruhe", Locale.GERMANY);
		Assert.assertTrue(actualResponse.isPresent());
	}

}