package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    private By inputEmail = By.xpath("//input[@name='email']");
    private By inputPassword = By.xpath("//input[@name='password']");
    private By buttonLogin = By.xpath("//button[@class='accout-btn btn btn-primary text-bold btn-block']");
    private By errorMessage = By.xpath("//*[@class='Toastify__toast-container Toastify__toast-container--bottom-right custonNotif']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage loginOnPage(String email, String pass) throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        typeBox(email, inputEmail);
        Thread.sleep(1000);
        typeBox(pass, inputPassword);
        Thread.sleep(5000);
        webDriver.findElement(buttonLogin).click();
        return new HomePage(webDriver);
    }
    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
