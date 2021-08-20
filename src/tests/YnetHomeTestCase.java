package tests;

import org.testng.annotations.Test;
import pageobjects.YnetHomePageTests;

public class YnetHomeTestCase extends BaseTest{
    YnetHomePageTests YnetHomePageTests = new YnetHomePageTests(driver);
    @Test(priority = 1,description = "test checking the current url")
    public void ynetNewsSiteTest()
    {
        // test flow go to ynetnews.com
        driver.get("https://www.ynetnews.com");
        YnetHomePageTests = new YnetHomePageTests(driver);
        YnetHomePageTests.checkCurrentURL("https://www.ynetnews.com");
    }
    @Test(priority = 2,description = "checking for current weather degree")
    public void printCurrentWeather()
    {
        //check for current weather
        YnetHomePageTests = new YnetHomePageTests(driver);
        YnetHomePageTests.printCurrentWeather();
    }
    @Test(priority = 3,description = "change the weather zone")
    public void ChangeWeatherZone()
    {
        YnetHomePageTests = new YnetHomePageTests(driver);
        YnetHomePageTests.changeWeatherZone("Eilat");
        YnetHomePageTests.printCurrentWeather();
    }
    @Test(priority = 4,description = "select article")
    public void selectArticle()
    {
        YnetHomePageTests = new YnetHomePageTests(driver);
        YnetHomePageTests.selectArticle();
        setCurrentURL(driver.getCurrentUrl());
    }
}
