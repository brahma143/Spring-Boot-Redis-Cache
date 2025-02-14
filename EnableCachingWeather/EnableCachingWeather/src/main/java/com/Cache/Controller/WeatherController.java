package com.Cache.Controller;

import com.Cache.Repository.WeatherRepository;
import com.Cache.Service.CacheInspectionService;
import com.Cache.Service.WeatherService;
import com.Cache.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController()
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CacheInspectionService cacheInspectionService;

    @GetMapping
    public String getWeather(@RequestParam String city){
        String weatherStr =  weatherService.getWeatherByCity(city);

        return weatherStr;
    }
    @PostMapping
    public Weather addWeather(@RequestBody Weather weather){
            return weatherRepository.save(weather);
    }
    @GetMapping("/all")
    public List<Weather> getAllWeather(){
     return weatherRepository.findAll();
    }

    @GetMapping("/cacheData")
    public void getCacheData(){
        cacheInspectionService.printCacheContents("weather");
    }

    @PutMapping("/{city}")
    public String updateWeather(@PathVariable String city, @RequestParam String weatherUpdate){

        return weatherService.updateWeather(city, weatherUpdate);
    }

    @DeleteMapping("/{city}")
    public String deleteWeather(@PathVariable String city){
        weatherService.deleteWeather(city);
        return "weather data for "+ city +" has been deleted successfully cache evicted";
    }
}
