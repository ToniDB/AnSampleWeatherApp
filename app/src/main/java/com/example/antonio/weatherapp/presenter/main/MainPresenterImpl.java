package com.example.antonio.weatherapp.presenter.main;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.antonio.weatherapp.domain.WeatherInteractor;
import com.example.antonio.weatherapp.entities.Forecast;
import com.example.antonio.weatherapp.view.main.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Antonio
 * on 09/10/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private WeatherInteractor weatherInteractor;
    private MainView view;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        this.weatherInteractor = new WeatherInteractor();
    }

    @Override
    public void getWeatherByCountryName(String countryName) {
        view.showForecastLoadingProgress(true);
        weatherInteractor.getWeatherByCountryName(countryName)
                .enqueue(new Callback<Forecast>() {
                    @Override
                    public void onResponse(@NonNull Call<Forecast> call, @NonNull Response<Forecast> response) {
                        view.onForecastLoaded(response.body());
                        view.showForecastLoadingProgress(false);
                    }

                    @Override
                    public void onFailure(@NonNull Call<Forecast> call, @NonNull Throwable t) {
                        Log.e(this.getClass().getName(), t.getMessage(), t);
                        view.onWeatherLoadFailed();
                        view.showForecastLoadingProgress(false);
                    }
                });
    }

}
