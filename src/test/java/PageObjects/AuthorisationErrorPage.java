package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * created by Andrei_Korotkov 9/4/2019
 */
public class AuthorisationErrorPage extends AbstractPage {

    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement wrongCredentialsMessage;

    public AuthorisationErrorPage (WebDriver driver) {
        super (driver);
    }

    public String getInboxPageURL () {
//        waitForElementVisible(wrongCredentialsMessage);
        return driver.getCurrentUrl();
    }
}
