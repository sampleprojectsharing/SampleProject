package com.company.project.tests;

import com.company.project.actions.LoginActions;
import com.company.project.pages.HomePage;
import com.company.project.pages.ProfilePage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class A0003_VerifyProfile extends BaseTest {

    @Test (testName = "A0003 Check Profile")
    public void test() {

        LoginActions loginActions = new LoginActions();
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginActions.login(driver, LOGIN, PASSWORD);
        homePage.openProfilePage();

        assertEquals(profilePage.getFullName(), USERNAME, "Full name is not as expected!");
        assertEquals(profilePage.getEmail(), LOGIN, "Email is not as expected!");
    }
}