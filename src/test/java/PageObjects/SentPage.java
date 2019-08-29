package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class SentPage extends Menu {

    @FindBy(css = "a.llc_first")
    private WebElement firstLetter;

    @FindBy(how = How.XPATH, using = "//a[contains (@class, 'llc')][1]//span[@class='ll-crpt']")
    private WebElement firstLetterAdressee;

    @FindBy(how = How.XPATH, using = "//a[contains (@class, 'llc')][1]//span[@class='ll-sj__normal']")
    private WebElement firstLetterSubject;

    @FindBy(css = "a[href='/trash/']")
    private WebElement trashCan;

    @FindBy(css = "button.ll-av_centered")
    private WebElement letterSelector;

    @FindBy (xpath = "//div[@class='dataset__items']//a[last()-1]//button[contains(@class, 'll-av_centered')]")
    private WebElement lastLetterSelector;

    public String readFirstLetterAdressee() {
        waitForElementClickable(firstLetterAdressee);
        String text = firstLetterAdressee.getAttribute("title");
        return text;
    }

    public String readFirstLetterSubject() {
        String text = firstLetterSubject.getText();
        return text;
    }

    public SentPage moveLettersToTrashCan() {
        waitForElementClickable(letterSelector);
        Actions builder = new Actions(driver);
        builder.click(letterSelector).keyDown(Keys.SHIFT).click(lastLetterSelector).dragAndDrop(lastLetterSelector, trashCan).build().perform();
        return this;
    }

    public SentPage(WebDriver driver) {
        super(driver);
    }
}
