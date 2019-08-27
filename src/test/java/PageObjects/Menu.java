package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class Menu extends AbstractPage {

    private static final By SEND_LETTER_BUTTON_LOCATOR = By.cssSelector("span[title=\"Отправить\"]");
    private static final By DRAFTS_LINK_BUTTON_LOCATOR = By.cssSelector("a[href=\"/drafts/\"]");
    private static final By SENT_MESSAGES_BUTTON_LOCATOR = By.cssSelector("a[href=\"/sent/\"]");
    private static final By EXIT_BUTTON_LOCATOR = By.cssSelector("a[title=\"выход\"]");

    public Menu (WebDriver driver) {
        super(driver);
    }

    public String readNumberOfDrafts () {
        return driver.findElement(DRAFTS_LINK_BUTTON_LOCATOR).getAttribute("title");
    }

    public Menu goToSentMessages() {
        waitForElementVisible(SENT_MESSAGES_BUTTON_LOCATOR);
        driver.findElement(SENT_MESSAGES_BUTTON_LOCATOR);
        return this;
    }

    public Menu exitAccount () {
        waitForElementVisible(EXIT_BUTTON_LOCATOR);
        driver.findElement(EXIT_BUTTON_LOCATOR).click();
        return this;
    }
}
