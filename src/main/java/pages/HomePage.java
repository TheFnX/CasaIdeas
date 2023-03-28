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

    public HomePage clickOnCity() {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.findElement(cityButton).click();
        return new HomePage(webDriver);

    }
    public LoginPage clickOnLoginButton() {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.findElement(openLoginButton).click();
        return new LoginPage(webDriver);
    }

    public ProfilePage clickOnProfileButton() {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.findElement(openProfileButton).click();
        return new ProfilePage(webDriver);
    }

    public SearchResultPage SearchOnPage(String productName) {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        typeAndEnter(productName, inputSearcher);
        return new SearchResultPage(webDriver);
    }

    public boolean isNameDisplayed(){
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.findElement(openLoginButton).click();
        return webDriver.findElement(nameUserElement).isDisplayed();
    }
}
