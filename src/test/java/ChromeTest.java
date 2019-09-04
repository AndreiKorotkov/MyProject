/**
 * created by Andrei_Korotkov 8/26/2019
 */

import BusinessObjects.Message;
import PageObjects.*;
import SystemProperties.DriverManager;
import BusinessObjects.ValidUser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

    public static WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        driver = DriverManager.getDriver("firefox");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void mailLoginTest(){
        new LoginPage(driver).loginToMailBox(new ValidUser());
        Assert.assertEquals(new InboxPage(driver).getInboxPageURL(), "https://e.mail.ru/inbox/?back=1&afterReload=1");
    }

    @Test(dependsOnMethods = {"mailLoginTest"})
    public void writeDraft() throws InterruptedException {
        InboxPage MailInboxPage = new InboxPage(driver).writeDraft(new Message());
        Assert.assertNotSame("Нет писем", MailInboxPage.readNumberOfDrafts());
    }

    @Test(dependsOnMethods = {"writeDraft"})
    public void checkDraft(){
        DraftsPage MailDraftPage = new DraftsPage(driver).clickFirstDraft();
        Assert.assertEquals(MailDraftPage.readAdresseeOfLetter(), "ankorotkov66@gmail.com");
        Assert.assertEquals(MailDraftPage.readSubjectOfLetter(), "autoTest");
        Assert.assertEquals(MailDraftPage.readBodyOfLetter(), "This is autotest letter");
        MailDraftPage.sendLetter();
        Assert.assertEquals(MailDraftPage.readNumberOfDrafts(), "Нет писем");
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
