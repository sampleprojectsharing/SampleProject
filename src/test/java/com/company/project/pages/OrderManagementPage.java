package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderManagementPage extends BasePage{
    private final By badgesButton = By.xpath("//*[@id='ic_badges']/../../..");

    public OrderManagementPage(WebDriver driver) {
        super(driver);
    }

    public void openBadgesPage() {
        clickElement(badgesButton);
    }

    public boolean isOrderManagementPageURLCorrect() {
        return isURLCorrect("orderManagement");
    }
}
