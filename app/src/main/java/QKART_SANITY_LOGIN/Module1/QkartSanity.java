package QKART_SANITY_LOGIN.Module1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class QkartSanity {

    public static String lastGeneratedUserName;
    public static RemoteWebDriver driver;

    public static RemoteWebDriver createDriver() throws MalformedURLException {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void logStatus(String type, String message, String status) {
        System.out.println(String.format("%s |  %s  |  %s | %s",
                java.time.LocalDateTime.now(), type, message, status));
    }

    public static Boolean TestCase01(RemoteWebDriver driver) throws InterruptedException {
        logStatus("Start TestCase", "Test Case 1: Verify User Registration", "DONE");

        Register registration = new Register(driver);
        registration.navigateToRegisterPage();
        Boolean status = registration.registerUser("testUser", "abc@123", true);
        if (!status) {
            logStatus("TestCase 1", "User Registration Failed", "FAIL");
            return false;
        }
        logStatus("TestCase 1", "User Registration Successful", "PASS");

        lastGeneratedUserName = registration.lastGeneratedUsername;

        Login login = new Login(driver);
        login.navigateToLoginPage();
        status = login.PerformLogin(lastGeneratedUserName, "abc@123");
        logStatus("Login", "Login with registered user", status ? "PASS" : "FAIL");
        if (!status) return false;

        Home home = new Home(driver);
        status = home.PerformLogout();
        logStatus("Logout", "Perform Logout", status ? "PASS" : "FAIL");

        return status;
    }

    public static Boolean TestCase02(RemoteWebDriver driver) throws InterruptedException {
        logStatus("Start TestCase", "Test Case 2: Prevent Duplicate Registration", "DONE");

        Register registration = new Register(driver);
        registration.navigateToRegisterPage();
        Boolean status = registration.registerUser("testUser", "abc@123", true);
        logStatus("Register", "First Registration Attempt", status ? "PASS" : "FAIL");
        if (!status) return false;

        lastGeneratedUserName = registration.lastGeneratedUsername;

        registration.navigateToRegisterPage();
        status = registration.registerUser(lastGeneratedUserName, "abc@123", false);

        logStatus("Register", "Duplicate Registration Attempt", !status ? "PASS" : "FAIL");
        return !status;
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        int totalTests = 0;
        int passedTests = 0;

        driver = createDriver();

        try {
            totalTests++;
            if (TestCase01(driver)) passedTests++;

            totalTests++;
            if (TestCase02(driver)) passedTests++;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
            System.out.println(String.format("%d out of %d test cases Passed", passedTests, totalTests));
        }
    }
}
