package com.epam.tf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.tf.utils.ExplicitWait;

public class InformationSearchPage extends AbstractPage {
	public InformationSearchPage(WebDriver driver) {
		super(driver);
	}

	ExplicitWait waiter = new ExplicitWait(driver, 10);

	@FindBy(id = "SearchItems[0]_Fragment-Autocomplete-Button")
	private WebElement fragmentButton;

	@FindBy(xpath = ".//li[text()= 'Диагноз' ]")
	private WebElement selectDiagnosFragmnent;

	@FindBy(xpath = ".//*[@id='SearchItems[0]_FragmentAttribute-Autocomplete-Button']")
	private WebElement fragmentAttributeButton;

	@FindBy(xpath = ".//li[text()= 'Все записи' ]")
	private WebElement fragmentAttributeAllRecordingValue;

	@FindBy(xpath = ".//*[@id='SearchItems[0]_Requisite-Autocomplete-Button']")
	private WebElement requisiteButton;

	@FindBy(xpath = ".//li[text()= 'Дата установления диагноза' ]")
	private WebElement requisiteDateOfInstalValue;

	@FindBy(xpath = ".//*[@id='SearchItems[0]_Values[0]_RequisiteAttribute-Autocomplete-Button']")
	private WebElement requsiteAttributeButton;

	@FindBy(xpath = ".//li[text()= 'меньше' ]")
	private WebElement requsiteAttributeLowerThanValue;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(id = "SearchItems[0]_Values[0]_Value")
	private WebElement dateField;

	@FindBy(xpath = "//tr[@class='patientItem']")
	private List<WebElement> resultList;

	public void fillFragmentField() {
		waiter.waitForElementIsClickable(fragmentButton);
		fragmentButton.click();
		waiter.waitForElementVisible(selectDiagnosFragmnent);
		selectDiagnosFragmnent.click();

	}

	public void fillFragmentAttributeField() {
		waiter.waitForElementIsClickable(fragmentAttributeButton);
		fragmentAttributeButton.click();
		fragmentAttributeButton.click();
		waiter.waitForElementVisible(fragmentAttributeAllRecordingValue);
		fragmentAttributeAllRecordingValue.click();
	}

	public void fillRequisiteField() {
		waiter.waitForElementIsClickable(requisiteButton);
		requisiteButton.click();
		requisiteButton.click();
		waiter.waitForElementVisible(requisiteDateOfInstalValue);
		requisiteDateOfInstalValue.click();
	}

	public void fillRequisiteAttributeField() {
		waiter.waitForElementIsClickable(requsiteAttributeButton);
		requsiteAttributeButton.click();
		waiter.waitForElementVisible(requsiteAttributeLowerThanValue);
		requsiteAttributeLowerThanValue.click();
	}

	public void setDateField(String date) {
		dateField.click();
		dateField.clear();
		dateField.sendKeys(date);
	}

	public void clickSumbit() {
		submitButton.click();
	}

	public List<WebElement> getResultList() {
		return resultList;
	}

}
