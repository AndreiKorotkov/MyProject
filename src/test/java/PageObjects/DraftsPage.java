package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class DraftsPage extends Menu {

    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    private WebElement subjectField;

    @FindBy(how= How.XPATH,using = "//a[contains (@class, 'js-letter-list-item')] [1]")
    private WebElement firstDraft;

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

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public DraftsPage clickFirstDraft() {
        goToDrafts();
        waitForElementVisible(firstDraft);
        firstDraft.click();
        return this;
    }

    public String readAdresseeOfLetter() {
        waitForElementVisible(focusZone);
        return adresseeField.getText();
    }

    public String readSubjectOfLetter() {
        return subjectField.getAttribute("value");
    }

    public String readBodyOfLetter() {
        return letterBodyField.getText();
    }

    public DraftsPage closeReportLetterMessage() {
        waitForElementVisible(closeSentReportButton);
        closeSentReportButton.click();
        return this;
    }

    public DraftsPage sendLetter() {
        sendLetterButton.click();
        closeReportLetterMessage();
        return this;
    }
}
