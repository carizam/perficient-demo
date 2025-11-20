# Perficient Demo - BDD Automation Tests

This project contains BDD (Behavior-Driven Development) automated tests for the Perficient website using Java, Maven, Cucumber, and TestNG.

## Technologies Used

- **Java 11**
- **Maven** - Dependency management and project build tool
- **Cucumber** - BDD framework for writing tests in natural language
- **TestNG** - Testing framework
- **Selenium WebDriver** - Browser automation
- **WebDriverManager** - Automatic browser driver management

## Project Structure

```
perficient-demo/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── perficient/
│       │           ├── hooks/          # Cucumber Hooks (Before/After)
│       │           ├── pages/          # Page Object Model
│       │           ├── runners/        # Cucumber Test Runner
│       │           ├── stepdefinitions/# Step Definitions
│       │           └── utils/          # Utilities (DriverManager, ConfigReader)
│       └── resources/
│           ├── features/               # Cucumber .feature files
│           ├── application.properties  # Application configuration
│           └── cucumber.properties    # Cucumber configuration
├── pom.xml                            # Maven configuration
├── testng.xml                         # TestNG configuration
└── README.md
```

## Prerequisites

- Java JDK 11 or higher
- Maven 3.6 or higher
- Chrome, Firefox, or Edge browser installed

## Setup

1. Clone or download the project
2. Ensure Java and Maven are installed
3. Configure properties in `src/test/resources/application.properties`:
   - `base.url`: Base URL of the website
   - `browser`: Browser to use (chrome, firefox, edge)
   - `headless`: Run in headless mode (true/false)
   - `implicit.wait`: Implicit wait time in seconds

## Running Tests

### Run all tests
```bash
mvn clean test
```

### Run tests with a specific tag
Edit `testng.xml` or modify the tag in `@CucumberOptions` in `TestRunner.java`:
```java
tags = "@smoke"  // Only tests with @smoke tag
```

### Run a specific feature
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

## Available Tags

- `@smoke` - Critical smoke tests
- `@regression` - Complete regression tests

## Reports

After execution, reports are generated in:
- **HTML**: `target/cucumber-reports/html/index.html`
- **JSON**: `target/cucumber-reports/Cucumber.json`
- **XML**: `target/cucumber-reports/Cucumber.xml`

## Writing New Tests

1. Create a `.feature` file in `src/test/resources/features/`
2. Write scenarios in Gherkin language
3. Implement step definitions in `src/test/java/com/perficient/stepdefinitions/`
4. Create or update Page Objects in `src/test/java/com/perficient/pages/` if necessary

## Feature Example

```gherkin
@smoke
Feature: Home Page
  Scenario: Verify page load
    Given the user navigates to the Perficient home page
    When the page loads completely
    Then the user should see the main heading "AI-First"
```

## Notes

- The project uses WebDriverManager to automatically manage browser drivers
- Screenshots are automatically taken when a scenario fails
- The project is configured to run tests in parallel (configurable in testng.xml)

## Author

Project created for BDD automation demonstration with Cucumber and TestNG.
