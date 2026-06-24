package main.com.dummyproject.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Manages WebDriver instances in a thread-safe manner using ThreadLocal.
 * Automatically handles ChromeDriver setup using WebDriverManager.
 *
 * This ensures each test thread gets its own isolated browser instance.
 */
public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Returns the WebDriver instance for the current thread.
     * Initializes a new ChromeDriver if one doesn't exist.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }

    /**
     * Closes the browser and cleans up the ThreadLocal reference.
     * Should be called after each test (usually in @After hook).
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
