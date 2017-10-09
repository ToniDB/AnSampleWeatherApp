package com.example.antonio.weatherapp.data;

import com.example.antonio.weatherapp.entities.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Antonio
 * on 09/10/2017.
 */

public interface WeatherService {
    @GET("weather")
    Call<Forecast> getWeatherByCountryName(@Query("q") String countryName,
                                           @Query("units") String units,
                                           @Query("appid") String apiKey);
}
