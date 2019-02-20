package com.company.project.tests;

import com.company.project.dataProviders.PropertiesReader;
import com.company.project.pages.HomePage;
import com.company.project.pages.LoginPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class A0001_LoginTestPositive extends BaseTest{
    private LoginPage loginPage;
    private HomePage homePage;

    @Test (testName = "A0001 Login positive")
    public void test() {

        // Open login page
        loginPage = new LoginPage(driver);

        loginPage.open(PropertiesReader.getInstance().getBaseUrl());

        checkOpenLoginPage();

        // Enter valid email from p.1 of Preconditions to email field
        checkLoginButtonEnableWithEmptyPassword();

        // Enter valid password from p.1 of Preconditions to password field
        checkLoginButtonEnabledWithCorrectLoginPassword();

        // Click <Sign In> button
        homePage = new HomePage(driver);
        checkAvatarAndURLHomePage();

        // Click Profile icon in the right top
        checkUserMenuButtonsDisplayed();

        // Click "Log out" in submenu
        checkLogout();


    }

    private void checkLogout() {
        homePage.clickUserMenuButton();

        assertTrue(loginPage.isLoginPageURLCorrect(), "Warning! CMS URL " +
                "is incorrect when logging out!");
        assertFalse(loginPage.isLoginButtonEnabled(), "Warning! Login button is enabled on LOGIN page when logging out!");
    }

    private void checkUserMenuButtonsDisplayed() {
        homePage.clickAvatar();

        assertTrue(homePage.isUserMenuButtonDisplayed(), "Warning! User menu isn't displayed after clicking" +
                " on user avatar on home page!");
    }

    private void checkAvatarAndURLHomePage() {
        loginPage.clickLoginButton();

        assertTrue(homePage.isAvatarButtonEnabled(), "");

        homePage.waitForVisibility(homePage.getAvatarButton());
        assertTrue(homePage.isElementDisplayed(homePage.getAvatarButton()), "Warning! No avatar button is presented");
        assertTrue(homePage.isHomePageURLIncorrect(), "Failed! Home page URL " +
                "is incorrect");
    }

    private void checkLoginButtonEnabledWithCorrectLoginPassword() {
        loginPage.fillPassword(PASSWORD);

        assertTrue(loginPage.isLoginButtonEnabled(), "Warning! Login button is disabled on LOGIN page when filling in " +
                "LOGIN and PASSWORD fields with correct values!");
    }

    private void checkLoginButtonEnableWithEmptyPassword() {
        loginPage.fillLogin(LOGIN);
        assertFalse(loginPage.isLoginButtonEnabled(), "Warning! Login button is enabled on LOGIN page when filling in " +
                "only LOGIN field!");
    }

    private void checkOpenLoginPage() {
        assertTrue(loginPage.isLoginPageURLCorrect(), "Warning! CMS URL " +
                "is incorrect when opening!");
        assertFalse(loginPage.isLoginButtonEnabled(), "Warning! Login button is enabled on LOGIN page when opening the page!");
    }
}
