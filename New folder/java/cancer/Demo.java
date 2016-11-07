package cancer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "../cancer/chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		LoginPage page = new LoginPage(driver);
		
		driver.get("https://evbyminsd73ce.minsk.epam.com/");
		page.loginAs("qwerty123", "Qwerty123");

		driver.close();
		
	}

}
