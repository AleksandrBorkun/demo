package com.epam.tf.driver;

import com.epam.tf.property.PropertyProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FactoryDriver {
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String GECKODRIVER_EXE_PATH = ".\\geckodriver\\geckodriver.exe";
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_EXE_PATH = ".\\chromedriver\\chromedriver.exe";
    private static final Logger log = LogManager.getRootLogger();
    private static WebDriver driver;

    private FactoryDriver() {
    }

    private static WebDriver getActualDriver() {
        BrowserType type = BrowserType.valueOf(PropertyProvider.getProperty("browser"));
        switch (type) {
            case CHROME:
                driver = createChromeDriver();
                log.info("chrome driver created");
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                log.info("firefox driver created");
                break;
            default:
                driver = createFirefoxDriver();
                log.info("firefox driver created");

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            getActualDriver();
        }
        return driver;
    }

    public static void closeDriver() {

        driver.quit();
        driver = null;
        log.info("driver has been closed");
    }


    @Contract(" -> !null")
    private static WebDriver createFirefoxDriver() {
        System.setProperty(WEBDRIVER_GECKO_DRIVER, GECKODRIVER_EXE_PATH);
        return new FirefoxDriver();
    }

    @Contract(" -> !null")
    private static WebDriver createChromeDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_EXE_PATH);
        return new ChromeDriver();
    }
}

