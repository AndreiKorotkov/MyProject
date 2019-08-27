package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class SentPage extends AbstractPage{

//    private static final By FIRST_LETTER_LOCATOR = By.cssSelector("a.llc_first");
//    private static final By FIRST_LETTER_ADRESSEE_LOCATOR = By.xpath("//a[contains (@class, \"llc_first\")]//span[@class=\"ll-crpt\"]");
//    private static final By FIRST_LETTER_SUBJECT_LOCATOR = By.xpath("//a[contains (@class, \"llc_first\")]//span[@class=\"ll-sj__normal\"]");


    @FindBy(css = "a.llc_first")
    private WebElement firstLetter;

    @FindBy(xpath = "//a[contains (@class, \"llc\")][1]//span[@class=\"ll-crpt\"]")
    private WebElement firstLetterAdressee;

    @FindBy(xpath = "//a[contains (@class, \"llc\")][1]//span[@class=\"ll-sj__normal\"]")
    private WebElement firstLetterSubject;



    public String readFirstLetterAdressee() {
        new WebDriverWait(driver, 10, 1000).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a.llc")));
        return firstLetterAdressee.getAttribute("title");
    }

    public String readFirstLetterSubject() {
        //waitForElementVisible(firstLetterAdressee);
        new WebDriverWait(driver, 10, 1000).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a.llc")));
        return firstLetterSubject.getText();
    }

    public SentPage (WebDriver driver) {
        super(driver);
    }
}
