package SystemProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * created by Andrei_Korotkov 9/3/2019
 */
public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            setDriver(browserName);
        }
        return driver;
    }

    private static void setDriver(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setCapability("Platform", "WIN10");
            options.setCapability("browserName", "chrome");
            URL url = null;
            try {
                url = new URL("http://192.168.56.1:4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver = new RemoteWebDriver(url, options);
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("Platform", "WIN10");
            firefoxOptions.setCapability("browserName", "firefox");
            firefoxOptions.addArguments("start-maximized");
            firefoxOptions.setCapability(FirefoxDriver.MARIONETTE, true);
            firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            URL url = null;
            try {
                url = new URL("http://192.168.56.1:4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver = new RemoteWebDriver(url, firefoxOptions);
        }
//        return driver;
    }


//    public static WebDriver getDriver(String browserName){
//        WebDriver driver = null;
//        if (browserName.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("start-maximized");
//            options.setCapability("Platform", "WIN10");
//            options.setCapability("browserName", "chrome");
//            URL url = null;
//            try {
//                url = new URL("http://192.168.56.1:4444/wd/hub");
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            driver = new RemoteWebDriver(url, options);
//        } else if (browserName.equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.setCapability("Platform", "WIN10");
//            firefoxOptions.setCapability("browserName", "firefox");
//            firefoxOptions.addArguments("start-maximized");
//            firefoxOptions.setCapability(FirefoxDriver.MARIONETTE, true);
//            firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//            URL url = null;
//            try {
//                url = new URL("http://192.168.56.1:4444/wd/hub");
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            driver = new RemoteWebDriver(url, firefoxOptions);
//        }
//        return driver;
//    }


}
