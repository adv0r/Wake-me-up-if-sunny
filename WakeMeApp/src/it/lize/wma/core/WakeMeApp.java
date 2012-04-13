package it.lize.wma.core;

import it.lize.wma.global.Global;
import it.lize.wma.net.WeatherService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WakeMeApp {

	
	public static void main(String[] args)
	{
		if (args.length==2 && args[1].length()==16)
		{
		String city = args[0];
		String date_time = args[1];
		
		DateFormat df = new SimpleDateFormat(Global.DATA_FORMAT);
		Date alarm_time = null;
		try {
			System.out.println("####### Wake me app 0.01 ######\nWelcome dude! \n");
			alarm_time= df.parse(date_time);
			Alarm alarm = new Alarm(alarm_time,city);
			WeatherConditions wcNow = new WeatherService().getWeatherConditions(city);
			System.out.println("Current weather condition : \n"+ wcNow.getConditions() );
			
			alarm.schedule();
			
			} catch (ParseException e) {
			e.printStackTrace();
			}		

		}
		else
		{
			System.out.println ("Error ### Use java -jar WakeMeApp <city> <"+Global.DATA_FORMAT+">  ");
		}
	}
}
