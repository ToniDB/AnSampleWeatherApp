package com.example.antonio.weatherapp.view.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antonio.weatherapp.R;
import com.example.antonio.weatherapp.entities.Forecast;
import com.example.antonio.weatherapp.presenter.main.MainPresenter;
import com.example.antonio.weatherapp.presenter.main.MainPresenterImpl;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    private TextView tvwText;
    private ProgressBar pgbLoadingData;
    private Button btnRequestData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUi();
        presenter = new MainPresenterImpl(this);
    }

    @Override
    public void showForecastLoadingProgress(boolean show) {
        pgbLoadingData.setVisibility(show ? View.VISIBLE : View.GONE);
        btnRequestData.setEnabled(!show);
    }

    @Override
    public void onForecastLoaded(Forecast forecast) {
        tvwText.setText(String.format(Locale.getDefault(), "%s %.2f\u2103", forecast.getName(),
                forecast.getMain().getTemp()));
    }

    @Override
    public void onWeatherLoadFailed() {
        Toast.makeText(this, R.string.failed_retrieving_data, Toast.LENGTH_LONG).show();
    }

    private void setupUi() {
        tvwText = (TextView) findViewById(R.id.activity_main_tvw_hello_world);
        pgbLoadingData = (ProgressBar) findViewById(R.id.activity_main_pgb_loading_data);
        btnRequestData = (Button) findViewById(R.id.activity_main_btn_request_data);
        setupListeners();
    }

    private void setupListeners() {
        btnRequestData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getWeatherByCountryName("Brazil");
            }
        });
    }

}
