package com.Runner;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumberFramework.*;
import com.cucumberFramework.cucumberSetup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue={"com.stepdefinitions","com.cucumberFramework"},
		plugin = {"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt"},
		monochrome = true
		)
public class TestRunner {
	static Logger log = LogManager.getLogger(TestRunner.class);
	@BeforeClass
	public static void beforesetup(){
		try {
			cucumberSetup.loadproperties();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void teardown() {
		cucumberGenerateReport.generateCucumberReport("Default");
	}
	


}
