package com.cucumberFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
	static Logger log = LogManager.getLogger(ScreenShotUtil.class);
	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public byte[] attachscreenshot() throws IOException {
	         	 File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        	 File screenshotLocation = new File(System.getProperty("user.dir")+"/Screenshots/screenshot");
				 FileUtils.copyFile(temp,screenshotLocation);
				 InputStream screenshotStream = new FileInputStream(screenshotLocation);
				  return IOUtils.toByteArray(screenshotStream);
	}

}
