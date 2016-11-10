package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
	public MainPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text() = 'Новый Пациент']")
	private WebElement newPatientButton;
	@FindBy(id = "LastName")
	private WebElement surNameSearchField;
	@FindBy(xpath = "//button[text() = 'Поиск']")
	private WebElement searchButton;
	@FindBy(xpath = "//td[text() = 'Давыдчик']")
	private WebElement resultSurName;
	@FindBy(id = "819033581")
	private WebElement informationSearchButton;

	public void goToInformationSearchPage() {
		informationSearchButton.click();
	}

	public void goToNewPatientForm() {
		newPatientButton.click();
	}

	public void insertSurNameIntoSearchField(String searchRequestSurName) {
		surNameSearchField.sendKeys(searchRequestSurName);
	}

	public void clickSubmitSearchButton() {
		searchButton.click();
	}

	public String getSearchResultBySurName() {
		return resultSurName.getText();
	}
}
