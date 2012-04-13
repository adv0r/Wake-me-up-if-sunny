package it.lize.wma.core;

import java.util.Date;

public class WeatherConditions {
	private String location;
	
	private String description;
	private int temp_c;
	private long currentTime;
	
	
	public WeatherConditions(String description, int temp_c,
			long currentTime,String location) {
		super();
		this.description = description;
		this.temp_c = temp_c;
		this.currentTime = currentTime;
		this.location = location;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTemp_c() {
		return temp_c;
	}
	public void setTemp_c(int temp_c) {
		this.temp_c = temp_c;
	}
	public Date getCurrentTime() {
		return new Date(currentTime);
	}
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
