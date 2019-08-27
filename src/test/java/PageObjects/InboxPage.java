package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class InboxPage extends AbstractPage {
//    private static final By WRITE_LETTER_BUTTON_LOCATOR = By.cssSelector("span.compose-button");
//    private static final By ADRESSEE_FIELD_LOCATOR = By.xpath("//div[@class='contactsContainer--3RMuQ']//input");
//    private static final By SUBJECT_FIELD_LOCATOR = By.xpath("//div[@class='subject__container--HWnat']//input");
//    private static final By LETTER_BODY_LOCATOR = By.cssSelector("div[role=textbox]");
//    private static final By SAVE_DRAFT_BUTTON_LOCATOR = By.cssSelector("span.button2_base:nth-child(2)");
//    private static final By CLOSE_FOCUSED_ZONE_BUTTON_LOCATOR = By.xpath("//div[@class=\"focus-zone focus-zone_fluid\"]//button[@title=\"Закрыть\"]");
//    private static final By DRAFTS_LINK_BUTTON_LOCATOR = By.cssSelector("a[href=\"/drafts/\"]");
//    private static final By FOCUS_ZONE_LOCATOR = By.xpath("//div[@class=\"focus-zone focus-zone_fluid\"]");
    @FindBy(css = "span.compose-button")
    private WebElement writeLetterButton;

    @FindBy(xpath = "//div[@class='contactsContainer--3RMuQ']//input")
    private WebElement adresseeField;

    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    private WebElement subjectField;

    @FindBy(css = "div[role=textbox]")
    private WebElement letterBody;

    @FindBy(css = "span.button2_base:nth-child(2)")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]//button[@title=\"Закрыть\"]")
    private WebElement closeFocusedZoneButton;

    @FindBy(css = "a[href=\"/drafts/\"]")
    private WebElement draftsButton;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]")
    private WebElement focusZone;


    private String adressee = "ankorotkov66@gmail.com";
    private String subject = "autoTest";
    private String body = "This is autotest letter";

    public InboxPage (WebDriver driver) {
        super(driver);
    }

    public String getInboxPageURL () {
        waitForElementClickable(writeLetterButton);
        return driver.getCurrentUrl();
    }

    public InboxPage clickWriteLetter () {
        waitForElementVisible(writeLetterButton);
        writeLetterButton.click();
        return this;
    }

    public InboxPage enterAdressee () {
        waitForElementVisible(adresseeField);
        adresseeField.sendKeys(adressee);
        return this;
    }

    public InboxPage enterSubject() {
        subjectField.sendKeys(subject);
        return this;
    }

    public InboxPage enterBodyOfLetter () {
        letterBody.sendKeys(body);
        return this;
    }

    public InboxPage saveDraft () {
        saveDraftButton.click();
        return this;
    }

    public InboxPage closeFocusField () {
        closeFocusedZoneButton.click();
        return this;
    }

    public String readNumberOfDrafts () {
        //waitForElementNotVisible(focusZone);
        return draftsButton.getAttribute("title");
    }

    public InboxPage goToDrafts () {
        waitForElementClickable(draftsButton);
        draftsButton.click();
        return this;
    }
}




