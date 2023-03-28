package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class SearchTests extends BaseTest {

    @Test
    public void searchEngineResult() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnCity();
        SearchResultPage searchResultPage = homePage.SearchOnPage("cocina");
        Assert.assertTrue(searchResultPage.resultsDisplayed());
    }

    @Test
    public void enterOtherAmount() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnCity();
        SearchResultPage searchResultPage = homePage.SearchOnPage("cocina");
        searchResultPage.addProduct("100");
        Assert.assertTrue(searchResultPage.isErrorMessageVisible());
    }
}
