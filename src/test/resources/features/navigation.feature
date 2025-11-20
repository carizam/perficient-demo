@regression
Feature: Navigation on Perficient website
  As a user
  I want to navigate through different sections of the Perficient website
  So that I can explore available services and opportunities

  Background:
    Given the user navigates to the Perficient home page

  Scenario: Explore the AI-First vision
    When the user clicks on the link "Explore Our AI-First Vision"
    Then the page should be loaded correctly

  Scenario: Discover the company capabilities
    When the user clicks on the link "Discover Our Capabilities"
    Then the page should be loaded correctly
