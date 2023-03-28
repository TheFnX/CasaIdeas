package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DetailProductPage extends BasePage{

    private By addToCartButton = By.xpath("//button[contains(text(),'AGREGAR AL CARRO')]");
    private By productsIncreaseButton = By.xpath("//button[@class='qty-up']");
    private By openCartButton = By.xpath("//button[@class='no-button mini-cart-icon']//img[@alt='Shop Cart']");
    private By completePurchaseButton = By.cssSelector("div[class='showCart-active'] button[class='btn btn-sm btn-primary mr-2']");

    public DetailProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DetailProductPage increaseProducts() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.findElement(productsIncreaseButton).click();
        return new DetailProductPage(webDriver);
    }
    public DetailProductPage addProducts() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.findElement(addToCartButton).click();
        return new DetailProductPage(webDriver);
    }
    public CompletePurchasePage continuePurchase() throws InterruptedException {
        webDriver.findElement(openCartButton).click();
        webDriver.findElement(completePurchaseButton).click();
        return new CompletePurchasePage(webDriver);
    }

}
