
package de.eddykaya.openweather.entities.internal;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "main",
    "weather",
    "clouds",
    "wind",
    "sys",
    "dt_txt",
    "rain"
})
public class OpenWeatherCurrentWeatherList {

    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("main")
    private OpenWeatherMainProperties main;
    @JsonProperty("weather")
    private java.util.List<OpenWeatherWeather> weather = null;
    @JsonProperty("clouds")
    private OpenWeatherClouds clouds;
    @JsonProperty("wind")
    private OpenWeatherWind wind;
    @JsonProperty("sys")
    private OpenWeatherSys sys;
    @JsonProperty("dt_txt")
    private String dtTxt;
    @JsonProperty("rain")
    private OpenWeatherRain rain;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @JsonProperty("main")
    public OpenWeatherMainProperties getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(OpenWeatherMainProperties main) {
        this.main = main;
    }

    @JsonProperty("weather")
    public java.util.List<OpenWeatherWeather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(java.util.List<OpenWeatherWeather> weather) {
        this.weather = weather;
    }

    @JsonProperty("clouds")
    public OpenWeatherClouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(OpenWeatherClouds clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("wind")
    public OpenWeatherWind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(OpenWeatherWind wind) {
        this.wind = wind;
    }

    @JsonProperty("sys")
    public OpenWeatherSys getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(OpenWeatherSys sys) {
        this.sys = sys;
    }

    @JsonProperty("dt_txt")
    public String getDtTxt() {
        return dtTxt;
    }

    @JsonProperty("dt_txt")
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    @JsonProperty("rain")
    public OpenWeatherRain getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(OpenWeatherRain rain) {
        this.rain = rain;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
