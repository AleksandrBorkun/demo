package com.epam.tf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CallToHospitalPage extends AbstractPage{

	@FindBy(id = "ControlDateFrom")
	private WebElement controlDateField;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement searchButton;
	
	@FindBys(@FindBy(xpath = "tr[@class = 'patientItem']"))
	private List<WebElement> resultSearchList;
	
	@FindBy(xpath = "//button[@dialogtitle = 'Новый список']")
	private WebElement saveToListButton;
	
	public CallToHospitalPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillControlDateField(String date){
		
		wait.waitForElementIsClickable(controlDateField);
		controlDateField.click();
		controlDateField.sendKeys(date);
		
	}
	
	public void clickSearchButton(){
		
		wait.waitForElementIsClickable(searchButton);
		searchButton.click();
		
	}
	
	public boolean checkSearchResultList(){
		wait.waitForElementIsClickable(saveToListButton);
		return !resultSearchList.isEmpty();
		
	}

}
