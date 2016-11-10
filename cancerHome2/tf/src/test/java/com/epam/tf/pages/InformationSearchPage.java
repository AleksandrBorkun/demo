package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationSearchPage extends AbstractPage {
	public InformationSearchPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id = "SearchItems[0]_Fragment-Autocomplete-Button")
	private WebElement fragmentButton;
	
	@FindBy(xpath = ".//li[text()= 'Диагноз' ]")
	private WebElement selectDiagnosFragmnent;
	
	@FindBy(id = "SearchItems[0]_FragmentAttribute-Autocomplete-Button")
	private WebElement fragmentAttributeButton;
	
	@FindBy(xpath = ".//li[text()= 'Все записи' ]")
	private WebElement fragmentAttributeAllRecordingValue;
	
	@FindBy(id = "SearchItems[0]_Requisite-Autocomplete-Button")
	private WebElement requisiteButton;
	
	@FindBy(xpath = ".//li[text()= 'Дата установления диагноза' ]")
	private WebElement requisiteDateOfInstalValue;
	
	@FindBy(id = "SearchItems[0]_Values[0]_RequisiteAttribute-Autocomplete-Button")
	private WebElement requsiteAttributeButton;
	
	@FindBy(xpath = ".//li[text()= 'меньше' ]")
	private WebElement requsiteAttributeLowerThanValue;
		
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = ".//*[@id='SearchItems[0]_Fragment.Autocomplete']")
	private WebElement fragmentField;

	@FindBy(xpath = ".//*[@id='SearchItems[0]_FragmentAttribute.Autocomplete']")
	private WebElement fragmentAttributeField;

	@FindBy(xpath = ".//*[@id='SearchItems[0]_Requisite.Autocomplete']")
	private WebElement requisiteField;

	@FindBy(xpath = ".//*[@id='SearchItems[0]_Values[0]_RequisiteAttribute.Autocomplete']")
	private WebElement requisiteAttributeField;

	@FindBy(id = "SearchItems[0]_Values[0]_Value")
	private WebElement dateField;

	public void fillFragmentField(String fragment) {
		fragmentButton.click();
		selectDiagnosFragmnent.click();
		
		//fragmentField.click();
		//fragmentField.clear();
		//fragmentField.sendKeys(fragment);
	}

	public void fillFragmentAttributeField(String fragmentAttribute) {
		fragmentAttributeButton.click();
		fragmentAttributeAllRecordingValue.click();		
		//fragmentAttributeField.click();
		//fragmentAttributeField.clear();
		//fragmentAttributeField.sendKeys(fragmentAttribute);
	}

	public void fillRequisiteField(String requisite) {
		requisiteButton.click();
		requisiteDateOfInstalValue.click();		
		//requisiteField.click();
		//requisiteField.clear();
		//requisiteField.sendKeys(requisite);
	}

	public void fillRequisiteAttributeField(String requisiteAttribute) {
		requsiteAttributeButton.click();
		requsiteAttributeLowerThanValue.click();		
		//requisiteAttributeField.click();
		//requisiteAttributeField.clear();
		//requisiteAttributeField.sendKeys(requisiteAttribute);
	}

	public void setDateField(String date) {
		dateField.click();
		dateField.clear();
		dateField.sendKeys(date);
	}

	public void clickSumbit() {
		submitButton.click();
	}

}
