package com.epam.tf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SecondNameMistakePage extends AbstractPage {

	@FindBy(id = "RegistrationDateFrom")
	private WebElement registrationDateFromField;

	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@dialogtitle = 'Новый список']")
	private WebElement saveAsListButon;

	@FindBys(@FindBy(xpath = "//tr[@class = 'patientItem']"))
	private List<WebElement> searchResultList;

	public SecondNameMistakePage(WebDriver driver) {
		super(driver);
	}

	public boolean fillRegistrationDateFromAndClickSearch(String date) {

		wait.waitForElementIsClickable(registrationDateFromField);
		registrationDateFromField.click();
		registrationDateFromField.sendKeys(date);

		wait.waitForElementIsClickable(searchButton);
		searchButton.click();

		wait.waitForElementIsClickable(saveAsListButon);

		return !searchResultList.isEmpty();

	}

}
