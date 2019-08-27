package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class InboxPage extends AbstractPage {
    private static final By WRITE_LETTER_BUTTON_LOCATOR = By.cssSelector("span.compose-button");
    private static final By ADRESSEE_FIELD_LOCATOR = By.xpath("//div[@class='contactsContainer--3RMuQ']//input");
    private static final By SUBJECT_FIELD_LOCATOR = By.xpath("//div[@class='subject__container--HWnat']//input");
    private static final By LETTER_BODY_LOCATOR = By.cssSelector("div[role=textbox]");
    private static final By SAVE_DRAFT_BUTTON_LOCATOR = By.cssSelector("span.button2_base:nth-child(2)");
    private static final By CLOSE_FOCUSED_ZONE_BUTTON_LOCATOR = By.xpath("//div[@class=\"focus-zone focus-zone_fluid\"]//button[@title=\"Закрыть\"]");
    private static final By DRAFTS_LINK_BUTTON_LOCATOR = By.cssSelector("a[href=\"/drafts/\"]");
    private static final By FOCUS_ZONE_LOCATOR = By.xpath("//div[@class=\"focus-zone focus-zone_fluid\"]");
    private String adressee = "ankorotkov66@gmail.com";
    private String subject = "autoTest";
    private String body = "This is autotest letter";

    public InboxPage (WebDriver driver) {
        super(driver);
    }

    public String getInboxPageURL () {
        waitForElementClickable(WRITE_LETTER_BUTTON_LOCATOR);
        return driver.getCurrentUrl();
    }

    public InboxPage clickWriteLetter () {
        waitForElementVisible(WRITE_LETTER_BUTTON_LOCATOR);
        driver.findElement(WRITE_LETTER_BUTTON_LOCATOR).click();
        return this;
    }

    public InboxPage enterAdressee () {
        waitForElementVisible(ADRESSEE_FIELD_LOCATOR);
        driver.findElement(ADRESSEE_FIELD_LOCATOR).sendKeys(adressee);
        return this;
    }

    public InboxPage enterSubject() {
        driver.findElement(SUBJECT_FIELD_LOCATOR).sendKeys(subject);
        return this;
    }

    public InboxPage enterBodyOfLetter () {
        driver.findElement(LETTER_BODY_LOCATOR).sendKeys(body);
        return this;
    }

    public InboxPage saveDraft () {
        driver.findElement(SAVE_DRAFT_BUTTON_LOCATOR).click();
        return this;
    }

    public InboxPage closeFocusField () {
        driver.findElement(CLOSE_FOCUSED_ZONE_BUTTON_LOCATOR).click();
        return this;
    }

    public String readNumberOfDrafts () {
        waitForElementNotVisible(FOCUS_ZONE_LOCATOR);
        return driver.findElement(DRAFTS_LINK_BUTTON_LOCATOR).getAttribute("title");
    }

    public InboxPage goToDrafts () {
        waitForElementClickable(DRAFTS_LINK_BUTTON_LOCATOR);
        driver.findElement(DRAFTS_LINK_BUTTON_LOCATOR).click();
        return this;
    }
}




