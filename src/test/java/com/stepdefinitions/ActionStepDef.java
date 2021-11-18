package com.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumberFramework.CucumberConstants;
import com.cucumberFramework.ScreenShotUtil;
import com.cucumberFramework.cucumberSetup;
import com.pages.ActionsPage;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import io.cucumber.datatable.DataTable;



public class ActionStepDef {

	 WebDriver webDriver;
	 cucumberSetup setup = new cucumberSetup();
	 CucumberConstants cucumberConstants = new CucumberConstants();

	 ScreenShotUtil screenShotUtil = new ScreenShotUtil();
	 ActionsPage actionsPage;
	    boolean flag;

	    public ActionStepDef() {
	    	
	        webDriver = setup.getDriver();
	        actionsPage = new ActionsPage(webDriver);
	        screenShotUtil.setDriver(webDriver);
//	        cucumberConstants.setScenario(scenario);
//	    	cucumberConstants.setImagetype(setup.getProperty("IMAGETYPE"));
	    }
	 
	
	@Given("Launch and Login with valid credentials")
	public void Launch_logon(DataTable data) throws InterruptedException, IOException {

		
		for(Map<Object, Object> dt : data.asMaps(String.class, String.class)) {
//			System.out.println("user name details : "+dt.get("username"));
			actionsPage.launchUrl(dt.get("username").toString(),dt.get("password").toString());
		}
		
		
//		System.out.println("byte array : "+screenShotUtil.attachscreenshot());
//		scenario.write("default");
//		scenario.embed(screenShotUtil.attachscreenshot(),setup.getProperty("IMAGETYPE"));
		CucumberConstants.scenario.embed(screenShotUtil.attachscreenshot(),"image/png");
		
	}
	
}
