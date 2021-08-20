package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void filltext(WebElement el,String text)
    {
        el.clear();
        el.sendKeys(text);
    }
    public void click(WebElement el)
    {
        el.click();
    }
    public String getText(WebElement el)
    {
        return el.getText();
    }
    public void selectByVisibleText(Select select , String text)
    {
        select.selectByVisibleText(text);
    }
    public void assertEqual(String except ,String res,String passMsg,String failMsg)
    {
        try {
            Assertions.assertEquals(except,res);
            System.out.println(passMsg);
        } catch (AssertionError e) {
            System.out.println(failMsg);
            throw e;
        }
    }
    public void assertEqual(boolean except ,boolean res,String passMsg,String failMsg)
    {
        try {
            Assertions.assertEquals(except,res);
            System.out.println(passMsg);
        } catch (AssertionError e) {
            System.out.println(failMsg);
            throw e;
        }
    }
    public void assertNotEqual(boolean except ,boolean res,String passMsg,String failMsg)
    {
        try {
            Assertions.assertNotEquals(except,res);
            System.out.println(passMsg);
        } catch (AssertionError e) {
            System.out.println(failMsg);
            throw e;
        }
    }

    public void assertTrue(boolean except, String passMsg, String failMsg)
    {
        try {
            Assertions.assertTrue(except);
            System.out.println(passMsg);
        } catch (AssertionError e) {
            System.out.println(failMsg);
            throw e;
        }
    }
    public void sleep(long millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
