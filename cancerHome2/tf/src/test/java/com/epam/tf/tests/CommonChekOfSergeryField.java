package com.epam.tf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonChekOfSergeryField extends BaseTest{

	private static final String fragment = "Диагноз";
	private static final String fragmentAttribute = "Все записи";
	private static final String recediveFragment = "Рецидивы (метастазы)";
	private static final String fragmentSergery = "Хирургическое";
	private static final String requisite = "Дата операции";
	private static final String requisiteAttribute = "меньше";
	private static final String date = "11.12.2016";
	
	
		/// ###------------ 83 -----------------#### /// dirtyVersion
	@Test
	public void sergeryFieldCheck(){
				
		Assert.assertTrue(
				mainPageSteps.
				goToSearchByCatalog().
				fillAllFieldsAs(fragmentSergery,
								date));
		
	}

	/// ###------------- 84 --------------------### ///
	@Test
	public void recediveFieldCheck(){
		
		Assert.assertTrue(mainPageSteps.
						goToSearchByCatalog().
						fillAllFieldsForRecedive(recediveFragment, date));
	}


	/// ###------------- 85 --------------------### ///
	@Test
	public void passportPartValueCheck(){
		
		Assert.assertTrue(mainPageSteps.
						goToSearchByCatalog().
						fillAllFieldsForPassportPart(date));
	}
	

	
	/// ###------------- 86 --------------------### ///
	@Test
	public void hasInformationValueCheck(){
		
		Assert.assertTrue(mainPageSteps.
							goToSearchByCatalog().
							fillAllFieldForHasInformation());
		
	}


	/// ###------------- 87 --------------------### ///
	
	@Test
	public void addOrToRequsiteAttributeCheck(){

		Assert.assertTrue(mainPageSteps.
							goToSearchByCatalog().
							fillAllFieldsForAddOrRequsiteButton(date));
	}

	/// ###------------- 88 --------------------### ///
	
	@Test
	public void addANDToRequsiteAttributeCheck(){

		Assert.assertTrue(mainPageSteps.
							goToSearchByCatalog().
							fillAllFieldsForAddANDRequsiteButton(date));
	}

	/// ###------------- 89 --------------------### ///
	
	@Test
	public void addConditionCheck(){

		Assert.assertTrue(mainPageSteps.
							goToSearchByCatalog().
							fillAllFieldsForAddConditionRequsiteButton(date));
	}
	

}
