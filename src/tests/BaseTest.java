package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;
    private static String currentURL;
//    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //i have decided to call setup method in this way instead use annotation @BeforeClass
    //because I want to show the automation in one flow
//    @AfterClass
    public static void tearDown()
    {
        currentURL = driver.getCurrentUrl();
        driver.quit();
    }
    public String getCurrentURL()
    {
        return currentURL;
    }
    public void setCurrentURL(String url)
    {
        currentURL = url;
    }
}
