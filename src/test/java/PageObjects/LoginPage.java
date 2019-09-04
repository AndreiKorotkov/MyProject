package PageObjects;

import BusinessObjects.ValidUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class LoginPage extends Menu{

    @FindBy(css = "input[placeholder='Имя ящика']")
    private WebElement loginInput;

    @FindBy(id = "mailbox:password")
    private WebElement passwordInput;

    @FindBy(id = "mailbox:domain")
    private WebElement domainSelector;

    @FindBy(id = "auth")
    private WebElement loginForm;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public LoginPage open () {
        driver.get("https://mail.ru//");
        return this;
    }

    public LoginPage enterLogin (String login) {
        waitForElementVisible(loginInput);
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword (String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage chooseDomain(String domain) {
        new Select(domainSelector).selectByVisibleText(domain);
        return this;
    }

    public void loginToMailBox (ValidUser validUser) {
        String login = validUser.getLOGIN();
        String password = validUser.getPASSWORD();
        String domain = validUser.getDOMAIN();
        open();
        enterLogin(login);
        enterPassword(password);
        chooseDomain(domain);
        loginForm.submit();
    }

}
