package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectEcommercePage extends BasePage{

    private By selectPage = By.xpath("//a[@href='https://www.casaideas.com.bo/']");

    public SelectEcommercePage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchOnEcommercePage selectPageAs(){
        webDriver.findElement(selectPage).click();
        return new SearchOnEcommercePage(webDriver);
    }
}
