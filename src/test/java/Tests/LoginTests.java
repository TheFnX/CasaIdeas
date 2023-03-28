package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnCity();
        LoginPage loginPage = homePage.clickOnLoginButton();
        loginPage.loginOnPage("lord.rocinante@gmail.com", "mzDm9ZbDNZ2Rcbx");
        ProfilePage profilePage = homePage.clickOnProfileButton();
        Assert.assertEquals(profilePage.getUserNameText(), "MI CUENTA");
    }
    @Test
    public void testInvalidCredentials() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnCity();
        LoginPage loginPage = homePage.clickOnLoginButton();
        loginPage.loginOnPage("prueba@prueba.com", "123456789");
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }
}
