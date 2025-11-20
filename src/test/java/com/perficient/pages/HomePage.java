package com.perficient.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[contains(text(), 'AI-First')]")
    private WebElement mainHeading;

    @FindBy(xpath = "//a[contains(text(), 'Discover Our Capabilities')]")
    private WebElement discoverCapabilitiesLink;

    @FindBy(xpath = "//a[contains(text(), 'Contact Us')]")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[contains(text(), 'Careers')]")
    private WebElement careersLink;

    @FindBy(xpath = "//a[contains(text(), 'Apply Today')]")
    private WebElement applyTodayLink;

    @FindBy(xpath = "//a[contains(text(), 'Explore Our AI-First Vision')]")
    private WebElement exploreAIVisionLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public boolean isMainHeadingDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(mainHeading));
            return mainHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getMainHeadingText() {
        wait.until(ExpectedConditions.visibilityOf(mainHeading));
        return mainHeading.getText();
    }

    public void clickDiscoverCapabilities() {
        wait.until(ExpectedConditions.elementToBeClickable(discoverCapabilitiesLink));
        discoverCapabilitiesLink.click();
    }

    public void clickContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsLink));
        contactUsLink.click();
    }

    public void clickCareers() {
        wait.until(ExpectedConditions.elementToBeClickable(careersLink));
        careersLink.click();
    }

    public void clickApplyToday() {
        wait.until(ExpectedConditions.elementToBeClickable(applyTodayLink));
        applyTodayLink.click();
    }

    public void clickExploreAIVision() {
        wait.until(ExpectedConditions.elementToBeClickable(exploreAIVisionLink));
        exploreAIVisionLink.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

