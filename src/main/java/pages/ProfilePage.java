package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ProfilePage extends BasePage{

    private By formProfile = By.xpath("//*[@class='card items-left']");
    private By nameTxt = By.xpath("//span[contains(@class,'h1-responsive')]");

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isProfilePageDisplayed(){
        WebElement element = webDriver.findElement(formProfile);
        return element.isDisplayed();
    }
    public String getUserNameText(){
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return webDriver.findElement(nameTxt).getText();
    }
}
