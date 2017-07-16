
package com.github.eddykaya.openweather.entities.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "id",
    "name",
    "cod"
})
public class OpenWeatherExample {

    @JsonProperty("coord")
    private OpenWeatherCoord coord;
    @JsonProperty("weather")
    private List<OpenWeatherWeather> weather = null;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private OpenWeatherCurrentWeather main;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("wind")
    private OpenWeatherWind wind;
    @JsonProperty("clouds")
    private OpenWeatherClouds clouds;
    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("sys")
    private OpenWeatherSys sys;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("coord")
    public OpenWeatherCoord getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(OpenWeatherCoord coord) {
        this.coord = coord;
    }

    @JsonProperty("weather")
    public List<OpenWeatherWeather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<OpenWeatherWeather> weather) {
        this.weather = weather;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("main")
    public OpenWeatherCurrentWeather getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(OpenWeatherCurrentWeather main) {
        this.main = main;
    }

    @JsonProperty("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("wind")
    public OpenWeatherWind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(OpenWeatherWind wind) {
        this.wind = wind;
    }

    @JsonProperty("clouds")
    public OpenWeatherClouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(OpenWeatherClouds clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @JsonProperty("sys")
    public OpenWeatherSys getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(OpenWeatherSys sys) {
        this.sys = sys;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("cod")
    public Integer getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(Integer cod) {
        this.cod = cod;
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
