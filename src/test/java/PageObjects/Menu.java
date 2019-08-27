package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class Menu extends AbstractPage {

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
        waitForElementHasAttribute(draftsLinkButton, "title");
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
