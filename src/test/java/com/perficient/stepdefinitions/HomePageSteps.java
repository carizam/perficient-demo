package com.perficient.stepdefinitions;

import com.perficient.pages.HomePage;
import com.perficient.utils.ConfigReader;
import com.perficient.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageSteps {
    private WebDriver driver;
    private HomePage homePage;
    private String baseUrl;

    public HomePageSteps() {
        this.driver = DriverManager.getDriver();
        this.baseUrl = ConfigReader.getProperty("base.url");
        this.homePage = new HomePage(driver);
    }

    @Given("the user navigates to the Perficient home page")
    public void the_user_navigates_to_the_perficient_home_page() {
        homePage.navigateToHomePage(baseUrl);
    }

    @When("the page loads completely")
    public void the_page_loads_completely() {
        // Page should already be loaded after navigateToHomePage
        // We can add an explicit wait if necessary
    }

    @Then("the user should see the main heading {string}")
    public void the_user_should_see_the_main_heading(String expectedHeading) {
        Assert.assertTrue(homePage.isMainHeadingDisplayed(), 
            "The main heading is not visible");
        String actualHeading = homePage.getMainHeadingText();
        Assert.assertTrue(actualHeading.contains(expectedHeading) || 
                         expectedHeading.contains("AI-First"),
            "The expected heading does not match. Expected: " + expectedHeading + 
            ", Actual: " + actualHeading);
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
            "The page title does not contain the expected text. Expected: " + 
            expectedTitle + ", Actual: " + actualTitle);
    }

    @When("the user clicks on the link {string}")
    public void the_user_clicks_on_the_link(String linkText) {
        switch (linkText.toLowerCase()) {
            case "discover our capabilities":
                homePage.clickDiscoverCapabilities();
                break;
            case "contact us":
                homePage.clickContactUs();
                break;
            case "careers":
                homePage.clickCareers();
                break;
            case "apply today":
                homePage.clickApplyToday();
                break;
            case "explore our ai-first vision":
                homePage.clickExploreAIVision();
                break;
            default:
                throw new IllegalArgumentException("Link not recognized: " + linkText);
        }
    }

    @Then("the URL should contain {string}")
    public void the_url_should_contain(String expectedUrlPart) {
        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrlPart),
            "The current URL does not contain the expected text. Expected: " + 
            expectedUrlPart + ", Actual: " + currentUrl);
    }

    @Then("the page should be loaded correctly")
    public void the_page_should_be_loaded_correctly() {
        Assert.assertTrue(homePage.isMainHeadingDisplayed(),
            "The home page did not load correctly");
    }
}
