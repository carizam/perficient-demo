@smoke @regression
Feature: Perficient Home Page
  As a user
  I want to navigate the Perficient home page
  So that I can learn about the company's services and capabilities

  Background:
    Given the user navigates to the Perficient home page

  @smoke
  Scenario: Verify that the home page loads correctly
    When the page loads completely
    Then the user should see the main heading "AI-First"
    And the page title should contain "Perficient"
    And the page should be loaded correctly

  @regression
  Scenario: Verify the main heading of the page
    When the page loads completely
    Then the user should see the main heading "AI-First. AI-Fast."

  @regression
  Scenario: Navigate to Contact Us link
    When the user clicks on the link "Contact Us"
    Then the URL should contain "contact"

  @regression
  Scenario: Navigate to Careers link
    When the user clicks on the link "Careers"
    Then the URL should contain "careers"
