package com.THR.DesignPatterns.�۲���ģʽ;

public class WeatherStation {
    public static void main(String args[]){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        CurrentConditionsDisplay currentConditionsDisplay2 = new CurrentConditionsDisplay(weatherData);
        weatherData.setTemperature(123);
        weatherData.setTemperature(321);
    }
}
