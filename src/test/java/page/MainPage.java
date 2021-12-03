package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.TestDataReader;

public class MainPage extends AbstractPage {

    private final String BASE_URL = TestDataReader.getTestData("base_url");
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(css = "div.devsite-searchbox input")
    WebElement searchField;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SearchResultPage search(String search) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.querySelector('div.devsite-searchbox input').focus();");
        searchField.sendKeys(search, Keys.ENTER);
        logger.info("open search page");
        return new SearchResultPage(driver);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("open main page");
        return this;
    }
}
