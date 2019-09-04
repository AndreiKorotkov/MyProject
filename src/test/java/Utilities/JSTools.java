package Utilities;

import SystemProperties.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * created by Andrei_Korotkov 9/4/2019
 */

public class JSTools  {

    private static WebDriver driver = DriverManager.getDriver("chrome");

    public static void highlightElement (WebElement element) throws InterruptedException {
        JavascriptExecutor jsHighlilhter = (JavascriptExecutor)driver;
        jsHighlilhter.executeScript("arguments[0].setAttribute('style', 'background: yellow; ');", element);
        Thread.sleep(2000);
    }
}
