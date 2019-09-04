import BusinessObjects.InvalidUser;

import PageObjects.AuthorisationErrorPage;
import PageObjects.LoginPage;
import SystemProperties.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * created by Andrei_Korotkov 9/4/2019
 */
public class InvalidUserTest {
    public static WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        driver = DriverManager.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void mailLoginTest(){
        new LoginPage(driver).loginToMailBox(new InvalidUser());
        Assert.assertNotEquals(new AuthorisationErrorPage(driver).getInboxPageURL(), "https://e.mail.ru/inbox/?back=1&afterReload=1");
    }

    @AfterClass
    public void exitBrowser() {
        driver.quit();
    }
}
