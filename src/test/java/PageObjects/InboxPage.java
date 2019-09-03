package PageObjects;

import Messages.Message;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class InboxPage extends Menu {

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

    @FindBy(xpath = "//div[@class='contactsContainer--3RMuQ']//span[contains(@class, 'text')]")
    private WebElement filledAdresseeField;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]//button[@title=\"Закрыть\"]")
    WebElement closeFocusedZoneButton;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]")
    WebElement focusZone;


    public InboxPage (WebDriver driver) {
        super(driver);
    }

    public String getInboxPageURL () {
        waitForElementVisible(ads);
        return driver.getCurrentUrl();
    }

    public InboxPage clickWriteLetter () {
        waitForElementVisible(writeLetterButton);
        JavascriptExecutor jsClicker = (JavascriptExecutor)driver;
        jsClicker.executeScript("arguments[0].click();", writeLetterButton);
        return this;
    }

    public InboxPage enterAdressee (String addressee) {
        waitForElementVisible(adresseeField);
        adresseeField.sendKeys(addressee);
        return this;
    }

    public InboxPage enterSubject(String subject) {
        subjectField.sendKeys(subject);
        return this;
    }

    public InboxPage enterBodyOfLetter (String body) {
        letterBody.sendKeys(body);
        return this;
    }

    public InboxPage highlightLetterElements () throws InterruptedException {
        JavascriptExecutor jsHighlilhter = (JavascriptExecutor)driver;
        jsHighlilhter.executeScript("arguments[0].setAttribute('style', 'background: yellow; ');", filledAdresseeField);
        jsHighlilhter.executeScript("arguments[0].setAttribute('style', 'background: yellow; ');", subjectField);
        jsHighlilhter.executeScript("arguments[0].setAttribute('style', 'background: yellow; ');", letterBody);
        Thread.sleep(2000); //для заметности выделения
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

    public InboxPage writeDraft (Message message) throws InterruptedException {
        clickWriteLetter();
        enterAdressee(message.getAddressee());
        enterSubject(message.getSubject());
        enterBodyOfLetter(message.getBody());
        highlightLetterElements();
        saveDraft();
        closeFocusField();
        return this;
    }
}




