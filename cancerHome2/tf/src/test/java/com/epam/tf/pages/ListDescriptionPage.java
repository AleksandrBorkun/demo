package com.epam.tf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.epam.tf.utils.ThreadSleep;


public class ListDescriptionPage extends AbstractPage {

	@FindBy(xpath = "//tr[@class='patientItem']//input[@type='checkbox']")
	private WebElement checkboxFirstUser;

	@FindBy(xpath = "//*[@id='form0']/div[2]/button[1]")
	private WebElement buttonSaveConfirmation;

	@FindBy(xpath = "//button[@role='CustomDelete']")
	private WebElement buttonRemoveFromList;

	@FindBy(xpath = "//div[@class='modal-content']//button[text()='Удалить']")
	private WebElement buttonRemoveConfirmation;

	@FindBy(xpath = "//div[@class='text-right']")
	private WebElement usersPatientSpan;

	@FindBy(xpath = "//a[text()='Списки']")
	private WebElement buttonLists;

	@FindBy(xpath = "//div[@class='patients-controll']//button[@class='btn btn-primary']")
	private WebElement buttonSendTo;

	@FindBy(xpath = "//button[@id='ListName-Autocomplete-Button']")
	private WebElement fragmentPopUp;

	@FindBy(css = ".modal-text")
	private WebElement textInMessage;

	@FindBy(xpath = " //div[@class='bootstrap-dialog-close-button']//button[@class='close']")
	private WebElement buttonClosePopUpWindow;

	@FindBy(xpath = "//*[@id='ui-id-2']")
	private WebElement fragmentContentPopUp;

	public ListDescriptionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//td/a[@data-ajax='true']")
	private WebElement spanListName;

	public void removeFirstUser() {
		checkboxFirstUser.click();
		buttonRemoveFromList.click();
		buttonRemoveConfirmation.click();
	}

	public int getPatientCount() {
		return parsePatientCountSpan(usersPatientSpan.getText());
	}

	private int parsePatientCountSpan(String text) {
		text = text.substring(6);
		text = text.replace(" записей", "");
		return Integer.parseInt(text);
	}

	public void renameNameList(String random) {
		saveList(random);
		ThreadSleep.waitElement(450);
	}

	public Object getFirstListName() {
		buttonLists.click();
		wait.waitForElementIsClickable(spanListName);
		String name = spanListName.getText();
		return name;
	}

	public void addingNotesToAnotherList() {
		checkboxFirstUser.click();
		buttonSendTo.click();
		ThreadSleep.waitElement(550);

	}

	public void editFirstUser() {
		checkboxFirstUser.click();
		buttonSendTo.click();
		Select oSelect = new Select(driver.findElement(By.id("//*[@id='ListName.Autocomplete']")));
		oSelect.selectByVisibleText("2010");
		buttonSave.click();
		ThreadSleep.waitElement(450);
	}

	public void openList() {
		fragmentPopUp.click();
		ThreadSleep.waitElement(350);
	}

	public void clickFirstName() {
		fragmentContentPopUp.click();
		ThreadSleep.waitElement(350);
	}

	public void saveChangesInList() {
		buttonSaveConfirmation.click();
		ThreadSleep.waitElement(650);
	}

	public String getActualNuberOfNotesInMessage() {
		return textInMessage.getText();

	}

	public void closeActualPopUpWindowNuberOfNotesInMessage() {
		ThreadSleep.waitElement(650);
		buttonClosePopUpWindow.click();

	}

}