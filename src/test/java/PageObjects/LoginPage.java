package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class LoginPage extends AbstractPage {

    private static final By LOGIN_INPUT_LOCATOR = By.cssSelector("input[placeholder='Имя ящика']");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("mailbox:password");
    private static final By DOMAIN_SELECTOR_LOCATOR = By.id("mailbox:domain");
    private static final By LOGIN_FORM_LOCATOR = By.id("auth");
    private String login = "dfjwgge82h43g3uriy53h";
    private String password = "PlOkIjUHYGC";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get("https://mail.ru//");
        return this;
    }

    public LoginPage enterLogin() {
        waitForElementVisible(LOGIN_INPUT_LOCATOR);
        driver.findElement(LOGIN_INPUT_LOCATOR).sendKeys(login);
        return this;
    }

    public LoginPage enterPassword() {
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        return this;
    }

    public LoginPage chooseDomain() {
        new Select(driver.findElement(DOMAIN_SELECTOR_LOCATOR)).selectByVisibleText("@bk.ru");
        return this;
    }

    public LoginPage loginToMailBox() {
        driver.findElement(LOGIN_FORM_LOCATOR).submit();
        return this;
    }

}
