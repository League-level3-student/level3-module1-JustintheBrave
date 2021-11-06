package _07_California_Weather;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 °F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature °F = 65.0, max temperature °F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather {
    
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	
	
	
    void start() {
    	
    	String City = JOptionPane.showInputDialog("What city do you want?");
    	String cond = JOptionPane.showInputDialog("What weather condition?");
    	String temp1 = JOptionPane.showInputDialog("Minimum temperature");
    	String temp2 = JOptionPane.showInputDialog("Maximum temperature?");
    	int t1 = Integer.parseInt(temp1);
    	int t2 = Integer.parseInt(temp2);
    	
    	double min = Double.parseDouble(temp1);
    	double max = Double.parseDouble(temp2);
    	
    	System.out.println("TEMPERATURE");
    	
    	for(String s: weatherData.keySet()) {
    		WeatherData datum = weatherData.get(s);
    		if(datum != null && datum.temperatureF > min && datum.temperatureF < max) {
    			System.out.println(s);
    		}
    	}
    	
    	System.out.println("CONDITION");
    	
    	for(String s: weatherData.keySet()) {
    		WeatherData datum = weatherData.get(s);
    		if(datum != null && datum.weatherSummary.equalsIgnoreCase(cond)) {
    			System.out.println(s);
    		}
    	}
             
        // All city keys have the first letter capitalized of each word
    	
    	System.out.println("CITY");
    	
        String cityName = Utilities.capitalizeWords(City);
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
       
        
        
    }
}
