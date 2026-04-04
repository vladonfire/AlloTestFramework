package tests;

import basesClass.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeliveryPaymentPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;

import static java.lang.Thread.sleep;

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
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(urlAllo);

        Assert.assertTrue(homePage.searchField().isDisplayed());

        homePage.searchField().sendKeys("Фен");

        homePage.searchButton().click();

        Assert.assertTrue(searchResultPage.firstGoods().getText().contains("Фен"));

    }

    @Test
    public void testAirPodsSearchAndDetails() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        ProductPage productPage = new ProductPage(driver);

        openUrl(urlAllo);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

        homePage.searchField().sendKeys("AirPods3");
        homePage.searchButton().click();

        String nameFirstGoodsAirPods = searchResultPage.getNameFirstAirPods();
        Assert.assertTrue(nameFirstGoodsAirPods.contains("AirPods 3"));
        searchResultPage.clickFirstAirPods();

        String actualNameAirPods = productPage.getNameProductHeaderTitle();
        Assert.assertEquals(actualNameAirPods,nameFirstGoodsAirPods);

    }

    @Test
    public void testDeliveryAndPaymentPage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        DeliveryPaymentPage deliveryPaymentPage = new DeliveryPaymentPage(driver);

        openUrl(urlAllo);

        Assert.assertTrue(homePage.buyersButton().isDisplayed());
        homePage.buyersButton().click();

        Assert.assertTrue(homePage.dropDownMenu().isDisplayed());

        Assert.assertTrue(homePage.deliveryAndPaymentBtn().isDisplayed());
        homePage.deliveryAndPaymentBtn().click();

        String actualTitle = deliveryPaymentPage.getNamePageTitle();
        Assert.assertEquals(actualTitle, "Доставка і оплата");

        WebElement howToOrder = deliveryPaymentPage.howToOrderElement();
        Assert.assertTrue(howToOrder.isDisplayed(), "Секція 'Як оформити замовлення?' невидима на сторінці");
        Assert.assertEquals(howToOrder.getText(), "Як оформити замовлення?");

    }
}
