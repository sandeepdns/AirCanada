package com.Runner;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.dataProvider.configFileReader;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/resources",glue={"com"},
tags="@Search"
, dryRun = false
		)						
public class TestRunner 				
{		

public static ExtentReports extentReports = new ExtentReports();
public static ExtentHtmlReporter htmlReporter;
public static ExtentTest testname;
@BeforeClass
public static void InitReport() throws IOException {
	configFileReader configFile = new configFileReader();
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	System.getProperty("user.dir");

	htmlReporter = new ExtentHtmlReporter("Reports/report_"+timeStamp+".html");
	htmlReporter.config().setDocumentTitle("Automation Test Report");
	htmlReporter.config().setReportName("Automation Test Report");
	extentReports.attachReporter(htmlReporter);
	
}
@AfterClass
public static void AfterTst() {
extentReports.flush();

}
}