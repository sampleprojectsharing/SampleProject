package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    private final By avatarButton = By.cssSelector("button[class^=style__WrapAvatar]");
    private final By orderManagementButtons = By.cssSelector("p[class^='home__ItemName']");
    private final By userMenuButtons = By.cssSelector("button[class^=style__ItemMenu]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickUserMenuButton() {
        clickElement(getUserMenuButton());
    }

    public void clickAvatar () {
        clickElement(avatarButton);
    }

    public void openProfilePage() {
        clickElement(avatarButton);
        clickElement(getProfilePageButton());
    }

    public void openOrderManagementPage() {
        waitForVisibility(orderManagementButtons);
        clickElement(getOrderManagementPageButton());
    }

    public boolean isUserMenuButtonDisplayed() {
        return isElementDisplayed(getUserMenuButton());
    }

    public boolean isHomePageURLIncorrect () {
        return isURLCorrect("home");
    }

    public boolean isAvatarButtonEnabled() {
        waitForVisibility(avatarButton);
        return isElementEnabled(avatarButton);
    }

    public By getAvatarButton() {
        return avatarButton;
    }

    private WebElement getProfilePageButton() {
        return findElements(userMenuButtons).get(0);
    }

    private WebElement getUserMenuButton() {
        return findElements(userMenuButtons).get(1);
    }

    private WebElement getOrderManagementPageButton() {
        return findElements(orderManagementButtons).get(0);
    }
}
