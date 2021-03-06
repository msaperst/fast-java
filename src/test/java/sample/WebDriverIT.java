package sample;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebDriverIT {

    WebDriver driver;
    WebDriverWait wait;
    AppiumDriverLocalService service;

    By username = By.id("usernameOrEmail");
    By password = By.id("password");
    By meLink = By.cssSelector("a[data-tip-target='me']");

    @BeforeMethod
    public void setup(Method method) {
        // if an appium test case, setup our appium server
        if (method.getName().startsWith("appium")) {
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
            service.start();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            if (method.getName().startsWith("appiumBrowser")) {
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                WebDriverManager.chromedriver().forceCache().version("74").setup();
                capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,
                        WebDriverManager.chromedriver().getBinaryPath());
            } else {
                capabilities.setCapability("appPackage", "com.flipkart.android");
                capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
                capabilities.setCapability(MobileCapabilityType.APP, "src/test/resources/flipkart.apk");
                capabilities.setCapability("autoGrantPermissions", "true");
            }
            driver = new AndroidDriver<>(service, capabilities);
        } else { // else, it's a selenium test case, so setup our chrome driver
            WebDriverManager.chromedriver().forceCache().setup();
            driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void seleniumSampleTest() {
        By continueButton = By.cssSelector("button[type='submit']");
        By usernameDisplay = By.className("profile-gravatar__user-display-name");

        driver.get("https://wordpress.com/");
        driver.findElement(By.linkText("Log In")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(Property.getProperty("username"));
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).sendKeys(Property.getProperty("password"));
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(meLink));
        driver.findElement(meLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameDisplay));
        assertEquals(driver.findElement(usernameDisplay).getText(), Property.getProperty("username"));
    }


    @Test
    public void appiumBrowserSampleTest() {
        By signInLink = By.cssSelector("a.x-menu-link[title='Log In']");

        driver.get("https://wordpress.com/");
        driver.findElement(By.cssSelector("span.x-icon--menu")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInLink));
        driver.findElement(signInLink).click();
        driver.findElement(username).sendKeys(Property.getProperty("username"), Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).sendKeys(Property.getProperty("password"), Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(meLink));
        driver.findElement(meLink).click();
        assertEquals(driver.findElement(By.id("display_name")).getAttribute("value"), Property.getProperty("username"));
    }

    @Test
    public void appiumNativeSampleTest() {
        By userId = By.id("mobileNo");
        By password = By.id("et_password");
        By loginButton = By.id("btn_mlogin");
        By existingUserLogin = By.id("btn_mlogin");
        By errorMessage = By.id("pageLevelError");

        wait.until(ExpectedConditions.visibilityOfElementLocated(existingUserLogin));
        driver.findElement(existingUserLogin).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        WebElement userIdElement = driver.findElement(userId);
        userIdElement.clear();
        userIdElement.sendKeys("someone@testvagrant.com");
        driver.findElement(password).sendKeys("testvagrant123");
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        assertTrue(driver.findElement(errorMessage).getText().equalsIgnoreCase("Account does not exist"));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        driver.quit();
        if (service != null) {
            service.stop();
        }
    }
}
