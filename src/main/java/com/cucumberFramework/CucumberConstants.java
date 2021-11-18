package com.cucumberFramework;

import cucumber.api.Scenario;

public class CucumberConstants {
	
	public static Scenario scenario;
	public static String imagetype;
	
	public static Scenario getScenario() {
		return scenario;
	}
	public static void setScenario(Scenario scenario) {
		scenario = scenario;
	}
	public static String getImagetype() {
		return imagetype;
	}
	public static void setImagetype(String imagetype) {
		imagetype = imagetype;
	}
	
	

}
