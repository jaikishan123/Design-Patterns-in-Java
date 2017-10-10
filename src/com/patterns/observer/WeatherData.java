package com.patterns.observer;

import java.util.ArrayList;

public class WeatherData implements Subject {

	private ArrayList<Observer> observers;
	private float temprature;
	private float humidity;
	private float pressure;
	
    public WeatherData() {
		// TODO Auto-generated constructor stub
    	observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
     
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i= observers.indexOf(o);
		
		if(i>=0)
		{
			observers.remove(i);
		}

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<observers.size();i++)
		{
			Observer observer =(Observer)observers.get(i);
			observer.update(temprature, humidity, pressure);
		}

	}
	
	public void measurementsChanged()
	{
		notifyObservers();
	}
	
	public void setMeasurements(float temprature, float humidity, float pressure)
	{
		this.temprature=temprature;
		this.humidity=humidity;
		this.pressure=pressure;
		measurementsChanged();
	}

}
