import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void AlloTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        WebElement searchImput = driver.findElement(By.xpath("//input[@class= 'search-form__input']"));
        Assert.assertTrue(searchImput.isDisplayed(), "Поле пошуку видиме на сторінці!");
        searchImput.sendKeys("Фен");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchButton.click();
        sleep(3000);
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@class= 'product-card__title'])[1]"));
        String productText = firstProduct.getText();
        Assert.assertTrue(productText.contains("Фен"), "Перший товар не містить слово 'Фен'");


    }

}
