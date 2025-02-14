package com.Cache.Repository;

import com.Cache.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather,Long> {

    //@Query( value = "SELECT w FROM Weather w WHERE w.city = :city")
    Optional<Weather> findByCity(@Param("city") String city);

    void deleteByCity(String city);
    //@Query("SELECT w FROM WEATHER w WHERE w.city = :city")
    //List<WEATHER> findByCity(@Param("city") String city);
}
