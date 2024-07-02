package testcases;

import commons.BaseTest;
import commons.PageGeneratorManager;
import object.DashboardPageObject;
import object.LoginPageObject;
import object.ManageProfileObject;
import object.NewAddressObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.DataAccount;
import testdata.DataTests;
import testdata.DataURL;

public class VerifyFunctionLogin extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    DashboardPageObject dashboardPageObject;
    ManageProfileObject manageProfileObject;
    NewAddressObject newAddressObject;

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String browserName) {
        driver = getBrowserDriver(browserName);
        openPageUrl(driver, DataURL.LOGIN_URL);
    }

    @AfterClass
    public void closeBrowser() {
        quitBrowser();
    }

    @Test
    public void TC_01_Login_with_Email_invalid() {
        loginPageObject = PageGeneratorManager.getLoginPage(driver);
        loginPageObject.closePopup();
        loginPageObject.inputToEmailTextbox(DataAccount.USERNAME_INVALID);
        loginPageObject.inputToPasswordTextbox(DataAccount.PASSWORD);
        loginPageObject.clickToLoginButton();
        loginPageObject.verifyErrorMessageIsDisplayed();
        loginPageObject.verifyContentErrorMessageIsDisplayedCorrectly();
    }

    @Test
    public void TC_02_Login_witn_password_invalid() {
        refreshToPage(driver);
        loginPageObject.inputToEmailTextbox(DataAccount.USERNAME);
        loginPageObject.inputToPasswordTextbox(DataAccount.PASSWORD_INVALID);
        loginPageObject.clickToLoginButton();
        loginPageObject.verifyErrorMessageIsDisplayed();
        loginPageObject.verifyContentErrorMessageIsDisplayedCorrectly();
    }

    @Test
    public void TC_03_Login_successfully() {
        refreshToPage(driver);
        loginPageObject.inputToEmailTextbox(DataAccount.USERNAME);
        loginPageObject.inputToPasswordTextbox(DataAccount.PASSWORD);

        dashboardPageObject = loginPageObject.clickToLoginButton();
        dashboardPageObject.verifyMyPanelIsDisplayed();
        dashboardPageObject.verifyDashboardIsDisplayed();
    }

    @Test
    public void TC_04_Update_Profiles(){
        manageProfileObject = dashboardPageObject.clickToManageProfile(DataTests.MANAGE_PROFILE_NAVIGATION);
        manageProfileObject.inputToYourNameTextbox(DataTests.YOUR_NAME);
        manageProfileObject.inputToYourPhoneTextbox(DataTests.YOUR_PHONE);
        manageProfileObject.clickToUpdateProfileButton();
        refreshToPage(driver);
        manageProfileObject.verifyValueOfYourName(DataTests.YOUR_NAME);
        manageProfileObject.verifyValueOfYourPhone(DataTests.YOUR_PHONE);
    }
    @Test
    public void TC_05_Add_Address(){
        newAddressObject = manageProfileObject.clickToAddNewAddress();
        newAddressObject.inputToAddressTextbox(DataTests.ADDRESS);
        newAddressObject.selectCountryInDropdownList(DataTests.COUNTRY);
        newAddressObject.selectStateInDropdownList(DataTests.STATE);
        newAddressObject.selectCityInDropdownList(DataTests.CITY);
        newAddressObject.inputToPostalCodeTextbox(DataTests.POSTALCODE);
        newAddressObject.inputToPhoneTextbox(DataTests.PHONE);
        newAddressObject.clickToSaveButton();
    }
}
