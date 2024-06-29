package testcases;

import commons.BaseTest;
import object.DashboardPageObject;
import object.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.DataAccount;
import testdata.DataURL;

public class VerifyFunctionLogin extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    DashboardPageObject dashboardPageObject;

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String browserName){
        driver = getBrowserDriver(browserName);
        openUrl(driver, DataURL.LOGIN_URL);
    }

    @AfterClass
    public void closeBrowser(){
        quitBrowser();
    }

    @Test
    public void TC_01_Login_with_Email_invalid(){
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.closePopup();
        loginPageObject.inputToEmailTextbox(DataAccount.USERNAME_INVALID);
        loginPageObject.inputToPasswordTextbox(DataAccount.PASSWORD);
        loginPageObject.clickToLoginButton();
        loginPageObject.verifyErrorMessageIsDisplayed();
        loginPageObject.verifyContentErrorMessageIsDisplayedCorrectly();
    }

    @Test
    public void TC_02_Login_witn_password_invalid(){
        refreshToPage(driver);
        loginPageObject.inputToEmailTextbox(DataAccount.USERNAME);
        loginPageObject.inputToPasswordTextbox(DataAccount.PASSWORD_INVALID);
        loginPageObject.clickToLoginButton();
        loginPageObject.verifyErrorMessageIsDisplayed();
        loginPageObject.verifyContentErrorMessageIsDisplayedCorrectly();
    }

    @Test
    public void TC_03_Login_successfully(){
        refreshToPage(driver);
        loginPageObject.inputToEmailTextbox(DataAccount.USERNAME);
        loginPageObject.inputToPasswordTextbox(DataAccount.PASSWORD);
        loginPageObject.clickToLoginButton();

        dashboardPageObject = new DashboardPageObject(driver);
        dashboardPageObject.verifyMyPanelIsDisplayed();
        dashboardPageObject.verifyDashboardIsDisplayed();
    }
}
