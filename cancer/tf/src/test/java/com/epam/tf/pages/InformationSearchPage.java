package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationSearchPage extends AbstractPage {
	public InformationSearchPage(WebDriver driver) {
		super(driver);
	}

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
		fragmentField.click();
		fragmentField.clear();
		fragmentField.sendKeys(fragment);
	}

	public void fillFragmentAttributeField(String fragmentAttribute) {
		fragmentAttributeField.click();
		fragmentAttributeField.clear();
		fragmentAttributeField.sendKeys(fragmentAttribute);
	}

	public void fillRequisiteField(String requisite) {
		requisiteField.click();
		requisiteField.clear();
		requisiteField.sendKeys(requisite);
	}

	public void fillRequisiteAttributeField(String requisiteAttribute) {
		requisiteAttributeField.click();
		requisiteAttributeField.clear();
		requisiteAttributeField.sendKeys(requisiteAttribute);
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
