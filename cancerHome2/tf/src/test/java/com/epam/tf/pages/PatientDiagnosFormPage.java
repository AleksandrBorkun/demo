package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientDiagnosFormPage extends AbstractPage {

	public PatientDiagnosFormPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class = 'glyphicon glyphicon-edit']")
	private WebElement editFormButton;

	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement saveButton;

	@FindBy(xpath = ".//*[@id='partial']/a")
	private WebElement addButton;

	public void goToEditor() {
		wait.waitForElementIsClickable(editFormButton);
		editFormButton.click();
	}

	public void clickSaveButton() {
		wait.waitForElementIsClickable(saveButton);
		saveButton.click();
	}

	public boolean isAddButtonIsPresent() {
		wait.waitForElementIsClickable(addButton);
		return addButton.isEnabled();
	}

}
