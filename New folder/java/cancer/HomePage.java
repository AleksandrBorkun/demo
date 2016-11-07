package cancer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	By searchPageButton = By.xpath(".//*[@id='form0']/div/div[7]/button");
	By surnameFieldLocator;
	By nameFieldLocator;
	By secondNameLocator;
	By birthDateLocator
	
	
	private final WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;

		if(!"Поиск - Cancer Register".equals(driver.getTitle())){
			
			throw new IllegalStateException("This is not Home Page");
		}
	}

	
	
}
