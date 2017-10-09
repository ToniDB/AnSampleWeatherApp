package com.example.antonio.weatherapp.entities;

import java.util.List;

/**
 * Created by Antonio
 * on 09/10/2017.
 */
public class Forecast {

    private List<Weather> weather;
    private String base;
    private Main main;
    private long dt;
    private int id;
    private String name;
    private short cod;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getCod() {
        return cod;
    }

    public void setCod(short cod) {
        this.cod = cod;
    }

}
