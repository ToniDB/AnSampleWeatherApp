package com.example.antonio.weatherapp.domain;

import com.example.antonio.weatherapp.BuildConfig;
import com.example.antonio.weatherapp.data.ServiceGenerator;
import com.example.antonio.weatherapp.data.WeatherService;
import com.example.antonio.weatherapp.entities.Forecast;

import retrofit2.Call;

/**
 * Created by Antonio
 * on 09/10/2017.
 */
public class WeatherInteractor {

    private static final String CELCIUS = "metric";

    public Call<Forecast> getWeatherByCountryName(String countryName) {
        WeatherService service = ServiceGenerator.createService(WeatherService.class, BuildConfig.API_URL);
        return service.getWeatherByCountryName(countryName, CELCIUS, BuildConfig.API_KEY);
    }

}
