package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PaymentPage extends BasePage{

    private By paymentOnlineButton = By.xpath("//label[normalize-space()='Pago online']");
    private By paymentAtDeliveryButton = By.xpath("//label[normalize-space()='Pago al momento de Entrega']");
    private By finishOrderButton = By.xpath("//button[normalize-space()='Finalizar Pedido']");

    public PaymentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OrderDataPage paymentAtDelivery() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.findElement(paymentAtDeliveryButton).click();
        webDriver.findElement(finishOrderButton).click();
        return new OrderDataPage(webDriver);
    }
}
