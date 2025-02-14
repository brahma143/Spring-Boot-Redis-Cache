package com.Cache.Service;

import com.Cache.Repository.WeatherRepository;
import com.Cache.entity.Weather;
//import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    //@Autowired
    private final WeatherRepository repository;

    public WeatherService(WeatherRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "weather")
    public String getWeatherByCity(String city){
        System.out.println("fetching  data from for city "+city);
        Optional<Weather> weather = repository.findByCity(city);

        return weather.map(Weather::getForecast).orElse("Weather data not avaliable");
    }

    @CachePut(value = "weather",key = "#city")
    public String updateWeather(String city, String weatherUpdate){
        if(city != null){
            repository.findByCity(city).ifPresent(weather ->{
                weather.setForecast(weatherUpdate);
                repository.save(weather);
            });

        }
        return weatherUpdate;
    }

    @Transactional
    @CacheEvict(value = "weather", key = "#city")
    public void deleteWeather(String city){
        System.out.println("Removing weather data for city: "+ city);

        repository.deleteByCity(city);
    }
}
