package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class FlowTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnCity();
        SearchResultPage searchResultPage = homePage.SearchOnPage("cocina");
        DetailProductPage detailProductPage = searchResultPage.clickOnProduct();
        detailProductPage.increaseProducts();
        detailProductPage.addProducts();
        CompletePurchasePage completePurchasePage = detailProductPage.continuePurchase();
        completePurchasePage.completButton();
        completePurchasePage.logIn("lord.rocinante@gmail.com", "mzDm9ZbDNZ2Rcbx");
        DeliveryDataPage deliveryDataPage = completePurchasePage.completPurchase();
        deliveryDataPage.personalDatesForm("Cédula de Identidad", "1358475", "Rocinante");
        deliveryDataPage.deliveryOption();
        PaymentPage paymentPage = deliveryDataPage.deliveryDatesForm("Oficina", "Av Juan Pablo II", "Referencia de prueba" );
        OrderDataPage orderDataPage = paymentPage.paymentAtDelivery();
        Assert.assertTrue(orderDataPage.resultsDisplayed());
    }
}
