package com.dummyproject.test.pages;

import main.com.dummyproject.framework.base.BasePage;
import org.openqa.selenium.By;

import java.util.Objects;

/**
 * Page Object for the Login page.
 */
public class LoginPage extends BasePage {

    // Locators
    private static final By USSERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");

    public void openLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void enterCredentials(String username, String password) {
        sendKeys(USSERNAME_FIELD, username);
        sendKeys(PASSWORD_FIELD, password);
    }

    public void clickLoginButton() {
        click(LOGIN_BUTTON);
    }

    public boolean isLoginSuccessful() {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("secure");
    }
}
