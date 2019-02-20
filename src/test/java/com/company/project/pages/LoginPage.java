package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private final By loginInput = By.xpath("//input[@placeholder='Enter email address']");
    private final By passwordInput = By.xpath("//input[@placeholder='Enter password']");
    private final By loginButton = By.cssSelector("button");
    private By errorIncorrectEmailPassText = By.cssSelector("p[class^='login__ErrorText'");
    private By visiblePasswordButton = By.cssSelector("div[class^='style__BtnPass']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillLogin(String login) {
        findElement(loginInput).sendKeys(login);
    }

    public void fillPassword(String password) {
        findElement(passwordInput).sendKeys(password);
    }

    public boolean isLoginPageURLCorrect() {
        return isURLCorrect("");
    }

    public void clearLogin() {
        while (!findElement(loginInput).getAttribute("value").equals("")) {
            findElement(loginInput).sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clearPassword() {
        while (!findElement(passwordInput).getAttribute("value").equals("")) {
            findElement(passwordInput).sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clickLoginButton() {
        findElement(loginButton).click();
    }

    public void clickVisiblePasswordButton() {
        findElement(visiblePasswordButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return findElement(loginButton).isEnabled();
    }

    public By getLoginButton() {
        return loginButton;
    }

    public boolean isErrorLoginPassDisplayed() {
        waitForVisibility(errorIncorrectEmailPassText);
        return isElementDisplayed(errorIncorrectEmailPassText);
    }

}
