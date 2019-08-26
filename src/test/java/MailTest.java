/**
 * created by Andrei_Korotkov 8/26/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MailTest {
    public WebDriver driver;
    public String adressee = "ankorotkov66@gmail.com";
    public String subject = "autoTest";
    public String body = "This is autotest letter";

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://mail.ru//");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void mailLoginTest() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(), "https://mail.ru//", "Wrong URL");
        WebElement mailLogin = driver.findElement(By.cssSelector("input[placeholder='Имя ящика']"));
        mailLogin.sendKeys("dfjwgge82h43g3uriy53h");
        WebElement mailPassword = driver.findElement(By.id("mailbox:password"));
        mailPassword.sendKeys("PlOkIjUHYGC");
        WebElement mailDomain = driver.findElement(By.id("mailbox:domain"));
        mailDomain.click();
        WebElement domainSelector = driver.findElement(By.cssSelector("select.o-control"));
        Select domainSelect = new Select(domainSelector);
        domainSelect.selectByVisibleText("@bk.ru");
        WebElement loginForm = driver.findElement(By.id("auth"));
        loginForm.submit();
        Thread.sleep(3000);
        String loginURL = driver.getCurrentUrl();
        Assert.assertEquals(loginURL, "https://e.mail.ru/inbox/?back=1&afterReload=1");
    }

    @Test(dependsOnMethods = {"mailLoginTest"})
    public void mailSendTest() throws InterruptedException {
        WebElement writeLetterButton = driver.findElement(By.cssSelector("span.compose-button__wrapper"));
        writeLetterButton.click();
        new WebDriverWait(driver, 10, 500).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.focus-zone_fluid")));
        WebElement adresseeField = driver.findElement(By.xpath("//div[@class='contactsContainer--3RMuQ']//input"));
        adresseeField.sendKeys(adressee);
        WebElement subjectField = driver.findElement(By.xpath("//div[@class='subject__container--HWnat']//input"));
        subjectField.sendKeys(subject);
        WebElement letterBody = driver.findElement(By.cssSelector("div[role=textbox]"));
        letterBody.sendKeys(body);
        WebElement saveDraftButton = driver.findElement(By.cssSelector("span.button2_base:nth-child(2)"));
        saveDraftButton.click();
        driver.findElement(By.xpath("//div[@class=\"focus-zone focus-zone_fluid\"]//button[@title=\"Закрыть\"]")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class=\"focus-zone focus-zone_fluid\"]"))));
        driver.findElement(By.cssSelector("a[href=\"/drafts/\"]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.llc_first")));
        driver.findElement(By.cssSelector("a.llc_first")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]")).getText(), adressee);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='subject__container--HWnat']//input")).getAttribute("value"), subject);
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@id, \"BODY\")]/div/div/div")).getText(), body);
        driver.findElement(By.cssSelector("span[title=\"Отправить\"]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"layer-sent-page\"]//span[@class=\"button2__ico\"]")));
        driver.findElement(By.xpath("//div[@class=\"layer-sent-page\"]//span[@class=\"button2__ico\"]")).click();
        new WebDriverWait(driver, 10, 500).until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("a[href=\"/drafts/\"]")),"title"));
        Assert.assertEquals(driver.findElement(By.cssSelector("a[href=\"/drafts/\"]")).getAttribute("title"), "Нет писем");
    }

    @Test(dependsOnMethods = {"mailSendTest"})
    public void mailContentTest() {
        driver.findElement(By.cssSelector("a[href=\"/sent/\"]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.llc_first")));
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains (@class, \"llc_first\")]//span[@class=\"ll-crpt\"]")).getText(), adressee);
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains (@class, \"llc_first\")]//span[@class=\"ll-sj__normal\"]")).getText(), subject);
        driver.findElement(By.cssSelector("a[title=\"выход\"]")).click();
    }

    @AfterClass
    public void exitBrowser() {
        driver.quit();
    }
}
