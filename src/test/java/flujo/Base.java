package flujo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class Base {

    private WebDriver webDriver;

    public void setUp() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.casaideas.com.bo/");
        webDriver.manage().window().maximize();
        Thread.sleep(4000);
        selectCity();
        Thread.sleep(4000);
        closeAd();
        Thread.sleep(4000);
        searchOnPage();
        Thread.sleep(4000);
        selectProduct();
        Thread.sleep(8000);
        addedProduct();
        Thread.sleep(4000);
        completePurchase();
        Thread.sleep(4000);
        continuePurchase();
        Thread.sleep(4000);
        Login();
        Thread.sleep(4000);
        continuePurchase();
        Thread.sleep(4000);
        personalDatesForm();
        Thread.sleep(4000);

    }

    public void selectCity(){
        WebElement cityButton = webDriver.findElement(By.xpath("//button[normalize-space()='LA PAZ']"));
        cityButton.click();
    }

    public void closeAd(){
        WebElement adButton = webDriver.findElement(By.xpath("//button[normalize-space()='CERRAR']"));
        adButton.click();
    }

    public void searchOnPage(){
        WebElement inputSearcher = webDriver.findElement(By.xpath("//input[@id='search_input_web']"));
        inputSearcher.sendKeys("cocina");
        inputSearcher.sendKeys(Keys.ENTER);
    }

    public void selectProduct(){
        WebElement selectProduct = webDriver.findElement(By.xpath("//div[@class='profile-widget'][1]"));
        selectProduct.click();
    }
//
//    public void addShoppingCart(){
//        WebElement addProductButton = webDriver.findElement(By.xpath("//button[contains(text(),'Agregar a la Bolsa')]"));
//        addProductButton.click();
//    }
//
    public void addedProduct() throws InterruptedException{

        WebElement productsIncreaseButton = webDriver.findElement(By.xpath("//button[@class='qty-up']"));
        productsIncreaseButton.click();
        Thread.sleep(1000);

        WebElement addToCartButton = webDriver.findElement(By.xpath("//button[contains(text(),'AGREGAR AL CARRO')]"));
        addToCartButton.click();
        Thread.sleep(2000);
    }

    public void completePurchase() throws InterruptedException {
        WebElement openCartButton = webDriver.findElement(By.xpath("//button[@class='no-button mini-cart-icon']//img[@alt='Shop Cart']"));
        openCartButton.click();
        Thread.sleep(1000);

        WebElement completePurchaseButton = webDriver.findElement(By.cssSelector("div[class='showCart-active'] button[class='btn btn-sm btn-primary mr-2']"));
        completePurchaseButton.click();
    }

    public void continuePurchase() throws InterruptedException {
        WebElement continueCartButton = webDriver.findElement(By.xpath("//button[@class='btn btn-primary pagebuilder-column-1']"));
        continueCartButton.click();
        Thread.sleep(1000);
    }

    public void Login() throws InterruptedException {
        WebElement inputEmail = webDriver.findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys("lord.rocinante@gmail.com");
        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys("mzDm9ZbDNZ2Rcbx");
        WebElement continueCartButton = webDriver.findElement(By.xpath("//button[normalize-space()='Iniciar sesión']"));
        continueCartButton.click();
        Thread.sleep(1000);
    }

    public void personalDatesForm() throws InterruptedException {
        Select documentType = new Select(webDriver.findElement(By.id("formtipodoc")));
        documentType.selectByVisibleText("Cédula de Identidad");
        Thread.sleep(1000);

        WebElement inputIdDocument = webDriver.findElement(By.id("forminvoicenumber"));
        inputIdDocument.sendKeys("1358475");

        WebElement inputBusinessName = webDriver.findElement(By.id("forminvoicename"));
        inputBusinessName.sendKeys("Rocinante");

        WebElement nextButton = webDriver.findElement(By.xpath("//button[normalize-space()='Siguiente >']"));
        nextButton.click();
        Thread.sleep(3000);
    }

//    public void pickUpInStoreForm() throws InterruptedException {
//        Select selectBranch = new Select(webDriver.findElement(By.id("form_1_storeName")));
//        selectBranch.selectByVisibleText("Megacenter La Paz");
//        Thread.sleep(1000);
//
//        WebElement retirementDay = webDriver.findElement(By.xpath("//button[@value='10-03-2023']"));
//        retirementDay.click();
//
//        WebElement pickUpTime = webDriver.findElement(By.xpath("//button[@value='14:00 - 18:00']"));
//        pickUpTime.click();
//    }

    public void deliveryForm() throws InterruptedException {
        WebElement deliverButton = webDriver.findElement(By.xpath("//button[contains(@name,'1')]"));
        deliverButton.click();
        Thread.sleep(1000);

        WebElement addDirectionButton = webDriver.findElement(By.xpath("//span[normalize-space()='Agregar']"));
        addDirectionButton.click();
        Thread.sleep(2000);

        WebElement inputDirection = webDriver.findElement(By.id("formaddress"));
        inputDirection.sendKeys("Av Arce");

        Thread.sleep(1000);

        WebElement inputIdDocument = webDriver.findElement(By.id("forminvoicenumber"));
        inputIdDocument.sendKeys("1358475");

        WebElement inputBusinessName = webDriver.findElement(By.id("forminvoicename"));
        inputBusinessName.sendKeys("Rocinante");


    }

    public static void main(String arg[]) throws InterruptedException, AWTException {
        Base base = new Base();
        base.setUp();
    }
}
