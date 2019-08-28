package PageObjects;

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

    private String login = "dfjwgge82h43g3uriy53h";
    private String password = "PlOkIjUHYGC";

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public LoginPage open () {
        driver.get("https://mail.ru//");
        return this;
    }

    public LoginPage enterLogin () {
        waitForElementVisible(loginInput);
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword () {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage chooseDomain() {
        new Select(domainSelector).selectByVisibleText("@bk.ru");
        return this;
    }

    public LoginPage loginToMailBox () {
        loginForm.submit();
        return this;
    }

}
