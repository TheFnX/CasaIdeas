package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DeliveryDataPage extends BasePage{

    private By selectDocumentType = By.id("formtipodoc");
    private By inputIdDocument = By.id("forminvoicenumber");
    private By inputBusinessName = By.id("forminvoicename");
    private By nextButton = By.xpath("//button[normalize-space()='Siguiente >']");

    private By storeDeliveryButton = By.xpath("//button[@name='0']");
    private By regularDeliveryButton = By.xpath("//button[@name='1']");

    private By expressDeliveryButton = By.xpath("//button[@name='2']");
    private By addDirectionButton = By.xpath("//button[contains(@name,'ADD__directions')]");
    private By inputAddressAliases = By.xpath("//input[@id='formalias']");
    private By inputDirection = By.xpath("//input[@id='formaddress']");
    private By inputReferenceDirection = By.xpath("//input[@id='formreference']");
    private By nextAddDirectionButton = By.xpath("//button[normalize-space()='Siguiente']");

    private By cancelAddDirectionButton = By.xpath("//button[normalize-space()='Cancelar']");
    private By confirmDirectionButton = By.xpath("//button[normalize-space()='Confirmar']");
    private By acceptTermsCheckbox = By.id("checkterms_YES");





    public DeliveryDataPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DeliveryDataPage personalDatesForm(String document, String documentNumber, String businessName) throws InterruptedException {
        selectByVisibleText(document, selectDocumentType);
        Thread.sleep(1000);
        typeBox(documentNumber, inputIdDocument);
        Thread.sleep(1000);
        typeBox(businessName, inputBusinessName);
        Thread.sleep(1000);
        webDriver.findElement(nextButton).click();
        return new DeliveryDataPage(webDriver);
    }

    public DeliveryDataPage deliveryOption() throws InterruptedException {
        webDriver.findElement(regularDeliveryButton).click();
        return new DeliveryDataPage(webDriver);
    }

    public PaymentPage deliveryDatesForm(String alias, String direction, String reference) throws InterruptedException {
        webDriver.findElement(addDirectionButton).click();
        Thread.sleep(1000);
        typeBox(alias, inputAddressAliases);
        typeBox(direction, inputDirection);
        typeBox(reference, inputReferenceDirection);
        webDriver.findElement(nextAddDirectionButton).click();
        Thread.sleep(3000);
        webDriver.findElement(confirmDirectionButton).click();
        Thread.sleep(5000);
        webDriver.findElement(acceptTermsCheckbox).click();
        Thread.sleep(1000);
        webDriver.findElement(nextButton).click();
        Thread.sleep(5000);
        return new PaymentPage(webDriver);
    }



}
