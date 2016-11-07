package cancer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	By userNameLocator = By.id("UserName");
	By passwordLocator = By.id("Password");
	By sumbitButton = By.cssSelector(".btn-lg.btn-success.btn-block");

	private final WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		if (!"¬ход - Cancer Register".equals(driver.getTitle())) {
			//System.out.println(driver.getTitle());
			throw new IllegalStateException("This is not Login Page");
		}
	}
	
	 public LoginPage typeUsername(String username) {
	        driver.findElement(userNameLocator).sendKeys(username);
	        return this;    
	    }

	    public LoginPage typePassword(String password) {
	        driver.findElement(passwordLocator).sendKeys(password);
	        return this;    
	    }

	    public HomePage submitLogin() {
	        driver.findElement(sumbitButton).submit();
	        return new HomePage(driver);    
	    }

	    public LoginPage submitLoginExpectingFailure() {
	        driver.findElement(sumbitButton).submit();
	        return new LoginPage(driver);   
	    }

	    public HomePage loginAs(String username, String password) {
	        typeUsername(username);
	        typePassword(password);
	        return submitLogin();
	    }

}
