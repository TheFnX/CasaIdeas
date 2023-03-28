package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class OrderDataPage extends BasePage{

    public OrderDataPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By results = By.xpath("//div[@class='list-content row']");
    public boolean resultsDisplayed() {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement element = webDriver.findElement(results);
        return element.isDisplayed();
    }

}
