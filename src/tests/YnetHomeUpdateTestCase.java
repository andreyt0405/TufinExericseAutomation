package tests;

import org.testng.annotations.Test;
import pageobjects.YnetHomeUpdatePageTest;


public class YnetHomeUpdateTestCase extends BaseTest{
    YnetHomeUpdatePageTest ynetHomeUpdatePageTest = new YnetHomeUpdatePageTest(driver);
    @Test(description = "init url and find update caption")
    public void verifyUpdatesIsDisplay()
    {
        driver.get(getCurrentURL());
        ynetHomeUpdatePageTest = new YnetHomeUpdatePageTest(driver);
        ynetHomeUpdatePageTest.verifyIsUpdatedCaption("Updates");
    }
    @Test(priority = 1,description = "Verify the list moving")
    public void isListMoving()
    {
        ynetHomeUpdatePageTest = new YnetHomeUpdatePageTest(driver);
        ynetHomeUpdatePageTest.verifyListIsScroll(10);
    }
    @Test(priority = 2,description = "Verify the list doesn't moving")
    public void isListFreeze()
    {
        ynetHomeUpdatePageTest = new YnetHomeUpdatePageTest(driver);
        ynetHomeUpdatePageTest.verifyListIsFreeze(20);
    }
    @Test(priority = 3,description = "tear down the chromedriver.exe")
    public void CloseChromeDrive()
    {
        tearDown();
    }
}
