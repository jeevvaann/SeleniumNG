package com.cucumberFramework;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class cucumberGenerateReport {
	static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		cucumberGenerateReport.driver = driver;
	}
	public static void generateCucumberReport(String suiteName) {
		cucumberSetup setup = new cucumberSetup();
	   String filePath = System.getProperty("user.dir") + setup.getProperty("jsonfile.path");
	   System.out.println("filepath "+filePath);
	   List<String> jsonFiles = new ArrayList<>();
	   File[] fileList = getFileList(filePath);
	   for (File file : fileList) {
		  jsonFiles.add(file.getPath());
     	}
     	File reportOutputDirectory = new File(System.getProperty("user.dir") + setup.getProperty("reports.path"));
	    Configuration configuration = new Configuration(reportOutputDirectory, "Sample");
	
	   ReportBuilder reportBuilder= new ReportBuilder(jsonFiles, configuration);
	   Reportable result = reportBuilder.generateReports();
	}
	
	private static File[] getFileList(String dirPath) {
		File dir = new File(dirPath);

		File[] fileList = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".json");
			}
		});
		return fileList;
	}
}
