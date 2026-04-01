package HomePage;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAlloIconDisplayed() {
        return driver.findElement(AlloLocators.ALLO_LOGO).isDisplayed();
    }

}
