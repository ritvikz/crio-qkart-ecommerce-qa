package QKART_SANITY_LOGIN.Module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Home {
    RemoteWebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app";

    public Home(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHome() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }

    public Boolean PerformLogout() throws InterruptedException {
        try {
            WebElement logout_button = driver.findElement(By.className("MuiButton-text"));
            logout_button.click();
            Thread.sleep(3000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
