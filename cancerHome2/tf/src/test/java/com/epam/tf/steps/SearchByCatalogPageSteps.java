package com.epam.tf.steps;

import com.epam.tf.pages.SearchByCatalogPage;
import com.epam.tf.utils.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchByCatalogPageSteps extends AbstractSteps {

	private String random;

	private final String date = "10112016";

	public SearchByCatalogPageSteps(WebDriver driver) {
		super(driver);
		this.searchByCatalogPage = new SearchByCatalogPage(driver);
	}

	private SearchByCatalogPage searchByCatalogPage;

	public SearchByCatalogPageSteps fillRequest(String firstRawDiagnosis, String secondRawAllRecords,
			String thirdRawCodmkb10, String fourthRawOmplice) {
		log.info("choose Fragment");
		searchByCatalogPage.openFragmentField();
		searchByCatalogPage.clickElementByName(firstRawDiagnosis);
		log.info("choose Fragment Attribute");
		searchByCatalogPage.openFragmentAttributeField();
		searchByCatalogPage.clickElementByName(secondRawAllRecords);
		log.info("choose Props");
		searchByCatalogPage.openRequisiteField();
		searchByCatalogPage.clickElementByName(thirdRawCodmkb10);
		log.info("choose Requisite Attribute");
		searchByCatalogPage.openRequisiteAttributeField();
		searchByCatalogPage.clickElementByName(fourthRawOmplice);
		return this;
	}

	public void chooseSearchByCatalog() {
		log.info("choose Requisite Value");
		searchByCatalogPage.openRequisiteValue();
		log.info("choose Search by Catalog Part");
		searchByCatalogPage.searchByCatalogPart();
	}

	public void clickSearch() {
		log.info("click search by filled request");
		searchByCatalogPage.clickSearchFilledRequest();
	}

	public boolean checkResult() {
		log.info("check result of inserted data");
		return searchByCatalogPage.checkResultOfInsertion();
	}

	public void fillCatalogRequest(String firstLineCatalogLips, String secondLineCatalogLips,
			String thirdLineCatalogLips) {
		chooseSearchByCatalog();
		log.info("choose Sub Class");
		searchByCatalogPage.openSubClass();
		searchByCatalogPage.clickElementByName(firstLineCatalogLips);
		log.info("choose Heading");
		searchByCatalogPage.openHeading();
		searchByCatalogPage.clickElementByName(secondLineCatalogLips);
		log.info("choose Sub Heading");
		searchByCatalogPage.openSubHeading();
		searchByCatalogPage.clickElementByName(thirdLineCatalogLips);
		log.info("submit request");
		searchByCatalogPage.submitRequest();
		clickSearch();
	}

	public void fillCatalogRequest(String thirdLineCatalogDistrict, String fourthLineCatalogOKPO) {
		chooseSearchByCatalog();
		log.info("choose District");
		searchByCatalogPage.choseDistrict();
		searchByCatalogPage.clickElementByName(thirdLineCatalogDistrict);
		log.info("choose OKPO");
		searchByCatalogPage.choseOKPO();
		searchByCatalogPage.clickElementByName(fourthLineCatalogOKPO);
		log.info("submit request");
		searchByCatalogPage.submitRequest();
		clickSearch();
	}

	public ListsPageSteps saveResultInList() {
		log.info("click on 'save in list' button");
		searchByCatalogPage.saveResultInList();
		random = "Test " + Random.getRandomString(5);
		log.info("fillin list name and click on save button");
		searchByCatalogPage.saveList(random);
		return new ListsPageSteps(driver);
	}

	public String getExpectedListName() {
		return random;
	}

	public boolean fillAllFieldsAs(String fragment, String requisite, String requisiteAttribute, String date) {

		log.info("try to fill sergery request and press save button");

		return searchByCatalogPage.fillAllFieldAs(fragment, requisite, requisiteAttribute, date);
	}
	
	
	public boolean fillAllFieldsForRecedive(String fragment, String date){
		log.info("try to fill recedive request and press save button");
		return searchByCatalogPage.fillAllFieldAForRecidive(fragment, date);
	}

	public boolean fillAllFieldsForPassportPart(String date){
		log.info("try to fill passport part request and press save button");
		return searchByCatalogPage.fillAllFieldForPassportPart(date);
	}
	
	public boolean fillAllFieldForHasInformation(){
		log.info("try to fill has information request and press save button");
		return searchByCatalogPage.fillAllFieldForHasInformation();
	}
	
	public boolean fillAllFieldsForAddOrRequsiteButton(String date){
		log.info("try to fill 'OR' request and press save button");
		return searchByCatalogPage.fillAllFieldsForAddOrRequsiteButton(date);
	}
	
	public boolean fillAllFieldsForAddANDRequsiteButton(String date){
		log.info("try to fill 'AND' request and press save button");
		return searchByCatalogPage.fillAllFieldsForAddANDRequsiteButton(date);
	}
	
	public boolean fillAllFieldsForAddConditionRequsiteButton(String fragment, String fragmentAttribute, String requisite, String requisiteAttribute, String date){
		log.info("try to fill 'AND' request and press save button");
		return searchByCatalogPage.fillAllFieldsForAddConditionRequsiteButton(fragment, fragmentAttribute, requisite, requisiteAttribute, date);
	}
	
	public SearchByCatalogPageSteps fillFragmentField() {
		log.info("trying to fill Diagnos");
		searchByCatalogPage = new SearchByCatalogPage(driver);
		searchByCatalogPage.fillFragmentField();
		return this;

	}

	public SearchByCatalogPageSteps fillFragmentAttributeField() {
		log.info("trying to fill Diagnos Attribute");
		searchByCatalogPage.fillFragmentAttributeField();
		return this;

	}

	public SearchByCatalogPageSteps fillRequisiteField() {
		log.info("trying to fill requisite");
		searchByCatalogPage.fillRequisiteField();
		return this;

	}

	public SearchByCatalogPageSteps fillRequisiteAttributeField() {
		log.info("trying to fill requisite attr");
		searchByCatalogPage.fillRequisiteAttributeField();
		return this;

	}

	public SearchByCatalogPageSteps fillDateField() {
		log.info("trying to fill date field");
		searchByCatalogPage.setDateField(date);
		return this;

	}

	public SearchByCatalogPageSteps clickSumbitButton() {
		log.info("trying to click sumbit button");
		searchByCatalogPage.clickSumbit();
		return this;
	}

	public List<WebElement> getSearchResult() {
		log.info("return serach result");
		return searchByCatalogPage.getResultList();
	}
}
