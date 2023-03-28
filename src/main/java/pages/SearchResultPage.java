package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchResultPage extends BasePage{

    private By selectProduct = By.xpath("//div[@class='profile-widget'][1]");
    private By results = By.xpath("//div[@class='list-content row']");
    private By enterAmount = By.xpath("(//input[@id='searchResult'])[1]");
    private By enterButton = By.xpath("//button[@name='add__16416']//span[1]");
    private By errorMessage = By.xpath("//div[@class='Toastify__toast Toastify__toast--warning']");


    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DetailProductPage clickOnProduct() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.findElement(selectProduct).click();
        return new DetailProductPage(webDriver);
    }

    public DetailProductPage addProduct(String amount) throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        typeBox(amount, enterAmount);
        webDriver.findElement(enterButton).click();
        return new DetailProductPage(webDriver);
    }

    public boolean resultsDisplayed() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement element = webDriver.findElement(results);
        return element.isDisplayed();
    }
    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 5);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
