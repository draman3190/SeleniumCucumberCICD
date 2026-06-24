package com.dummyproject.test.stepdefinitions;

import com.dummyproject.test.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        loginPage.openLoginPage();
    }

    @When("the user enters a valid username and password")
    public void enterValidCredentials() {
        // Ideally, this should be stored in AWS Secrets Manager or equivalent, but this is a demo.
        loginPage.enterCredentials("tomsmith", "SuperSecretPassword!");
    }

    @When("clicks the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard")
    public void verifyRedirectToDashboard() {
        if (loginPage.isLoginSuccessful()) {
            System.out.println("Login successful - User is on the dashboard page");
        } else {
            System.out.println("Login failed");
        }
    }
}
