package com.company.project.actions;

import com.company.project.dataProviders.PropertiesReader;
import com.company.project.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginActions {


    public void login(LoginPage loginPage, String login, String password) {
        loginPage.clearLogin();
        loginPage.fillLogin(login);
        loginPage.clearPassword();
        loginPage.fillPassword(password);
        loginPage.clickVisiblePasswordButton();
        loginPage.clickLoginButton();
    }

    public void login(WebDriver driver, String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(PropertiesReader.getInstance().getBaseUrl());
        loginPage.fillLogin(login);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
    }
}
