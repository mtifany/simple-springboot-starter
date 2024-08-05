package ru.mtifany.openweathermapapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mtifany.service.WeatherService;


@RestController
@RequestMapping(path = "/api/v1/weather")
public class WeatherController {
  @Autowired
  private final WeatherService weatherService;

  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping
  public String getWeather() {
    return weatherService.getWeather();
  }
}
