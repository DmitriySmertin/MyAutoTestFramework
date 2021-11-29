package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//button[@aria-label='Open search']")
    WebElement searchBtn;
    @FindBy(css = "div.devsite-searchbox input")
    WebElement searchField;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SearchResultPage search(String search){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.querySelector('div.devsite-searchbox input').focus();");
        searchField.sendKeys(search, Keys.ENTER);
        return new SearchResultPage(driver);
    }
    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
