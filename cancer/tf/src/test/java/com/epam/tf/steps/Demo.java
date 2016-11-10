package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.epam.tf.pages.LoginPage;
import com.epam.tf.pages.MainPage;

public class Demo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "../tf/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://evbyminsd73ce.minsk.epam.com/");
		LoginPage log = new LoginPage(driver);
		log.authorization("qwerty123", "Qwerty123");
		MainPage main = new MainPage(driver);
		main.goToInformationSearchPage();
		InformationSearchByDiagnosSteps info = new InformationSearchByDiagnosSteps(driver);
		info.fillFragmentField();

		
	}

}
