package it.lize.wma.net;

import it.lize.wma.core.WeatherConditions;
import it.lize.wma.global.Global;
import it.lize.wma.utils.ParserXML;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class WeatherService {
	public WeatherService()
	{
		
	}
	
	public WeatherConditions getWeatherConditions(String location)
	{
		String conditionsXML = getFileFromURL(Global.API_URL+location);
		long time = Calendar.getInstance().getTimeInMillis();
		return new ParserXML().getWeatherConditions(conditionsXML,time,location);
	}
	
	private String getFileFromURL(String urlStr) 
	{

	      URL u;
	      InputStream is = null;
	      DataInputStream dis;
	      String s="";

	      try {
	         u = new URL(urlStr);    
	         is = u.openStream();       
	         dis = new DataInputStream(new BufferedInputStream(is));
	         s = dis.readLine();

	      } catch (MalformedURLException mue) {

	         System.out.println("Ouch - a MalformedURLException happened.");
	         mue.printStackTrace();
	         System.exit(1);

	      } catch (IOException ioe) {

	         System.out.println("Oops- an IOException happened.");
	         ioe.printStackTrace();
	         System.exit(1);

	      } finally {

	         try {
	            is.close();
	         } catch (IOException ioe) {
	         }

	      } 
		return s;
	}

}
