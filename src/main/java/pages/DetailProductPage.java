package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        webDriver.findElement(productsIncreaseButton).click();
        Thread.sleep(2000);
        return new DetailProductPage(webDriver);
    }
    public DetailProductPage addProducts() throws InterruptedException {
        webDriver.findElement(addToCartButton).click();
        Thread.sleep(2000);
        return new DetailProductPage(webDriver);
    }
    public CompletePurchasePage continuePurchase() throws InterruptedException {
        webDriver.findElement(openCartButton).click();
        Thread.sleep(1000);
        webDriver.findElement(completePurchaseButton).click();
        Thread.sleep(2000);
        return new CompletePurchasePage(webDriver);
    }

}
