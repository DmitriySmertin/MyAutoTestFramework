package page.calculator.component;

import org.openqa.selenium.WebDriver;

public class AbstractComponent {

    public WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }
}
