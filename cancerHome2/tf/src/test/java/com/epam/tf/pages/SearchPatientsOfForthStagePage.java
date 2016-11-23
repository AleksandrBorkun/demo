package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class SearchPatientsOfForthStagePage extends AbstractPage {

	public SearchPatientsOfForthStagePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-calendar btn']")
	private WebElement calendarButton;

	@FindBy(xpath = ".//*[@id='ui-datepicker-div']/div[1]/div/select[1]")
	private WebElement monthButton;

	@FindBy(xpath = "//option[@value = '3']")
	private WebElement aprilMonth;

	@FindBy(xpath = "//select[@class = 'ui-datepicker-year']")
	private WebElement yearButton;

	@FindBy(xpath = "//option[@value = '2000']")
	private WebElement twoThousandYear;

	@FindBy(xpath = "//button[@class  = 'ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
	private WebElement selectButton;

	@FindBy(xpath = "//button[@class = 'btn btn-primary list-search pull-right']")
	private WebElement searchButton;

	@FindBy(xpath = "//table[@class='table table-striped patientTable']/tbody/tr[2]/td[@class = 'control-elements']/a")
	private WebElement editPatientButton;

	@FindBy(xpath = "//td[@class = 'control-elements']/a[@class = 'glyphicon glyphicon-edit']")
	private WebElement editFormButton;

	@FindBy(xpath = "//div[@class = 'form-group float-buttons-panel']/button[1]")
	private WebElement saveButton;

	@FindBy(xpath = ".//*[@id='partial']/a")
	private WebElement addButton;

	public void fillTheFieldAndMakeSearch() {
		
		calendarButton.click();

		wait.waitForElementIsClickable(monthButton);
		monthButton.click();

		wait.waitForElementIsClickable(aprilMonth);
		aprilMonth.click();

		wait.waitForElementIsClickable(yearButton);
		yearButton.click();

		wait.waitForElementIsClickable(twoThousandYear);
		twoThousandYear.click();

		wait.waitForElementIsClickable(selectButton);
		selectButton.click();

		wait.waitForElementIsClickable(searchButton);
		searchButton.click();

	}

	public void clickEditPatientButton() {
		wait.waitForElementIsClickable(editPatientButton);
		editPatientButton.click();

	}
}
