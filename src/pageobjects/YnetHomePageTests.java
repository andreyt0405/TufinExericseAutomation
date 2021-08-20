package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class YnetHomePageTests extends BasePage {
    @FindBy(css = ".weathertemps")
    WebElement weatherDegree;
    @FindBy(css = "#weathercityselect")
    WebElement weatherCitySelect;
    @FindBy(css = ".mediaItems>span>a")
    List<WebElement> articles;

    public YnetHomePageTests(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    public void checkCurrentURL(String url)
    {
        assertTrue(driver.getCurrentUrl().contains(url),"Pass correct URL","Failed correct URL");
    }
    public void printCurrentWeather()
    {
        //print weather degree
        System.out.println(getText(weatherDegree) + " Right now");

    }
    public void changeWeatherZone(String city)
    {
        Select cityDropDown = new Select(weatherCitySelect);
        selectByVisibleText(cityDropDown,city);
    }
    public void selectArticle()
    {
        driver.manage().window().setSize(new Dimension(1920,1080));
        click(articles.get(0));
        try {
            driver.findElement(By.cssSelector(".newCommentBtn"));
        }
        catch (NoSuchElementException e)
        {
            driver.navigate().refresh();
            click(articles.get(0));
        }
    }

}
