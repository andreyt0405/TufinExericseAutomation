package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class YnetArticlePageTest extends BasePage{
    @FindBy(css = ".topPanel > button")
    WebElement newCommentBtn;
    @FindBy(css = ".bottomPanelRow>#addCommentSendButton")
    WebElement sendCommand;
    @FindBy(css = ".logo>a")
    WebElement homePageButton;

    public YnetArticlePageTest(WebDriver driver) {
        super(driver);
    }
    public void verifyLinkNewButton(){
            assertTrue(newCommentBtn.isDisplayed(),"Pass button exists","Failed no such button");
            newCommentBtn.sendKeys(Keys.ENTER);
            sendCommand.sendKeys(Keys.ENTER);
    }
    public void verifyAlertMessage(String alertMsg)
    {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        assertEqual(alertMsg,alertMessage,"Pass except alert","Failed no except alert");
        driver.switchTo().alert().accept();
    }
    public void backToHomePage()
    {
        click(homePageButton);
    }
}
