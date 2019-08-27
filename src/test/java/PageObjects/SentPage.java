package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class SentPage extends AbstractPage{

    private static final By FIRST_LETTER_LOCATOR = By.cssSelector("a.llc_first");
    private static final By FIRST_LETTER_ADRESSEE_LOCATOR = By.xpath("//a[contains (@class, \"llc_first\")]//span[@class=\"ll-crpt\"]");
    private static final By FIRST_LETTER_SUBJECT_LOCATOR = By.xpath("//a[contains (@class, \"llc_first\")]//span[@class=\"ll-sj__normal\"]");


    public String readFirstLetterAdressee() {
        waitForElementVisible(FIRST_LETTER_LOCATOR);
        return driver.findElement(FIRST_LETTER_ADRESSEE_LOCATOR).getText();
    }

    public String readFirstLetterSubject() {
        waitForElementVisible(FIRST_LETTER_LOCATOR);
        return driver.findElement(FIRST_LETTER_SUBJECT_LOCATOR).getText();
    }

    public SentPage (WebDriver driver) {
        super(driver);
    }
}
