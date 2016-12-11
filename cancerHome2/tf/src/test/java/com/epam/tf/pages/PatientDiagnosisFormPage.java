package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class PatientDiagnosisFormPage extends AbstractPage {

	public PatientDiagnosisFormPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".glyphicon.glyphicon-edit")
	private WebElement editFormButton;

	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='partial']/a")
	private WebElement addButton;

	public void goToEditor() {
		wait.waitForElementIsClickable(editFormButton);
		Actions actions = new Actions(driver);
		actions.moveToElement(editFormButton).click().perform();
	}

	public void clickSaveButton() {
		wait.waitForElementIsClickable(saveButton);
		saveButton.click();
	}

	public boolean isAddButtonIsPresent() {
		wait.waitForElementIsClickable(addButton);
		return addButton.isEnabled();
	}

	public void createNewDiagnosis() {
		addButton.click();
	}

}
