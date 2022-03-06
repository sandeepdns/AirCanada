package com.StepDef;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Runner.TestRunner;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dataProvider.configFileReader;
import com.pageObjects.repository;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods {
	public static WebDriver driver;
	configFileReader configFile; 
	public static repository repo ;
	public static WebDriverWait wait ;
	public static ExtentTest test;
	public void setup() throws IOException {
		repo = new repository(driver);
		configFile = new configFileReader();
		 wait = new WebDriverWait(driver, 30);
	}
	
	@Given("User open the {string} browser")
	public void user_open_the_browser(String browser) throws IOException {
		configFile = new configFileReader();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = TestRunner.extentReports.createTest("Open the browser");	  
	}
	@Given("open the AirCanada home page")
	public void open_the_air_canada_home_page() throws IOException {
	setup();
	driver.get(configFile.getConfigData("AirCanadaURL"));
	}


@When("user click on the Flight tab")
public void user_click_on_the_flight_tab() throws InterruptedException {
	//Thread.sleep(5000);
   // repo.FlightsTab.click();
   ClickAnElement(repo.FlightsTab, "Flights Tab");
}
public void ClickAnElement(WebElement ele, String EleName) throws InterruptedException {
	//wait.until(ExpectedConditions.visibilityOf(ele));

	Thread.sleep(3000);
	Actions act = new Actions(driver);
	act.moveToElement(ele).click();
	try {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", ele);
		
	} catch (Exception e) {
		ele.click();
	}
	test.log(Status.INFO, "User Clicked on the Element "+ EleName);
}

@When("select the trip type as Round trip")
public void select_the_trip_type_as_round_trip() throws InterruptedException {
 ClickAnElement(repo.RoundTripDropdown, "Trip Type Dropdown");
 ClickAnElement(repo.RoundTripValue, "Round Trip");
}
@When("Set the trip Origin as {string}")
public void set_the_trip_origin_as(String string) throws InterruptedException {
   EnterText(repo.FromTextbox, "YYR");
   // ClickAnElement(repo.OriginSearchRes);
}
@When("Set the trip destination as {string}")
public void set_the_trip_destination_as(String string) throws InterruptedException {
    EnterText(repo.ToTextbox, "YYZ");
   // ClickAnElement(repo.DestinationSearchRes);
}
public void EnterText(WebElement ele, String data) {
	//wait.until(ExpectedConditions.visibilityOf(ele));
	ele.clear();
	ele.sendKeys(data);
	
}
@When("Set Departure date {string}")
public void set_departure_date(String string) {
    EnterText(repo.DepartureDate, string);    
}
@When("Set  Return date {string}")
public void set_return_date(String string) {
    EnterText(repo.ReturnDate, string);
}
@When("click the Find button")
public void click_the_find_button() throws InterruptedException {
	repo.FindButton.sendKeys(Keys.ENTER);
	repo.FindButton.sendKeys(Keys.ENTER);
	ClickAnElement(repo.FindButton, "Find Button");
}

@When("Wait for the Select Flights page to be displayed")
public void wait_for_the_select_flights_page_to_be_displayed() {
    wait.until(ExpectedConditions.visibilityOf(repo.SearchResults_FlightInfo));
}
@Then("validate the display date on search results page")
public void validate_the_display_date_on_search_results_page() {
if(repo.DateTextSearchResultPage.getText().replaceAll(" ", "").contains("July15,2022")) {
	test.log(Status.PASS, "Date Displayed correctly on Search page as " + repo.DateTextSearchResultPage.getText());
}
System.out.println(repo.DateTextSearchResultPage.getText());
}
@Then("validate various ranges are displayed for the tickets")
public void validate_various_ranges_are_displayed_for_the_tickets() {
	CheckIfExists(repo.EconomyClass, "Economy Class");
	CheckIfExists(repo.PremiumClass, "Premium Class");
	CheckIfExists(repo.BusinessClass, "Business Class");
}

public void CheckIfExists(WebElement ele, String EleName) {
	try {
		if(ele.isDisplayed())
			test.log(Status.PASS, EleName+ " is displayed");
		else
			test.log(Status.FAIL, EleName+ " is NOT displayed");

	} catch (Exception e) {
		test.log(Status.FAIL, EleName+ " is NOT displayed \nFollowing is the error details: "+ StringUtils.substringBefore(e.getMessage(), "(Session info:"));
	}
	
}


	@Then("close the browser")
	public void close_the_browser() {
	  //  driver.quit();
		
	}



}
