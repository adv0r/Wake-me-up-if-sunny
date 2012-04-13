package it.lize.wma.core;

import it.lize.wma.global.Global;
import it.lize.wma.net.WeatherService;
import it.lize.wma.utils.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.TimerTask;

import javazoom.jl.player.Player;

public class AlarmTask extends TimerTask {
	String location;
	
	
	public AlarmTask(String location)
	{
		this.location=location;
	}
	@Override
	public void run() {
		WeatherService ws = new WeatherService();
		WeatherConditions wc = ws.getWeatherConditions(location);
		
		String currentCondition = wc.getDescription() ;
		double temp = wc.getTemp_c();
		System.out.println("//WakeMeApp \n "
				+"Time : " + wc.getCurrentTime()
				+"\nCurrent Conditions in "+wc.getLocation() +" : " + currentCondition
				+"\nTemperature : "+ temp +"¡C" );
		
		String[] acceptedDescription = {"Clear"};
		
		boolean ring = false;
		for (int i=0; i< acceptedDescription.length;i++)
		{
			if(currentCondition.equalsIgnoreCase(acceptedDescription[i]))
			{
				ring = true;
			}
		}
		if (ring) ringTheAlarm();
		else System.out.println("Is not worth waking up today! I'm not going to ring the alarm!");
	}
	
	
	private void ringTheAlarm() {
		InputStream input;
		try {
			input = new FileInputStream(Global.ALARM);
			Player player = new Player(input);
			System.out.println("Urka urka sbirulero oggi splende il sol!  Buongiorno!");
			player.play();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//System.exit(0);  //TODO checkit
		
	}

}
