package com.dummyproject.test.hooks;

import main.com.dummyproject.framework.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Cucumber Hooks for setup and teardown with screenshot on failure.
 */
public class Hooks {
    @Before
    public void setUp() {
        DriverManager.getDriver();
        System.out.println("Browser started for new scenario");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
                System.out.println("Screenshot captured for failed scenario: " + scenario.getName());
            } catch (Exception e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
            }
        }
        DriverManager.quitDriver();
        System.out.println("Browser closed after scenario: " + scenario.getName());
    }
}
