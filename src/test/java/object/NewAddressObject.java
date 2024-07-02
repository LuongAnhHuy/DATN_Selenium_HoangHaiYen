package object;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import ui.NewAddressUI;

public class NewAddressObject extends AbstractPage {
    WebDriver driver;
    public NewAddressObject (WebDriver driver){
        this.driver = driver;
    }

    public void inputToAddressTextbox(String addresss) {
        scrollIntoView(driver, NewAddressUI.ADDRESS_TEXTBOX);
        sendkeyToElement(driver, NewAddressUI.ADDRESS_TEXTBOX, addresss);
    }

    public void selectCountryInDropdownList(String country) {
        selectItemInDropdow(driver, NewAddressUI.COUNTRY_DROPDOWN, country);
    }

    public void selectStateInDropdownList(String state) {
        scrollIntoView(driver, NewAddressUI.STATE_DROPDOWN);
        selectItemInDropdow(driver, NewAddressUI.STATE_DROPDOWN, state);
    }

    public void selectCityInDropdownList(String city) {
        scrollIntoView(driver, NewAddressUI.CITY_DROPDOWN);
        selectItemInDropdow(driver, NewAddressUI.CITY_DROPDOWN, city);
    }

    public void inputToPostalCodeTextbox(String code) {
        sendkeyToElement(driver, NewAddressUI.POSTAL_CODE_TEXTBOX, code);
    }

    public void inputToPhoneTextbox(String phone) {
        sendkeyToElement(driver, NewAddressUI.PHONE_TEXTBOX, phone);
    }

    public void clickToSaveButton() {
        clickToElement(driver, NewAddressUI.SAVE_BUTTON);
    }
}
