package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.tf.utils.ExplicitWait;

public class MainPage extends AbstractPage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	private ExplicitWait explWait = new ExplicitWait(driver, 10);

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

	@FindBy(xpath = "//div[@class = 'scrollable-cell']/ul/li[4]/div/a")
	private WebElement regulatedSearch;

	@FindBy(xpath = "//ul[@class = 'app-users']/li[2]/div/a")
	private WebElement lastAnalysisDiagnose;

	@FindBy(xpath = "//*[text()='Больные IV стадии']")
	private WebElement patientsOfForthStage;

	public void getRegulatedSearchPatientsOfForthStage() {
		explWait.waitForElementVisible(regulatedSearch);
		regulatedSearch.click();
		explWait.waitForElementIsClickable(lastAnalysisDiagnose);
		lastAnalysisDiagnose.click();
		explWait.waitForElementIsClickable(patientsOfForthStage);
		patientsOfForthStage.click();

	}

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
