package com.epam.tf.steps;

import com.epam.tf.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps extends AbstractSteps{
    public MainPageSteps(WebDriver driver) {
        super(driver);
        this.mainPage = new MainPage(driver);
    }
    private MainPage mainPage;

    public InformationSearchByDiagnosSteps goToInformationSerchPage(){
    	log.info("go to Information Search Page");
    	mainPage = new MainPage(driver);
    	mainPage.goToInformationSearchPage();
    	return new InformationSearchByDiagnosSteps(driver);
    }

    public NewPatientPageSteps goToNewPatientForm() {
        log.info("go to New Patient Page");
        mainPage = new MainPage(driver);
        mainPage.goToNewPatientForm();
        return new NewPatientPageSteps(driver);
    }

    public MainPageSteps insertSurNameIntoSearchField(String searchRequestSurName) {
        log.info("insert search request into search field");
        mainPage.insertSurNameIntoSearchField(searchRequestSurName);
        return this;
    }

    public MainPageSteps applySearchRequest() {
        log.info("click Search button");
        mainPage.clickSubmitSearchButton();
        return this;
    }

    public String getSearchResultBySurName() {
        log.info("try to get result - SurName");
        return mainPage.getSearchResultBySurName();
    }
}
