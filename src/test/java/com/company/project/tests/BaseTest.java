package com.company.project.tests;

import com.company.project.logger.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    EventFiringWebDriver driver;
    static final String LOGIN = "admin@example.com";
    static final String PASSWORD = "qwerty123";
    static final String USERNAME = "John Doe";

    @BeforeClass
    protected void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        driver = new EventFiringWebDriver(webDriver);
        driver.register(new EventHandler());
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}
