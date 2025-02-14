package com.Cache.entity;

import jakarta.persistence.*;

@Table
@Entity(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    private String forecast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public Weather(Long id, String city, String forecast) {
        this.id = id;
        this.city = city;
        this.forecast = forecast;
    }
            public Weather(){
        super();
            }
    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", forecast='" + forecast + '\'' +
                '}';
    }
}
