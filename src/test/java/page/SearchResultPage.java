package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class SearchResultPage extends AbstractPage {

    private Boolean resaltNoCalc = true;
    @FindBy(css = "div.devsite-search-page-controls a")
    WebElement nextBtn;

    @FindBy(css = "a.gs-title")
    List<WebElement> resultSearchList;


    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CalculatorPage openCalculatorLink() {
        while (resaltNoCalc) {
            for (WebElement searchLink : resultSearchList) {
                if (Objects.equals(searchLink.getText(), "Google Cloud Pricing Calculator")) {
                    searchLink.click();
                    resaltNoCalc = false;
                    return new CalculatorPage(driver);
                }
                nextBtn.click();
            }
        }
        return new CalculatorPage(driver);
    }

    @Override
    protected SearchResultPage openPage() {
        return null;
    }

}
