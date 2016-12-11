package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBySurnamePage extends AbstractPage{

	public SearchBySurnamePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//td[@class = 'control-elements']/a")
	private WebElement mainPageEditButton;
	
	@FindBy(xpath = "//a[@class = 'glyphicon glyphicon-edit']")
	private WebElement editButton;


	public void clickMainPageEditButton(){
		wait.waitForElementIsClickable(mainPageEditButton);
		mainPageEditButton.click();
	}
	
	public void clickEditPatientButton(){
		wait.waitForElementIsClickable(editButton);
		editButton.click();
	}


	
	
}
