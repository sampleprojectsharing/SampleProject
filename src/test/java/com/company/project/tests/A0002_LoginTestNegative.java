package com.company.project.tests;

import com.company.project.pages.LoginPage;
import com.company.project.actions.LoginActions;
import com.company.project.dataProviders.PropertiesReader;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class A0002_LoginTestNegative extends BaseTest {

    private LoginPage loginPage;
    private LoginActions loginActions;
    private String incorrectPassword = "!qwerty123";

    @Test (testName = "A0002 Login negative")
    public void test() {

        // Open LOGIN page
        loginPage = new LoginPage(driver);
        loginPage.open(PropertiesReader.getInstance().getBaseUrl());

        checkLoginPageURL();

        //Enter PASSWORD from Preconditions to PASSWORD field. Email field is empty
        checkErrorMessageEmptyEmail();

        //Enter valid non-existent PASSWORD to Password field. Email field is empty
        checkErrorMessageEmptyEmailWrongPassword();

        //Enter not valid email, e.g. "incorrectEmail@mail". Password field is filled with incorrect PASSWORD from p.3
        checkErrorMessageIncorrectEmailFormat();

        //Enter email from Preconditions. Password field is filled with incorrect PASSWORD from p.3
        loginActions = new LoginActions();
        checkLoginButtonEnabledWithExistingEmailWrongPassword();

        //Click <Sign In> button
        checkErrorMessageWrongPassword();

        //Enter valid non-existent email to Email field
        checkLoginButtonEnabledNonExistEmail();

        //Click <Sign In> button
        checkErrorMessageNonExistEmail("non-exist EMAIL", "incorrect PASSWORD!");

        //Enter correct PASSWORD from precondition to Password field
        checkLoginButtonEnabledWithIncorrectEmailCorrectPassword();

        //Click <Sign In> button
        checkErrorMessageNonExistEmail("non-exist EMAIL", "correct PASSWORD!");

    }

    private void checkLoginButtonEnabledWithIncorrectEmailCorrectPassword() {
        loginPage.clearPassword();
        loginPage.fillPassword(PASSWORD);
        assertTrue(loginPage.isElementEnabled(loginPage.getLoginButton()), "Warning! Login button is disabled on LOGIN " +
                "page when filling in LOGIN field with incorrect EMAIL and PASSWORD field with correct PASSWORD!");
    }

    private void checkErrorMessageNonExistEmail(String emailStatus, String passwordStatus) {
        loginPage.clickLoginButton();
        assertTrue(loginPage.isErrorLoginPassDisplayed(), "Warning! Error message " +
                "isn't displayed on LOGIN page when filling in LOGIN field with " + emailStatus + " and PASSWORD field with " +
                passwordStatus);
    }

    private void checkLoginButtonEnabledNonExistEmail() {
        loginActions.login(loginPage, "test@test.com", incorrectPassword);
        assertTrue(loginPage.isElementEnabled(loginPage.getLoginButton()), "Warning! Login button is disabled on LOGIN " +
                "page when filling in LOGIN field with incorrect EMAIL and PASSWORD field with incorrect PASSWORD!");
    }

    private void checkLoginButtonEnabledWithExistingEmailWrongPassword() {
        loginActions.login(loginPage, LOGIN, incorrectPassword);
        assertTrue(loginPage.isLoginButtonEnabled(), "Warning! Login button is disabled on LOGIN page when " +
                "filling in LOGIN field with correct EMAIL and PASSWORD field with incorrect PASSWORD!");
    }

    private void checkErrorMessageWrongPassword() {
        loginPage.clickVisiblePasswordButton();
        checkErrorMessageNonExistEmail("correct EMAIL", "incorrect PASSWORD!");
    }

    private void checkErrorMessageIncorrectEmailFormat() {
        loginPage.fillLogin("incorrectEmail@mail");
        loginPage.clickVisiblePasswordButton();
        assertFalse(loginPage.isLoginButtonEnabled(), "Warning! Login button is enabled on LOGIN page when " +
                "filling in LOGIN field with incorrect EMAIL and PASSWORD field with incorrect PASSWORD!");
    }

    private void checkErrorMessageEmptyEmail() {
        loginPage.fillPassword(PASSWORD);
        assertFalse(loginPage.isLoginButtonEnabled(), "Warning! Login button is enabled on LOGIN page " +
                "when filling in only PASSWORD field!");
    }

    private void checkErrorMessageEmptyEmailWrongPassword() {
        loginPage.clearPassword();
        loginPage.fillPassword(incorrectPassword);
        assertFalse(loginPage.isLoginButtonEnabled(), "Warning! Login button is enabled on LOGIN page when " +
                "filling in only PASSWORD field with incorrect PASSWORD!");
    }

    private void checkLoginPageURL() {
        assertTrue(loginPage.isLoginPageURLCorrect(PropertiesReader.getInstance().getBaseUrl()), "Warning! CMS URL " +
                "is incorrect when opening");
    }

}
