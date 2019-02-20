package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BadgesPage extends BasePage {
    private final By trashButtons = By.id("ic_trash");
    private final By badgeNamesLocator = By.xpath("//div[2]/p[contains(@class,'style__CellText')]");
    private final By pageOverlay = By.cssSelector("div[class^=style__Overlay]");
    private final By spinner = By.cssSelector("div[class^='style__Container']>img[class^='style__Image']");
    private final By yesDeleteButton = By.xpath("//button[text()='Yes, delete']");
    private final By noDeleteButton = By.xpath("//button[text()='No']");


    public BadgesPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteBadgeButton(String testBadgeTitle) {
        waitForVisibility(trashButtons);
        int trashButtonIndex = getElementIndexByText(badgeNamesLocator, testBadgeTitle);
        findElements(trashButtons).get(trashButtonIndex).click();
    }

    public void clickYesModalButton() {
        clickModalButton(yesDeleteButton);
    }

    public void clickNoModalButton() {
        clickModalButton(noDeleteButton);
    }

    private void clickModalButton(By locator) {
        waitForVisibility(locator);
        clickElement(locator);
        waitForInvisibility(pageOverlay);
    }

    public Boolean isBadgePresented(String testBadgeTitle) {
        return getElementIndexByText(badgeNamesLocator, testBadgeTitle) != -1;
    }

    public boolean isBadgesPageURLCorrect(String baseURL) {
        return isURLCorrect(baseURL, "badges");
    }

    public void waitForSpinnerInvisibility() {
        waitForInvisibility(spinner);
    }

}
