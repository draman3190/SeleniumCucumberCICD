package com.dummyproject.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Regression Test Runner for the full test suite.
 * Executes all feature files in the project.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {
                "com.dummyproject.test.stepdefinitions",
                "com.dummyproject.test.hooks"
        },
        tags = "@regression",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true,
        publish = false
)
public class RegressionTestRunner {
}
