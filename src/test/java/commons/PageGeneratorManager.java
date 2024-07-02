package commons;

import object.DashboardPageObject;
import object.LoginPageObject;
import object.ManageProfileObject;
import object.NewAddressObject;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getDashboard(WebDriver driver){
        return new DashboardPageObject(driver);
    }
    public static ManageProfileObject getManagerProfile(WebDriver driver){
        return new ManageProfileObject(driver);
    }
    public static NewAddressObject getNewAddress(WebDriver driver){
        return new NewAddressObject(driver);
    }
}
