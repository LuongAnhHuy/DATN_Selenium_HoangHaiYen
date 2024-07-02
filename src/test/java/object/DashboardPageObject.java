package object;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.DataTests;
import ui.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {
    WebDriver driver;
    public DashboardPageObject(WebDriver driver){
        this.driver = driver;
    }
    @Step("Verify My Panel hyperlink is displayed")
    public void verifyMyPanelIsDisplayed() {
        Assert.assertTrue(isControlDisplayed(driver, DashboardPageUI.MYPANEL_HYPERLINK));
    }

    @Step("Verify Dashboard text is displayed")
    public void verifyDashboardIsDisplayed() {
        Assert.assertTrue(isControlDisplayed(driver, DashboardPageUI.DASHBOARD_TEXT));
    }

    @Step("Click to Manage Profile hyperlink")
    public void clickToManageProfile(String value) {
        //waitToElementPresence(driver, DashboardPageUI.NAVIGATION_BAR);
        //getItemInListItem(driver, DashboardPageUI.NAVIGATION_BAR, DataTests.MANAGE_PROFILE_NAVIGATION);
        clickItemInListItem(driver, DashboardPageUI.NAVIGATION_BAR, value);
    }
}
