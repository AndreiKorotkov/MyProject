package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class SentPage extends AbstractPage {

    @FindBy(css = "a.llc_first")
    private WebElement firstLetter;

    @FindBy(how = How.XPATH, using = "//a[contains (@class, 'llc')][1]//span[@class='ll-crpt']")
    private WebElement firstLetterAdressee;

    @FindBy(how = How.XPATH, using = "//a[contains (@class, 'llc')][1]//span[@class='ll-sj__normal']")
    private WebElement firstLetterSubject;


    public String readFirstLetterAdressee() {
        waitForElementVisible(firstLetterAdressee);
        String text = firstLetterAdressee.getAttribute("title");
        return text;
    }

    public String readFirstLetterSubject() {
        String text = firstLetterSubject.getText();
        return text;
    }

    public SentPage(WebDriver driver) {
        super(driver);
    }
}
