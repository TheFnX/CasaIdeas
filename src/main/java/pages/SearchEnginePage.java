package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchEnginePage extends BasePage {

    private By inputSearch = By.xpath("//input[@title='Buscar']");

    public SearchEnginePage(WebDriver webDriver) {
        super(webDriver);
    }

    public SelectEcommercePage searchAs(String wordSearch){
        typeAndEnter(wordSearch, inputSearch);
        return new SelectEcommercePage(webDriver);
    }
}
