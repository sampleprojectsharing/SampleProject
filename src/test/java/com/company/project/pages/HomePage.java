package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private final By avatarButton = By.cssSelector("button[class^=style__WrapAvatar]");
    private final By orderManagementButtons = By.cssSelector("p[class^='home__ItemName']");
    private final By userMenuButtons = By.cssSelector("button[class^=style__ItemMenu]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickUserMenuButton() {
        clickElement(driver.findElements(userMenuButtons).get(1));
    }

    public void clickAvatar () {
        clickElement(avatarButton);
    }

    public void openProfilePage() {
        clickElement(getAvatarButton());
        clickElement(findElements(userMenuButtons).get(0));
    }

    public void openOrderManagementPage() {
        waitForVisibility(orderManagementButtons);
        clickElement(findElements(orderManagementButtons).get(0));
    }

    public boolean isUserMenuButtonDisplayed() {
        return isElementDisplayed(findElements(userMenuButtons).get(1));
    }

    public boolean isHomePageURLIncorrect (String baseURL) {
        return isURLCorrect(baseURL, "home");
    }

    public boolean isAvatarButtonEnabled() {
        waitForVisibility(avatarButton);
        return isElementEnabled(avatarButton);
    }

    public By getAvatarButton() {
        return avatarButton;
    }
}
