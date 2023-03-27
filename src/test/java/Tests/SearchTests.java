package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class SearchTests extends BaseTest {

    @Test
    public void searchEngineResult() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnCity();
        SearchResultPage searchResultPage = homePage.SearchOnPage("cocina");
        Assert.assertTrue(searchResultPage.resultsDisplayed());
    }
}
