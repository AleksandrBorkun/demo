package com.epam.tf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HaveNoInformationAboutHealingPage extends AbstractPage{

	@FindBy(id = "DiagnosisDateFrom")
	private WebElement dateField;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//button[@dialogtitle = 'Новый список']")
	private WebElement saveAsListButon;
	
	@FindBys(@FindBy(xpath = "//tr[@class = 'patientItem']"))
	private List<WebElement> searchResultList;
	
	public HaveNoInformationAboutHealingPage(WebDriver driver) {
		super(driver);
	}

	public boolean fillDateAndClickSearch(String date){
		
		wait.waitForElementIsClickable(dateField);
		dateField.click();
		dateField.sendKeys(date);
		
		wait.waitForElementIsClickable(searchButton);
		searchButton.click();
		
		wait.waitForElementIsClickable(saveAsListButon);		
		
		return !searchResultList.isEmpty();
	}
	
}
