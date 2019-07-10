package com.github.eddykaya.openweather.entities.external;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentWeather {

	private final double currentTemperature;
	private final TemperatureUnit temperatureUnit = TemperatureUnit.CELSIUS;
}
