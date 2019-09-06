import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MailTest {
    public static WebDriver driver;

    @Parameters({"browserName"})
    @BeforeClass
    public void setup(String browserName) {
        driver = DriverManager.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void mailLoginTest(){
        LoginPage MailLoginPage = new LoginPage(driver).open().enterLogin().chooseDomain().pressEnterPasswordButton().enterPassword().loginToMailBox();
        InboxPage MailInboxPage = new InboxPage(driver);
        Assert.assertEquals(MailInboxPage.getInboxPageURL(), "https://e.mail.ru/inbox/?back=1&afterReload=1");
    }

    @Test(dependsOnMethods = {"mailLoginTest"})
    public void writeDraft() throws InterruptedException {
        InboxPage MailInboxPage = new InboxPage(driver).clickWriteLetter().enterAdressee().enterSubject().enterBodyOfLetter();
        MailInboxPage.highlightLetterElements();
        MailInboxPage.saveDraft().closeFocusField();
        Assert.assertTrue(MailInboxPage.readNumberOfDrafts() != "Нет писем");
        MailInboxPage.goToDrafts();
    }

    @Test(dependsOnMethods = {"writeDraft"})
    public void checkDraft(){
        DraftsPage MailDraftPage = new DraftsPage(driver);
        MailDraftPage.clickFirstDraft();
        Assert.assertEquals(MailDraftPage.readAdresseeOfLetter(), "ankorotkov66@gmail.com");
        Assert.assertEquals(MailDraftPage.readSubjectOfLetter(), "autoTest");
        Assert.assertEquals(MailDraftPage.readBodyOfLetter(), "This is autotest letter");
        MailDraftPage.sendLetter().closeReportLetterMessage();
        Assert.assertTrue(MailDraftPage.readNumberOfDrafts().equals("Нет писем"));
        MailDraftPage.goToSentMessages();
    }

    @Test(dependsOnMethods = {"checkDraft"})
    public void checkSentMessages() {
        SentPage MailSentPage = new SentPage(driver);
        Assert.assertEquals(MailSentPage.readFirstLetterAdressee(), "ankorotkov66@gmail.com");
        Assert.assertEquals(MailSentPage.readFirstLetterSubject(), "autoTest");
        MailSentPage.moveLettersToTrashCan();
        MailSentPage.exitAccount();
    }

    @AfterClass
    public void exitBrowser() {
        driver.quit();
    }
}
