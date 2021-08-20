package tests;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import pageobjects.YnetArticlePageTest;

public class YnetArticleTestCase extends BaseTest{
    YnetArticlePageTest ynetArticlePageTest = new YnetArticlePageTest(driver);
    @Test(priority = 1,description = "open article page")
    public void ArticlePageTest(){
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get(getCurrentURL());
        ynetArticlePageTest = new YnetArticlePageTest(driver);
        ynetArticlePageTest.verifyLinkNewButton();
    }
    @Test(priority = 2,description = "verify alert message and go to home page")
    public void ArticlePageTestAlertMsg(){
        ynetArticlePageTest = new YnetArticlePageTest(driver);
        ynetArticlePageTest.verifyAlertMessage("You must enter a headline");
        ynetArticlePageTest.backToHomePage();
        setCurrentURL(driver.getCurrentUrl());
    }
}
