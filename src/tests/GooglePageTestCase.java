package tests;

import org.testng.annotations.Test;
import pageobjects.GooglePageTests;

public class GooglePageTestCase extends BaseTest {
    GooglePageTests googlePage = new GooglePageTests(driver);

    @Test(description = "setup chromedriver.exe ")
    public void setupChromeDrive()
    {
        //i have decided to call setup method in this way instead use annotation @BeforeClass
        //because I want to show the automation in one flow
        setup();
    }

    @Test(priority = 1,description = "open google and search for ynetnews")
    public void searchInGoogleTest()
    {
        //testing flow starts here
        driver.get("https://www.google.com/");
        googlePage = new GooglePageTests(driver);
        googlePage.searchStringInGoogle("www.ynetnews.com");
    }
    @Test(priority = 2,description = "find ynetnews link")
    public void VerifyGoogleResult()
    {
        googlePage = new GooglePageTests(driver);
        googlePage.findYnetnewURL("ynetnews");
    }
}
