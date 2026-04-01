package HomeTest;

import HomePage.TestInit;
import HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class AlloTest extends TestInit{


    @Test
    public void testLogoIsDisplayed() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        WebElement alloLogo = driver.findElement(By.xpath("//a[@class='v-logo']"));
        Assert.assertTrue(alloLogo.isDisplayed(), "Логотип Алло не відображається на сторінці");
    }

    @Test
    public void checkFirstProductTitleAfterSearch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        WebElement searchInput = driver.findElement(By.xpath("//input[@class= 'search-form__input']"));
        Assert.assertTrue(searchInput.isDisplayed(), "Поле пошуку видиме на сторінці!");
        searchInput.sendKeys("Фен");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchButton.click();
        sleep(3000);
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@class= 'product-card__title'])[1]"));
        String productText = firstProduct.getText();
        Assert.assertTrue(productText.contains("Фен"), "Перший товар не містить слово 'Фен'");
    }

    @Test
    public void testAirPodsSearchAndDetails() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        WebElement alloLogo = driver.findElement(By.xpath("//a[@class='v-logo']"));
        Assert.assertTrue(alloLogo.isDisplayed(), "Логотип Алло не відображається на сторінці");
        WebElement searchInput = driver.findElement(By.xpath("//input[@class= 'search-form__input']"));
        searchInput.sendKeys("AirPods 3");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchButton.click();
        sleep(3000);
        WebElement firstProductTitleElement = driver.findElement(By.xpath("(//a[@class= 'product-card__title'])[1]"));
        String firstProductTitleText = firstProductTitleElement.getText();
        Assert.assertTrue(firstProductTitleText.contains("AirPods") && firstProductTitleText.contains("3"),"Назва товару не містить 'AirPods' або '3'. Отримано: " + firstProductTitleText);
        String expectedName = firstProductTitleText;
        sleep(3000);
        firstProductTitleElement.click();
        WebElement productTitleOnPage = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));
        String actualName = productTitleOnPage.getText();
        Assert.assertEquals(actualName,expectedName,"ім'я товару на сторінці не збігається з назвою не іншій сторінці");
        sleep(3000);
        driver.quit();
    }

    @Test
    public void testDeliveryAndPaymentPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua");
        WebElement buyersButton = driver.findElement(By.xpath("//div[@class= 'mh-button__wrap']"));
        Assert.assertTrue(buyersButton.isDisplayed(), "кнопка 'покупцям' не відображається на сторінці");
        buyersButton.click();
        sleep(2000);
        WebElement dropDownMenu = driver.findElement(By.xpath("//div[@class='mh-button__dropdown']"));
        Assert.assertTrue(dropDownMenu.isDisplayed(), "меню не відображається на сторінці");
        sleep(2000);
        WebElement deliveryAndPayment = driver.findElement(By.xpath("//a[contains(text(), 'Доставка і оплата')]"));
        Assert.assertTrue(deliveryAndPayment.isDisplayed(), "елемент з текстом 'Доставка і оплата' невидима на сторінці");
        deliveryAndPayment.click();
        sleep(2000);
        String actualTitleText = driver.getTitle();
        Assert.assertTrue(actualTitleText.contains("Доставка і оплата"), "тайтл не містить подібний текст");
        WebElement headerText = driver.findElement(By.xpath("//h3[contains(text(), 'Як оформити замовлення?')]"));
        Assert.assertTrue(headerText.isDisplayed(), "Заголовок невидимий!");
        Assert.assertEquals(headerText.getText(), "Як оформити замовлення?", "Заголовок немає такого тексту!");
        sleep(2000);
        driver.quit();
    }

    @Test
    public void logoIsDisplayed() {
        TestInit TestInit = new TestInit();
        TestInit.StartDriver();
        TestInit.openUrl("https://allo.ua/");

        HomePage homePage = new HomePage(TestInit.driver);

        boolean isDisplayed = homePage.isAlloIconDisplayed();
        Assert.assertTrue(isDisplayed, "Іконка АЛЛО не відображається на сторінці!");

        TestInit.quitDriver();

    }
}
