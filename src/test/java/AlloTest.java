import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlloTest {

    @Test
    public void testLogoIsDisplayed() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        WebElement alloLogo = driver.findElement(By.xpath("//a[@class='v-logo']"));

        Assert.assertTrue(alloLogo.isDisplayed(), "Логотип Алло не відображається на сторінці");
    }
}
