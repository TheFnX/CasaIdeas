package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    protected void selectByVisibleText(String option, By selectBy){
        Select toSelect = new Select(webDriver.findElement(selectBy));
        toSelect.selectByVisibleText(option);
    }
    protected void typeAndEnter(String text, By elementBy) {
        WebElement element = webDriver.findElement(elementBy);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
    protected void typeBox(String text, By elementBy) {
        WebElement element = webDriver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }
}
