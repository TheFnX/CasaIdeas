package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    private By cityButton = By.xpath("//button[normalize-space()='LA PAZ']");
    private By openLoginButton = By.xpath("//span//img[@alt='ci']");
    private By openProfileButton = By.xpath("//a[contains(@href,'/customer/account')]//span");

    private By inputSearcher = By.xpath("//input[@id='search_input_web']");
    private By nameUserElement = By.xpath("//*[@class='text-bold'][normalize-space()='Hola! Rocinante']");
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage clickOnCity() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.findElement(cityButton).click();
        Thread.sleep(10000);
        return new HomePage(webDriver);

    }
    public LoginPage clickOnLoginButton() throws InterruptedException {
        Thread.sleep(10000);
        webDriver.findElement(openLoginButton).click();
        Thread.sleep(10000);
        return new LoginPage(webDriver);
    }

    public ProfilePage clickOnProfileButton() throws InterruptedException {
        Thread.sleep(10000);
        webDriver.findElement(openProfileButton).click();
        Thread.sleep(10000);
        return new ProfilePage(webDriver);
    }

    public SearchResultPage SearchOnPage(String productName) throws InterruptedException {
        typeAndEnter(productName, inputSearcher);
        Thread.sleep(1000);
        return new SearchResultPage(webDriver);
    }

    public boolean isNameDisplayed(){
        webDriver.findElement(openLoginButton).click();
        return webDriver.findElement(nameUserElement).isDisplayed();
    }
}
