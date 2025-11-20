package com.perficient.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.perficient.stepdefinitions", "com.perficient.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"
        },
        monochrome = true,
        tags = "@smoke or @regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

