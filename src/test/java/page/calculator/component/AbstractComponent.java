package page.calculator.component;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

    public WebDriver driver;
    public static WebDriverWait wait;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 6);
    }
}
