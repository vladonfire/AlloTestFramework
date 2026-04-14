package tests;

import basesClass.TestInit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeliveryPaymentPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class AlloTest extends TestInit {

    public String urlAllo = "https://allo.ua/";

    @Test
    public void testLogoIsDisplayed()  {
        HomePage homePage = new HomePage(driver);

        openUrl(urlAllo);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());
    }

    @Test
    public void checkFirstProductTitleAfterSearch() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        openUrl(urlAllo);

        Assert.assertTrue(homePage.searchField().isDisplayed());

        homePage.enterValueInSearchField("Фен");
        homePage.clickSearchButton();

        Assert.assertTrue(searchResultsPage.firstGoods().getText().contains("Фен"));
    }

    @Test
    public void testAirPodsSearchAndDetails()  {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        String airPods = "AirPods 3";

        openUrl(urlAllo);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

        homePage.enterValueInSearchField(airPods);
        homePage.clickSearchButton();

        String nameFirstAirPods = searchResultsPage.getNameFirstAirPods();
        Assert.assertTrue(nameFirstAirPods.contains("AirPods Pro 3"));
        searchResultsPage.clickFirstAirPods();

        String nameOnProductPage = productPage.getNameProductHeaderTitle();
        Assert.assertEquals(nameFirstAirPods, nameOnProductPage, "назви не збігаються!");
    }

    @Test
    public void testDeliveryAndPaymentPage() {
        HomePage homePage = new HomePage(driver);
        DeliveryPaymentPage deliveryPaymentPage = new DeliveryPaymentPage(driver);

        openUrl(urlAllo);

        Assert.assertTrue(homePage.buyersButton().isDisplayed());
        homePage.clickBuyersButton();

        Assert.assertTrue(homePage.dropDownMenu().isDisplayed());

        Assert.assertTrue(homePage.deliveryAndPaymentBtn().isDisplayed());
        homePage.clickDeliveryAndPaymentBtn();

        String actualTitle = deliveryPaymentPage.getNamePageTitle();
        Assert.assertEquals(actualTitle, "Доставка і оплата");

        Assert.assertTrue(deliveryPaymentPage.howToOrderElement().isDisplayed(), "Секція 'Як оформити замовлення?' невидима на сторінці");
        Assert.assertEquals(deliveryPaymentPage.howToOrderElement().getText(), "Як оформити замовлення?");
    }
}
