# QA Automation Framework

Automated UI and API testing framework built with Java 26 and Maven using the Page Object Model (POM) design pattern.

## Tech Stack

* **Language:** Java 26
* **Build Tool:** Maven
* **UI Testing:** Selenide 7.9.3
* **API Testing:** RestAssured 5.5.6
* **Test Runner & Assertions:** JUnit 5 (5.11.4)

## Project Structure

```text
src
├── main/java
│   ├── org.example/   # Models and business logic (User, UserManager)
│   └── pages/         # Page Object classes (WebSocketPage)
└── test/java
    ├── api/           # REST API test suites (UserApiTest, UserTest)
    └── ui/            # End-to-End UI test suites (LoginTests, CheckoutTests, WebTests)

```

Covered Scenarios

- UI Tests: User authentication (LoginTests), checkout flow (CheckoutTests), WebSocket and web element interactions
  (WebTests).

- API Tests: REST API endpoint validation, HTTP status codes, and response payload verification (UserApiTest, UserTest).

How to Run Tests

1. Clone the repository:

```terminaloutput
   git clone [https://github.com/ruslayni/qa-automation-framework.git](https://github.com/ruslayni/qa-automation-framework.git)
```

2. Navigate to the project directory:

```terminaloutput
cd qa-automation-framework
```

3. Run all tests via Maven:

```terminaloutput
mvn clean test
```

4. Run specific test suites:

```terminaloutput
mvn test -Dtest="api.*"   # Run only API tests
mvn test -Dtest="ui.*"    # Run only UI tests
```

