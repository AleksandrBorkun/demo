package com.epam.tf.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.tf.pages.InformationSearchPage;

public class InformationSearchByDiagnosSteps extends AbstractSteps {

	private final String fragment = "Диагноз";
	private final String fragmentAttribute = "Все записи";
	private final String requisite = "Дата установления диагноза";
	private final String requisiteAttribute = "меньше";
	private final String date = "10112016";

	public InformationSearchByDiagnosSteps(WebDriver driver) {
		super(driver);
	}

	InformationSearchPage infoSerchPage;

	public InformationSearchByDiagnosSteps fillFragmentField() {
		log.info("trying to fill Diagnos");
		infoSerchPage = new InformationSearchPage(driver);
		infoSerchPage.fillFragmentField(fragment);
		return this;
	}

	public InformationSearchByDiagnosSteps fillFragmentAttributeField() {
		log.info("trying to fill Diagnos Attribute");
		infoSerchPage.fillFragmentAttributeField(fragmentAttribute);
		return this;
	}

	public InformationSearchByDiagnosSteps fillRequisiteField() {
		log.info("trying to fill requisite");
		infoSerchPage.fillRequisiteField(requisite);
		return this;

	}

	public InformationSearchByDiagnosSteps fillRequisiteAttributeField() {
		log.info("trying to fill requisite attr");
		infoSerchPage.fillRequisiteAttributeField(requisiteAttribute);
		return this;

	}

	public InformationSearchByDiagnosSteps fillDateField() {
		log.info("trying to fill date field");
		infoSerchPage.setDateField(date);
		return this;

	}

	public InformationSearchByDiagnosSteps clickSumbitButton() {
		log.info("trying to click sumbit button");
		infoSerchPage.clickSumbit();
		return this;
	}

	public List<WebElement> getSearchResult() {
		log.info("return serach result");
		return infoSerchPage.getResultList();
	}

}
