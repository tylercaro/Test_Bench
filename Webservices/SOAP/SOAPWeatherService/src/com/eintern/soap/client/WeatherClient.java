package com.eintern.soap.client;

import NET.webserviceX.www.GlobalWeatherLocator;
import NET.webserviceX.www.GlobalWeatherSoapStub;

public class WeatherClient {

	public static void main(String[] args) {
		GlobalWeatherLocator locator = new GlobalWeatherLocator();
		try{
			locator.setGlobalWeatherSoapEndpointAddress(locator.getGlobalWeatherSoapAddress());
			GlobalWeatherSoapStub gwSoap = (GlobalWeatherSoapStub) locator.getGlobalWeatherSoap();
			
			System.out.println(gwSoap.getWeather("DC", "United States"));
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
}
