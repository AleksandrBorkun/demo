package com.epam.tf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ConsistingAtTheEndOfThePeriodPage extends AbstractPage {

	@FindBy(id = "ReportingYear")
	private WebElement reportingYearButton;

	@FindBy(id = "ClinicalGroup-Autocomplete-Button")
	private WebElement clinicalGroupButton;

	@FindBy(xpath = "//li[contains(text(), '2-я клиническая группа')]")
	private WebElement secondClinicalGroupValue;

	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@dialogtitle = 'Новый список']")
	private WebElement saveAsListButton;

	@FindBys(@FindBy(xpath = "//tr[@class = 'patientItem']"))
	private List<WebElement> resultList;

	public ConsistingAtTheEndOfThePeriodPage(WebDriver driver) {
		super(driver);
	}

	
	public boolean fillReportingFieldAndClickSearch(String date){
		
		wait.waitForElementIsClickable(reportingYearButton);
		reportingYearButton.click();
		reportingYearButton.sendKeys(date);
		
		wait.waitForElementIsClickable(clinicalGroupButton);
		clinicalGroupButton.click();
		
		wait.waitForElementIsClickable(secondClinicalGroupValue);
		secondClinicalGroupValue.click();
		
		wait.waitForElementIsClickable(searchButton);
		searchButton.click();
		
		wait.waitForElementIsClickable(saveAsListButton);
		
		return !resultList.isEmpty();
	}
	
}
