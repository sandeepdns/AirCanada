package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class repository {
	WebDriver driver;
	public repository(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Flights']")
	public WebElement FlightsTab;
	
	@FindBy(xpath = "//button[@id='bkmg-tab-button-vacations']")
	public WebElement VacationsTab;

	@FindBy(xpath = "//*[text()='Round-trip']")
	public WebElement RoundTripDropdown;

	@FindBy(xpath = "//*[@id='bkmgFlights_tripTypeSelectorOption-R']")
	public WebElement RoundTripValue;
	

	@FindBy(xpath = "//input[@id='bkmgFlights_origin_trip_1']")
	public WebElement FromTextbox;

	@FindBy(xpath = "//div[@class='location-info-main']")
	public WebElement OriginSearchRes;

	@FindBy(xpath = "bkmgFlights_destination_trip_1SearchResult0")
	public WebElement DestinationSearchRes;
	

	@FindBy(id = "bkmgFlights_destination_trip_1")
	public WebElement ToTextbox;

	@FindBy(id = "bkmgFlights_travelDates_1-formfield-1")
	public WebElement DepartureDate;

	@FindBy(id = "bkmgFlights_travelDates_1-formfield-2")
	public WebElement ReturnDate;

	@FindBy(xpath = "//button[@id='bkmgFlights_findButton']")
	public WebElement FindButton;

	@FindBy(xpath = "//*[text()='Departing flight']")
	public WebElement SearchResults_FlightInfo;

	@FindBy(xpath = "//*[@class='flight-date ng-star-inserted']/span[@class='hidden-xs']")
	public WebElement DateTextSearchResultPage;

	@FindBy(xpath = "//*[@id='ECOCabin']")
	public WebElement EconomyClass;

	@FindBy(xpath = "//*[@id='EXECCabin']")
	public WebElement BusinessClass;

	@FindBy(xpath = "//*[text()='Premium Class']")
	public WebElement PremiumClass;
	

	
	
}
