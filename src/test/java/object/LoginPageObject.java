package object;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.DataTests;
import ui.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    @Step("Step: Close Popup")
    public void closePopup() {
        clickToElement(driver, LoginPageUI.CLOSE_POPUP_BUTTON);
    }

    @Step("Step: Input invalid email to textbox {0}")
    public void inputToEmailTextbox(String valueEmail) {
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, valueEmail);
    }

    @Step("Step: Input valid password to textbox {0}")
    public void inputToPasswordTextbox(String valuePassword) {
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, valuePassword);
    }

    @Step("Step: Click to Login button}")
    public void clickToLoginButton() {
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public void verifyErrorMessageIsDisplayed() {
        waitToElementVisible(driver, LoginPageUI.ERORR_NOTICE);
        Assert.assertTrue(isControlDisplayed(driver, LoginPageUI.ERORR_NOTICE));
    }

    public void verifyContentErrorMessageIsDisplayedCorrectly() {
        waitToElementVisible(driver, LoginPageUI.ERORR_NOTICE);
        Assert.assertEquals(getTextElement(driver, LoginPageUI.ERORR_NOTICE), DataTests.MESSAGE_INVALID);
    }
}
