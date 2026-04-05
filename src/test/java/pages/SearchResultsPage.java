package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_GOODS = "//a[@title= 'Фен PHILIPS BHD321/50 серії 3000']";
    private final String FIRST_GOODS_AIRPODS = "(//a[@class='product-card__title'])[1]";

    public WebElement firstGoods() {
        return visibilityOfElementByXpath(FIRST_GOODS);
    }

    public WebElement firstGoodsAirPods() {
        return visibilityOfElementByXpath(FIRST_GOODS_AIRPODS);
    }

    public String getNameFirstAirPods() {
        return firstGoodsAirPods().getText();
    }

    public void clickFirstAirPods() {
        firstGoodsAirPods().click();
    }
}
