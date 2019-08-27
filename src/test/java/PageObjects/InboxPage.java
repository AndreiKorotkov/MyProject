package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class InboxPage extends AbstractPage {

    @FindBy(how = How.CSS, using = "span.compose-button")
    WebElement writeLetterButton;

    @FindBy(how=How.CSS,using = "div.slot")
    WebElement ads;

    @FindBy(xpath = "//div[@class='contactsContainer--3RMuQ']//input")
    WebElement adresseeField;

    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    WebElement subjectField;

    @FindBy(css = "div[role=textbox]")
    WebElement letterBody;

    @FindBy(css = "span.button2_base:nth-child(2)")
    WebElement saveDraftButton;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]//button[@title=\"Закрыть\"]")
    WebElement closeFocusedZoneButton;

    @FindBy(css = "a[href=\"/drafts/\"]")
    WebElement draftsButton;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]")
    WebElement focusZone;

    private String adressee = "ankorotkov66@gmail.com";
    private String subject = "autoTest";
    private String body = "This is autotest letter";

    public InboxPage (WebDriver driver) {
        super(driver);
    }

    public String getInboxPageURL () {
        waitForElementVisible(ads);
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
         return draftsButton.getAttribute("title");
    }

    public InboxPage goToDrafts () {
        waitForElementClickable(draftsButton);
        draftsButton.click();
        return this;
    }
}




