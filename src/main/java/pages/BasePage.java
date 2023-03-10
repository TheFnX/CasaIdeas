package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
}
