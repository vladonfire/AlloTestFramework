package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryPaymentPage extends BasePage {

    public DeliveryPaymentPage(WebDriver driver) {
        super(driver);
    }

    private final String PAGE_TITLE = "//h2[@class='sp-page-title sp-h2 page-header']";
    private final String HOW_TO_ORDER_SECTION = "//h3[contains(text(), 'Як оформити замовлення?')]";

    public WebElement pageTitle() {
        return visibilityOfElementByXpath(PAGE_TITLE);
    }

    public WebElement howToOrderElement() {
        return visibilityOfElementByXpath(HOW_TO_ORDER_SECTION);
    }

    public String getNamePageTitle() {
        return pageTitle().getText();
    }

    public String getNameHowToOrderElement() {
        return howToOrderElement().getText();
    }



}
