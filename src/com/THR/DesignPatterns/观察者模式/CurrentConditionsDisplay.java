package com.THR.DesignPatterns.观察者模式;

public class CurrentConditionsDisplay implements Observer,DisplayElement {

   private float temperature;
   //定义该对象的意义在哪？图一中也有标出关联关系。。
   private Subject weatherData;

   public CurrentConditionsDisplay(Subject weatherData){
       //实例化之后又要用该对象干嘛？
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
