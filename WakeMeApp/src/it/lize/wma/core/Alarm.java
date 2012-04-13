package it.lize.wma.core;

import java.util.Calendar;
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
		  long current_time = Calendar.getInstance().getTimeInMillis();
		  long timeLeft = alarmTime.getTime()-current_time;
		  System.out.println("Alarm scheduled for " + new Date(alarmTime.getTime()));

		  if (timeLeft > 0)
		  {

			  AlarmTask at =  new AlarmTask(location);

			  int minutes = (int) ((timeLeft / (1000*60)) % 60);
			  int hours   = (int) ((timeLeft / (1000*60*60)) % 24);
			 	
			  Timer timer = new Timer();
			  
			  timer.schedule(at,new Date(alarmTime.getTime()));
			  System.out.println("Timeleft : "+hours+"h and "+minutes+" mins");
			  System.out.println("I will wake you up only if is sunny outside in "+location+"! Sleep tight!\n zzz...");

		  }
		  else System.out.println("Error:I can't wake you up in the past : alarm date and time has already passed");
		
	}

}
