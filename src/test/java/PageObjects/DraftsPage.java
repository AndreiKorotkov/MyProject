package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class DraftsPage extends AbstractPage {
//    private static final By FIRST_LETTER_LOCATOR = By.cssSelector("a.llc_first");
//    private static final By FOCUS_ZONE_LOCATOR = By.xpath("//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]");
//    private static final By ADRESSEE_FIELD_LOCATOR = By.xpath("//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]");
//    //private static final By SUBJECT_FIELD_LOCATOR = By.xpath("//div[@class='subject__container--HWnat']//input");
//    private static final By LETTER_BODY_FIELD_LOCATOR = By.xpath("//div[contains(@id, \"BODY\")]/div/div/div");
//    private static final By SEND_LETTER_BUTTON_LOCATOR = By.cssSelector("span[title=\"Отправить\"]");
//    private static final By CLOSE_SENT_REPORT_BUTTON_LOCATOR = By.xpath("//div[@class=\"layer-sent-page\"]//span[@class=\"button2__ico\"]");

    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    private WebElement subjectField;

    @FindBy(xpath = "//a[contains (@class, \"llc\")][1]")
    private WebElement firstLetter;

    @FindBy(xpath = "//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]")
    private WebElement focusZone;

    @FindBy(xpath = "//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]")
    private WebElement adresseeField;

    @FindBy(xpath = "//div[contains(@id, \"BODY\")]/div/div/div")
    private WebElement letterBodyField;

    @FindBy(css = "span[title=\"Отправить\"]")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//div[@class=\"layer-sent-page\"]//span[@class=\"button2__ico\"]")
    private WebElement closeSentReportButton;



    public DraftsPage (WebDriver driver) {
        super(driver);
    }

    public String readURL () {
        waitForElementVisible(firstLetter);
        return driver.getCurrentUrl();
    }

    public DraftsPage clickFirstDraft () {
        firstLetter.click();
        return this;
    }

    public String readAdresseeOfLetter () {
        waitForElementVisible(focusZone);
        return adresseeField.getText();
    }

    public String readSubjectOfLetter () {
       return subjectField.getAttribute("value");
    }

   public String readBodyOfLetter () {
        return letterBodyField.getText();
   }

   public DraftsPage sendLetter () {
        sendLetterButton.click();
        return this;
   }

   public DraftsPage closeReportLetterMessage () {
        waitForElementVisible(closeSentReportButton);
        closeSentReportButton.click();
        return this;
   }

}
