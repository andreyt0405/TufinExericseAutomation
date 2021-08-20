package pageobjects;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePageTests extends BasePage{
    @FindBy(name =  "q")
    WebElement googleSearchLine;
    @FindBy(name = "btnK")
    WebElement googleSearchButton;
    @FindBy(className = ".yuRUbf>a")
    List<WebElement> url;

    public GooglePageTests(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    public void searchStringInGoogle(String ynetURL)
    {
        click(googleSearchLine);
        filltext(googleSearchLine, ynetURL);
        click(googleSearchButton);
    }
    public void findYnetnewURL(String ynetString)
    {
        for(WebElement el : url)
        {
            if(getText(el).contains(ynetString)) {
                click(el);
                System.out.println(String.format("Pass URL contains ",ynetString));
            }
            else
            {
                Assertions.assertTrue(getText(el).contains(ynetString),"Failed");
            }
        }
    }
}
