/**
 * created by Andrei_Korotkov 8/26/2019
 */

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MailTest {
    public WebDriver driver;

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void mailLoginTest() throws InterruptedException {
        LoginPage MailLoginPage = new LoginPage(driver).open().enterLogin().chooseDomain().enterPassword().loginToMailBox();
        InboxPage MailInboxPage = new InboxPage(driver);
        Assert.assertEquals(MailInboxPage.getInboxPageURL(), "https://e.mail.ru/inbox/?back=1&afterReload=1");
    }

    @Test(dependsOnMethods = {"mailLoginTest"})
    public void writeDraft() throws InterruptedException {
        InboxPage MailInboxPage = new InboxPage(driver).clickWriteLetter().enterAdressee().enterSubject().enterBodyOfLetter().saveDraft().closeFocusField();
        Assert.assertTrue(MailInboxPage.readNumberOfDrafts() != "Нет писем");
        MailInboxPage.goToDrafts();
    }

    @Test(dependsOnMethods = {"writeDraft"})
    public void checkDraft() throws InterruptedException {
        DraftsPage MailDraftPage = new DraftsPage(driver);
        MailDraftPage.clickFirstDraft();
        Assert.assertEquals(MailDraftPage.readAdresseeOfLetter(), "ankorotkov66@gmail.com");
        Assert.assertEquals(MailDraftPage.readSubjectOfLetter(), "autoTest");
        Assert.assertEquals(MailDraftPage.readBodyOfLetter(), "This is autotest letter");
        MailDraftPage.sendLetter().closeReportLetterMessage();
        //Menu MyMenu = new Menu(driver);
        Assert.assertTrue(MailDraftPage.readNumberOfDrafts().equals("Нет писем"));
        MailDraftPage.goToSentMessages();
    }

    @Test(dependsOnMethods = {"checkDraft"})
    public void checkSentMessages() throws InterruptedException {
        SentPage MailSentPage = new SentPage(driver);
        Assert.assertEquals(MailSentPage.readFirstLetterAdressee(), "ankorotkov66@gmail.com");
        Assert.assertEquals(MailSentPage.readFirstLetterSubject(), "autoTest");
        MailSentPage.exitAccount();
    }

//    @AfterClass
//    public void exitBrowser() {
//        driver.quit();
//    }
}
