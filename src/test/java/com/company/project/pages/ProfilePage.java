package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private By profileTexts = By.cssSelector("div[class^='style__ProfileBody'] p[class^='style__Text']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getFullName() {
        return findElements(profileTexts).get(0).getText();
    }

    public String getEmail() {
        return findElements(profileTexts).get(1).getText();
    }
}
