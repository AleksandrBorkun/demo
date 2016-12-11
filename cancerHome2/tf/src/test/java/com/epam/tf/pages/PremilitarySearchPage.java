package com.epam.tf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class PremilitarySearchPage extends AbstractPage {

	@FindBy(id = "DateOfBirthFrom")
	private WebElement dateOfBirthFromButton;

	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@dialogtitle = 'Новый список']")
	private WebElement saveAsListButon;

	@FindBys(@FindBy(xpath = "//tr[@class = 'patientItem']"))
	private List<WebElement> searchResultList;

	public PremilitarySearchPage(WebDriver driver) {
		super(driver);
	}

	public boolean fillBirthDateAndClickSearch(String date) {

		wait.waitForElementIsClickable(dateOfBirthFromButton);
		dateOfBirthFromButton.click();
		dateOfBirthFromButton.sendKeys(date);

		wait.waitForElementIsClickable(searchButton);
		searchButton.click();

		wait.waitForElementIsClickable(saveAsListButon);

		return !searchResultList.isEmpty();
	}

}
