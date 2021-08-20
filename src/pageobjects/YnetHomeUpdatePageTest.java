package pageobjects;
import java.awt.*;
import java.util.List;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class YnetHomeUpdatePageTest extends BasePage{
    @FindBy(className = "rightTitleText")
    WebElement updateCaption;
    @FindBy(css = ".moreDetails>a")
    List<WebElement> updateArticleListLink;
    public YnetHomeUpdatePageTest(WebDriver driver) {
        super(driver);
    }
    public void verifyIsUpdatedCaption(String caption)
    {
        Assertions.assertEquals(updateCaption.getText(),caption,"Failed");
    }
    public void verifyListIsScroll(int indexInList)
    {
        //I set the timeout on 120s because the animation running around the circle 120sec
        // in this way i can ensure that element was visible and then gone and thus avoid hardcode
        // which will gives false positives in some situations
        WebElement elementInList = updateArticleListLink.get(indexInList);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until( ExpectedConditions.visibilityOf(elementInList));
        boolean elementVisible = elementInList.isDisplayed();
        wait.until( ExpectedConditions.invisibilityOf(elementInList));
        boolean elementInvisible = elementInList.isDisplayed();
        assertNotEqual(elementVisible,elementInvisible,"Pass the list is moving","Failed the list is freezing");
    }
    public void verifyListIsFreeze(int indexInList)
    {
        WebElement elementInList = updateArticleListLink.get(indexInList);
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until( ExpectedConditions.visibilityOf(elementInList));
        actions.moveToElement(elementInList).perform();
        boolean elementVisible = elementInList.isDisplayed();
        //10sec verify the article doesn't move after afterwards i compare the conditions
        // and if they are same, the article isn't moved.
        sleep(10000);
        boolean elementInvisible = elementInList.isDisplayed();
        assertEqual(elementVisible,elementInvisible,"Pass the list is freezing","Failed the list is moving");
    }
}
