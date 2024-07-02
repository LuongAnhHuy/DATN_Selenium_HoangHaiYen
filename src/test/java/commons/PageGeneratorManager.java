package commons;

import object.DashboardPageObject;
import object.LoginPageObject;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getDashboard(WebDriver driver){
        return new DashboardPageObject(driver);
    }
}
