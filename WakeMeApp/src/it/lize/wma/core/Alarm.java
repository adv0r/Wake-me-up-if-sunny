package it.lize.wma.core;

import java.util.Date;
import java.util.Timer;

public class Alarm {
	private Date alarmTime;
	private String location;
	
	public Alarm(Date alarmTime,String location) {
		super();
		this.alarmTime = alarmTime;
		this.location = location;

	}

	public Date getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void schedule() {
		  AlarmTask at =  new AlarmTask(location);
		
		  //TODO remove
		  at.run();
		  
		  
		  Timer timer = new Timer();
		  timer.schedule(at,alarmTime.getTime() );

		
	}

}
