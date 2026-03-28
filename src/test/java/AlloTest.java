import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class AlloTest {

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
        Assert.assertTrue(firstProductTitleText.contains("Навушники Apple AirPods Pro 3 "), "назва першого товару не містить 'AirPods 3'");
        String expectedName = firstProductTitleText;
        firstProductTitleElement.click();
        WebElement productTitleOnPage = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));
        String actualName = productTitleOnPage.getText();
        Assert.assertEquals(actualName,expectedName,"ім'я товару на сторінці не збігається з назвою не іншій сторінці");






    }

}
