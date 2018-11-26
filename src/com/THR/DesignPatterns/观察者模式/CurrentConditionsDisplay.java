package com.THR.DesignPatterns.�۲���ģʽ;

public class CurrentConditionsDisplay implements Observer,DisplayElement {

   private float temperature;
   //����ö�����������ģ�ͼһ��Ҳ�б��������ϵ����
   private Subject weatherData;

   public CurrentConditionsDisplay(Subject weatherData){
       //ʵ����֮����Ҫ�øö�����
       this.weatherData = weatherData;
       weatherData.registerObserver(this);
   }

    @Override
    public void display() {
        System.out.println("temp:" + temperature);
    }

    @Override
    public void update(float temp) {
        this.temperature = temp;
        display();
    }
}
