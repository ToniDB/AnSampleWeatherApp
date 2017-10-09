package com.example.antonio.weatherapp.view.main;

import com.example.antonio.weatherapp.entities.Forecast;

/**
 * Created by Antonio
 * on 09/10/2017.
 */

public interface MainView {
    void showForecastLoadingProgress(boolean show);

    void onForecastLoaded(Forecast forecast);

    void onWeatherLoadFailed();
}
