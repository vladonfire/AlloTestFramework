package pages;

import basesClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String ALLO_LOGO = "//a[@class='v-logo']";
    private final String SEARCH_FIELD = "//input[@class= 'search-form__input']";
    private final String SEARCH_BUTTON = "//button[@class='search-form__submit-button']";
    private final String BUYERS_BUTTON = "//div[@class= 'mh-button__wrap']";
    private final String DROP_DOWN_MENU = "//div[@class='mh-button__dropdown']";
    private final String DELIVERY_AND_PAYMENT_BTN = "//a[contains(text(), 'Доставка і оплата')]";

    public WebElement alloLogo(){
        return visibilityOfElementByXpath(ALLO_LOGO);
    }

    public WebElement searchField() {
        return visibilityOfElementByXpath(SEARCH_FIELD);
    }

    public WebElement searchButton() {
        return visibilityOfElementByXpath(SEARCH_BUTTON);
    }

    public WebElement buyersButton() {
        return visibilityOfElementByXpath(BUYERS_BUTTON);
    }

    public WebElement dropDownMenu() {
        return visibilityOfElementByXpath(DROP_DOWN_MENU);
    }

    public WebElement deliveryAndPaymentBtn() {
        return visibilityOfElementByXpath(DELIVERY_AND_PAYMENT_BTN);
    }

    public void enterValueInSearchField(String value) {
        searchField().sendKeys(value);
    }

    public void clickSearchButton() {
        searchButton().click();
    }

    public void clickBuyersButton() {
        buyersButton().click();
    }

    public void clickDeliveryAndPaymentBtn() {
        deliveryAndPaymentBtn().click();
    }
}
