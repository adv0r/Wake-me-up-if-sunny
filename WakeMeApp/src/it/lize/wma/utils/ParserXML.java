package it.lize.wma.utils;

import it.lize.wma.core.WeatherConditions;

public class ParserXML {

	public WeatherConditions getWeatherConditions(String conditionsXML,
			long time,String location) {
		
		String description="";
		int temp_f=0;
		int temp_c=0;
		try
		{
			int inIndex = conditionsXML.indexOf("<current_conditions>")+"<current_conditions>".length();
			int finalIndex = conditionsXML.indexOf("</current_conditions>");
			String currentCondition = conditionsXML.substring(inIndex,finalIndex);
			
			description = currentCondition.substring(currentCondition.indexOf("<condition data=")+"<condition data=a".length(),currentCondition.indexOf("/>")-1);

			String subStr1 = currentCondition.substring(currentCondition.indexOf("/>")+2);
			temp_f = Integer.parseInt(subStr1.substring("<temp_f data=\"".length(), subStr1.indexOf("/>")-1));
			
			String subStr2 = subStr1.substring(subStr1.indexOf("/>")+2);
			temp_c = Integer.parseInt(subStr2.substring("<temp_c data=\"".length(), subStr2.indexOf("/>")-1));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return new WeatherConditions(description, temp_c, time, location);
	}

}
