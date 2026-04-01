package HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestInit {
    public WebDriver driver;

    public void StartDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        driver.quit();
    }

    public void openUrl(String url){
        driver.get(url);
    }

}
