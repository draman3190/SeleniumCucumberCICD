package main.com.dummyproject.framework.base;

import main.com.dummyproject.framework.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for all Page Objects in the framework.
 * Provides common WebDriver utilities, explicit waits, and helper methods
 * to reduce boilerplate code and improve test reliability.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor initializes the WebDriver and WebDriverWait.
     * Uses ThreadLocal driver from DriverManager for thread safety.
     */
    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Waits for an element to be visible on the page.
     *
     * @param locator the By locator of the element
     * @return the visible WebElement
     */
    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable.
     *
     * @param locator the By locator of the element
     * @return the clickable WebElement
     */
    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Clicks on an element after waiting for it to be clickable.
     *
     * @param locator the By locator of the element
     */
    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    /**
     * Clears any existing text and sends new keys to the element.
     * Ensures a clean input field before typing.
     *
     * @param locator the By locator of the input field
     * @param text    the text to enter
     */
    protected void sendKeys(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Gets the visible text of an element.
     *
     * @param locator the By locator of the element
     * @return the text content of the element
     */
    protected String getText(By locator) {
        return waitForVisible(locator).getText();
    }
}
