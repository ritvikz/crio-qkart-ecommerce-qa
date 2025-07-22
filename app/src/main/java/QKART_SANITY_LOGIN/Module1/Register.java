package QKART_SANITY_LOGIN.Module1;

import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Register {
    RemoteWebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/register";
    public String lastGeneratedUsername = "";

    public Register(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void navigateToRegisterPage() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }

    public Boolean registerUser(String Username, String Password, Boolean makeUsernameDynamic)
            throws InterruptedException {
        // Find the Username Text Box
        WebElement username_txt_box = this.driver.findElement(By.id("username"));

        // Generate a unique or static username
        String test_data_username;
        if (makeUsernameDynamic) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            test_data_username = Username + "_" + String.valueOf(timestamp.getTime());
        } else {
            test_data_username = Username;
        }

        // Type the generated username
        username_txt_box.clear();
        username_txt_box.sendKeys(test_data_username);

        // Find and enter password
        WebElement password_txt_box = this.driver.findElement(By.id("password"));
        password_txt_box.clear();
        password_txt_box.sendKeys(Password);

        // Find and enter confirm password
        WebElement confirm_password_txt_box = this.driver.findElement(By.id("confirmPassword"));
        confirm_password_txt_box.clear();
        confirm_password_txt_box.sendKeys(Password);

        // Click the Register Now button
        WebElement register_now_button = this.driver.findElement(By.className("button"));
        register_now_button.click();

        // Wait for the operation to complete
        Thread.sleep(3000);

        // Store the generated username for verification or login
        this.lastGeneratedUsername = test_data_username;

        // Registration is successful if we're redirected to login page
        return this.driver.getCurrentUrl().endsWith("/login");
    }

}
