package com.cucumberFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class cucumberSetup {
	private final static Logger logger = LogManager.getLogger(cucumberSetup.class);
	static Properties properties;
	static WebDriver driver = null;
	ScreenShotUtil screenShotUtil = new ScreenShotUtil();
	 
	

	static {
		loadproperties();
	}
	
	@Before
	public void setup(Scenario scenario) {
	     loadproperties();
		driver = this.getDriver(properties.getProperty("BrowserName"));
		this.manageDriver(driver);
		screenShotUtil.setDriver(driver);
		cucumberGenerateReport.setDriver(driver);
		CucumberConstants.scenario = scenario;
		System.out.println("+++++++++++++++Init++++++++++++");
	}
	
	@After
	public void teardown(Scenario scenario) {		
		if(driver!=null) {
			CucumberConstants.scenario = scenario;
			try {
				CucumberConstants.scenario.embed(screenShotUtil.attachscreenshot(),"image/png");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
//			cucumberGenerateReport.generateCucumberReport("Default");
			this.removeDriver(driver);
		}
	}
	
	public static WebDriver getDriver() {
        return driver;
    }
	
	 private void manageDriver(WebDriver webDriver) {
	        webDriver.manage().window().maximize();
	        webDriver.manage().deleteAllCookies();
	 }
	
	private WebDriver getDriver(String browsername) {
         
		try {			
		switch(browsername) {
		case "chrome":
			driver= ChromeDriver();
			break;
		case "IE" :
			driver= IEdriver();
			break;
		default:
			driver= ChromeDriver(); 
		}	
	  }
		catch(Exception e) {
			logger.error(e.getMessage());
	  }		
		return driver;
	}
	
	
	
	private WebDriver ChromeDriver() {
		System.setProperty(properties.getProperty("DriverName"), System.getProperty("user.dir")+properties.getProperty("chromeDriverPath"));
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.setAcceptInsecureCerts(true);
		
		WebDriver webdriver = new ChromeDriver(chromeOptions);
		
		return webdriver;
	}
	
	private WebDriver IEdriver() {
		WebDriver webdriver = new InternetExplorerDriver();		
		return webdriver;
	}
	
	public void removeDriver(WebDriver driver) {
		try {
			if(driver!=null) {
			switch(properties.getProperty("BrowserName").toLowerCase()) {
			case "chrome" :
				driver.quit();
				driver.close();
				break;
			case "firefox" :
				driver.quit();
				driver.close();
				break;
			}
		}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public static void loadproperties() {
		properties = new  Properties();
		try {
			properties.load(new FileReader(System.getProperty("user.dir")+"/src/main/resources/application.properties"));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());		
		} catch (IOException e) {
			logger.error(e.getMessage());		
		}
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
