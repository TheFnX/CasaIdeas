package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SearchResultPage extends BasePage{

    private By selectProduct = By.xpath("//div[@class='profile-widget'][1]");
    private By results = By.xpath("//div[@class='list-content row']");
    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DetailProductPage clickOnProduct(){
        webDriver.findElement(selectProduct).click();
        return new DetailProductPage(webDriver);
    }

    public boolean resultsDisplayed(){
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement element = webDriver.findElement(results);
        return element.isDisplayed();
    }
}
