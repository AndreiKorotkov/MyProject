package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class Menu extends AbstractPage {

    private static final By SEND_LETTER_BUTTON_LOCATOR = By.cssSelector("span[title=\"Отправить\"]");
//    private static final By DRAFTS_LINK_BUTTON_LOCATOR = By.cssSelector("a[href=\"/drafts/\"]");
//    private static final By SENT_MESSAGES_BUTTON_LOCATOR = By.cssSelector("a[href=\"/sent/\"]");
//    private static final By EXIT_BUTTON_LOCATOR = By.cssSelector("a[title=\"выход\"]");

    @FindBy(css = "a[href=\"/drafts/\"]")
    private WebElement draftsLinkButton;

    @FindBy(css = "a[href=\"/sent/\"]")
    private WebElement sentMessagesButton;

    @FindBy(css = "a[title=\"выход\"]")
    private WebElement exitButton;

    public Menu (WebDriver driver) {
        super(driver);
    }

    public String readNumberOfDrafts () {
        return draftsLinkButton.getAttribute("title");
    }

    public Menu goToSentMessages() {
        waitForElementVisible(sentMessagesButton);
        sentMessagesButton.click();
        return this;
    }

    public Menu exitAccount () {
        waitForElementVisible(exitButton);
        exitButton.click();
        return this;
    }
}
