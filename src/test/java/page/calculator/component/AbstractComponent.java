package page.calculator.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

    protected WebDriver driver;
    protected WebDriverWait wait = new WebDriverWait(driver,6);

    protected AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }
}
