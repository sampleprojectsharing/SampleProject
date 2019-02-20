package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

    WebDriver driver;
    private WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    boolean isURLCorrect(String baseURL, String partialURL) {
        wait.until(ExpectedConditions.urlContains(partialURL));
        return driver.getCurrentUrl().equals(baseURL + partialURL);
    }

    public void open(String url) {
        driver.get(url);
    }

    WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public boolean isElementDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementEnabled(By locator) {
        return findElement(locator).isEnabled();

    }

    int getElementIndexByText(By locator, String elementText) {
        List<WebElement> elements = findElements(locator);
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(elementText)) {
                return i;
            }
        }
        return -1;
    }

    void clickElement(By locator) {
        waitForClickable(locator);
        findElement(locator).click();
    }

    void clickElement(WebElement element) {
        waitForClickable(element);
        element.click();
    }


    private void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
