package object;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.ManageProfileUI;

public class ManageProfileObject extends AbstractPage {

    WebDriver driver;
    public ManageProfileObject (WebDriver driver){
        this.driver = driver;
    }

    public void inputToYourNameTextbox(String valueName) {
        sendkeyToElement(driver, ManageProfileUI.NAME_TEXTBOX, valueName);
    }

    public void inputToYourPhoneTextbox(String valuePhone) {
        sendkeyToElement(driver, ManageProfileUI.PHONE_TEXTBOX, valuePhone);
    }

    public void clickToUpdateProfileButton() {
        clickToElement(driver, ManageProfileUI.UPDATE_PROFILE_BUTTON);
    }

    public void verifyValueOfYourName(String expectedName) {
        Assert.assertEquals(getElementAttribute(driver, ManageProfileUI.NAME_TEXTBOX, "value"), expectedName);
    }

    public void verifyValueOfYourPhone(String expectedPhone) {
        Assert.assertEquals(getElementAttribute(driver, ManageProfileUI.PHONE_TEXTBOX, "value"), expectedPhone);
    }

    public NewAddressObject clickToAddNewAddress() {
        scrollIntoViewToClick(driver, ManageProfileUI.ADD_ADDRESS_BUTTON);
        return PageGeneratorManager.getNewAddress(driver);
    }
}
