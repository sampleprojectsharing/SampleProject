package com.company.project.tests;

import com.company.project.actions.LoginActions;
import com.company.project.apiHelpers.BadgesApi;
import com.company.project.dataProviders.PropertiesReader;
import com.company.project.models.Badge;
import com.company.project.pages.BadgesPage;
import com.company.project.pages.HomePage;
import com.company.project.pages.OrderManagementPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class A0063_DeleteBadge extends BaseTest{
    private Badge badge = new Badge();
    private BadgesApi badgesApi;

    @BeforeClass
    private void precondition() {
        badgesApi = new BadgesApi();
        badgesApi.addBadge(LOGIN, PASSWORD, badge);
    }

    @Test (testName = "A0063 Delete Badge")
    public void test() {

        // Login as superadmin
        new LoginActions().login(driver, LOGIN, PASSWORD);

        // Click <Configuration> button
        HomePage homePage = new HomePage(driver);
        OrderManagementPage orderManagementPage = new OrderManagementPage(driver);
        checkOpenOrderManagementPage(homePage, orderManagementPage);

        // Click <Badges> menu tab
        BadgesPage badgesPage = new BadgesPage(driver);
        checkOpenBadgesPage(orderManagementPage, badgesPage);

        // Click "Delete" icon for the badge from preconditions
        clickDeleteBadgeButton(badgesPage);

        // Click <No> button
        clickModalButton(badgesPage, "No");

        // Click "Delete" icon for the badge from preconditions
        clickDeleteBadgeButton(badgesPage);

        // Click <Yes, delete> button
        clickModalButton(badgesPage, "Yes, delete");


    }

    @AfterTest
    private void postCondition() {
        badgesApi.deleteBadge(LOGIN, PASSWORD, badge);
    }

    private void checkOpenBadgesPage(OrderManagementPage orderManagementPage, BadgesPage badgesPage) {
        orderManagementPage.openBadgesPage();
        assertTrue(badgesPage.isBadgesPageURLCorrect(PropertiesReader.getInstance().getBaseUrl()), "Warning! Badges " +
                "page URL is incorrect!");
    }

    private void checkOpenOrderManagementPage(HomePage homePage, OrderManagementPage orderManagementPage) {
        homePage.openOrderManagementPage();
        assertTrue(orderManagementPage.isOrderManagementPageURLCorrect(PropertiesReader.getInstance().getBaseUrl()),
                "Warning! Order Management page URL " +
                "is incorrect!");
    }

    private void clickDeleteBadgeButton(BadgesPage badgesPage) {
        badgesPage.clickDeleteBadgeButton(badge.getBadgeName());
    }

    private void clickModalButton(BadgesPage badgesPage, String btnText) {
        if (btnText.equals("No")) {
            badgesPage.clickNoModalButton();
            assertTrue(badgesPage.isBadgePresented(badge.getBadgeName()), "Warning! Badge isn't displayed after " +
                    "canceling badge deleting!");
        } else {
            badgesPage.clickYesModalButton();
            badgesPage.waitForSpinnerInvisibility();
            assertFalse(badgesPage.isBadgePresented(badge.getBadgeName()), "Warning! Badge is presented after deleting!");
        }
    }
}
