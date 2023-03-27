package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CompletePurchasePage extends BasePage {

    private By continueCartButton = By.xpath("//button[@class='btn btn-primary pagebuilder-column-1']");
    private By inputEmail = By.xpath("//input[@name='email']");
    private By inputPassword = By.xpath("//input[@name='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Iniciar sesión']");
    public CompletePurchasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public CompletePurchasePage completButton() throws InterruptedException {
        webDriver.findElement(continueCartButton).click();
        Thread.sleep(2000);
        return new CompletePurchasePage(webDriver);
    }

    public CompletePurchasePage logIn(String email, String pass) throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        typeBox(email, inputEmail);
        Thread.sleep(1000);
        typeBox(pass, inputPassword);
        Thread.sleep(1000);
        webDriver.findElement(buttonLogin).click();
        Thread.sleep(3000);
        return new CompletePurchasePage(webDriver);
    }

    public DeliveryDataPage completPurchase() throws InterruptedException {
        webDriver.findElement(continueCartButton).click();
        Thread.sleep(2000);
        return new DeliveryDataPage(webDriver);
    }

}
