package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class Menu extends AbstractPage {

    @FindBy(css = "a[href=\"/drafts/\"]")
    private WebElement draftsButton;

    @FindBy(css = "a[href=\"/sent/\"]")
    private WebElement sentMessagesButton;

    @FindBy(css = "a[title=\"выход\"]")
    private WebElement exitButton;

    public Menu (WebDriver driver) {
        super(driver);
    }

    public String readNumberOfDrafts () {
        waitForElementHasAttribute(draftsButton, "title");
        //new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(draftsButton));
        JavascriptExecutor jsReader = (JavascriptExecutor)driver;
        return draftsButton.getAttribute("title");
    }

    public Menu goToDrafts () {
        waitForElementClickable(draftsButton);
        draftsButton.click();
        return this;
    }

    public void goToSentMessages() {
        waitForElementVisible(sentMessagesButton);
        sentMessagesButton.click();
    }

    public Menu exitAccount () {
        waitForElementVisible(exitButton);
        exitButton.click();
        return this;
    }
}
