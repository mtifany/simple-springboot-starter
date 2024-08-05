package ru.mtifany.service;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import com.github.prominence.openweathermap.api.request.weather.CurrentWeatherRequester;
import com.github.prominence.openweathermap.api.request.weather.single.SingleResultCurrentWeatherRequestTerminator;

public class WeatherService {
  private final String defaultCity;
  private final OpenWeatherMapClient client;

  public WeatherService(String defaultCity, OpenWeatherMapClient client) {
    this.defaultCity = defaultCity;
    this.client = client;
  }

  public String getWeather() {
    CurrentWeatherRequester requester = client.currentWeather();

    SingleResultCurrentWeatherRequestTerminator terminator = requester.single()
        .byCityName(defaultCity)
        .unitSystem(UnitSystem.METRIC)
        .retrieve();

    Weather weather = terminator.asJava();

    return weather.toString();
  }
}
