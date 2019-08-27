package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class DraftsPage extends AbstractPage {
    private static final By FIRST_LETTER_LOCATOR = By.cssSelector("a.llc_first");
    private static final By FOCUS_ZONE_LOCATOR = By.xpath("//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]");
    private static final By ADRESSEE_FIELD_LOCATOR = By.xpath("//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]");
    private static final By SUBJECT_FIELD_LOCATOR = By.xpath("//div[@class='subject__container--HWnat']//input");
    private static final By LETTER_BODY_FIELD_LOCATOR = By.xpath("//div[contains(@id, \"BODY\")]/div/div/div");
    private static final By SEND_LETTER_BUTTON_LOCATOR = By.cssSelector("span[title=\"Отправить\"]");
    private static final By CLOSE_SENT_REPORT_BUTTON_LOCATOR = By.xpath("//div[@class=\"layer-sent-page\"]//span[@class=\"button2__ico\"]");

    public DraftsPage (WebDriver driver) {
        super(driver);
    }

    public String readURL () {
        waitForElementVisible(FIRST_LETTER_LOCATOR);
        return driver.getCurrentUrl();
    }

    public DraftsPage clickFirstDraft () {
        waitForElementClickable(FIRST_LETTER_LOCATOR);
        driver.findElement(FIRST_LETTER_LOCATOR).click();
        return this;
    }

    public String readAdresseeOfLetter () {
        waitForElementVisible(FOCUS_ZONE_LOCATOR);
        return driver.findElement(ADRESSEE_FIELD_LOCATOR).getText();
    }

    public String readSubjectOfLetter () {
        return driver.findElement(SUBJECT_FIELD_LOCATOR).getAttribute("value");
    }

   public String readBodyOfLetter () {
        return driver.findElement(LETTER_BODY_FIELD_LOCATOR).getText();
   }

   public DraftsPage sendLetter () {
        driver.findElement(SEND_LETTER_BUTTON_LOCATOR).click();
        return this;
   }

   public DraftsPage closeReportLetterMessage () {
        waitForElementVisible(CLOSE_SENT_REPORT_BUTTON_LOCATOR);
        driver.findElement(CLOSE_SENT_REPORT_BUTTON_LOCATOR).click();
        return this;
   }

}
