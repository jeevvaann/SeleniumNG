package com.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumberFramework.cucumberSetup;

public class ActionsPage {
	WebDriver driver;
	Properties properties = new Properties();
	cucumberSetup setup = new cucumberSetup();
	
	
	@FindBy(id ="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="formly_1_input_username_0")
	WebElement mandatory_username;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement button_Login;
	
	public ActionsPage(WebDriver webDriver){
		   PageFactory.initElements(webDriver, this);
		   this.driver=webDriver;
	}
	
	public void launchUrl(String username1,String password1) throws InterruptedException {
		if(driver!=null) {
		 driver.get(setup.getProperty("URL"));
		 Thread.sleep(5000);
		 username.sendKeys(username1);
		 password.sendKeys(password1);
		 mandatory_username.sendKeys("angular");
		 button_Login.click();
		}
		else {
			System.out.println("Driver is NULL");
		}
	}
	
}
