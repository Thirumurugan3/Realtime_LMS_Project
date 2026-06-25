# Realtime LMS Automation Framework

A Hybrid Selenium Automation Framework built using Java, Selenium WebDriver, Cucumber BDD, Maven, JUnit, Apache POI, Log4j2, and Allure Reports following industry-standard automation practices.

---

## 🚀 Framework Highlights

- Selenium WebDriver with Java
- Cucumber BDD Framework
- Page Object Model (POM)
- Data-Driven Testing using Excel
- ThreadLocal Driver Management
- Cross Browser Testing
- Allure Reporting
- Log4j2 Logging
- Jenkins CI/CD Integration
- Screenshot Capture on Failure
- Configuration Management
- Reusable Utility Methods
- Parallel Execution Support
- Environment Variable Support (.env)

---

## 🛠️ Tech Stack

| Tool | Purpose |
|--------|----------|
| Java | Programming Language |
| Selenium WebDriver | UI Automation |
| Cucumber | BDD Framework |
| JUnit | Test Execution |
| Maven | Build Management |
| Apache POI | Excel Data Handling |
| Log4j2 | Logging |
| Allure | Reporting |
| Jenkins | CI/CD |
| Git | Version Control |

---

## Project Structure

```text
Realtime_LMS_Project
│
├── src
│
├── main
│   ├── java
│   │
│   ├── configReaderfolder
│   │   └── readConfig.java
│   │
│   ├── constants
│   │   └── waitConstants.java
│   │
│   ├── driversManger
│   │   ├── driverFactory.java
│   │   └── driverManager.java
│   │
│   ├── utilities
│   │   ├── baseClass.java
│   │   ├── excelUtil.java
│   │   ├── loggerUtil.java
│   │   └── testdataManager.java
│   │
│   └── pageObjects
│       └── LoginPage.java
│
├── test
│   ├── java
│   │
│   ├── hooks
│   │   └── hooksClass.java
│   │
│   ├── stepDefenition
│   │   └── stepDefclass.java
│   │
│   └── runnerFile
│       └── runnerClass.java
│
├── resources
│   ├── config.properties
│   ├── log4j2.xml
│   ├── testdata.xlsx
│   └── sample.feature
│
├── allure-results
│
├── allure-report
│
├── Jenkinsfile
│
├── pom.xml
│
└── README.md
```

## 📊 Test Data Management

The framework follows a **pre-loading test data approach**.

### Excel Test Data

| Testcase_ID | Username | Password |
|------------|------------|------------|
| TC_001 | Thiru | Murugan@123 |
| TC_002 | Muthu | Thiru@123 |

### Load Data

```java
Map<String,String> data =
        excelUtil.getTestData(
                "src/test/resources/testdata.xlsx",
                "Sheet1",
                "TC_001");

testdataManager.setTestData(data);
```

### Access Data Anywhere

```java
String username =
        testdataManager.getData("Username");

String password =
        testdataManager.getData("Password");
```

---

## 🎯 Design Patterns Used

### Page Object Model (POM)

Separates locators from business logic.

### Factory Pattern

Used for browser creation.

### Singleton Pattern

Used in Driver Management.

### ThreadLocal Pattern

Supports parallel execution.

---

## 🌐 Supported Browsers

- Chrome
- Firefox
- Edge

---

## ⚙️ Configuration

### config.properties

```properties
browser=chrome
url=https://example.com
```

---

## 🔐 Environment Variables

### .env

```env
USERNAME=testuser
PASSWORD=testpassword
```

---

## 📝 Logging

Log4j2 is integrated throughout the framework.

Example:

```java
log.info("Browser launched successfully");

log.error("Unable to click element", e);
```

---

## 📸 Screenshot on Failure

Screenshots are automatically captured when a test fails.

```java
@After
public void tearDown(Scenario scenario) {

    if(scenario.isFailed()) {

        clearReport.takeScreenshotForAllure(
                "Failed Screenshot");
    }
}
```

---

## 📈 Allure Reporting

### Generate Report

```bash
allure generate allure-results --clean -o allure-report
```

### Open Report

```bash
allure open allure-report
```

---

## ▶️ Run Tests

### Execute All Tests

```bash
mvn clean test
```

### Execute with Browser

```bash
mvn clean test -Dbrowser=chrome
```

### Execute with Test Case ID

```bash
mvn clean test -Dtcid=TC_001
```

### Execute Browser + Test Data

```bash
mvn clean test -Dbrowser=chrome -Dtcid=TC_001
```

---

## 🔄 Jenkins Integration

Framework supports Jenkins parameterized execution.

### Parameters

- Browser
- Test Case ID

### Sample Command

```bash
mvn test -Dbrowser=${BROWSER} -Dtcid=${TCID}
```

---

## 🚀 Future Enhancements

- JSON Data Support
- REST Assured API Framework
- Docker Integration
- Selenium Grid
- GitHub Actions
- Playwright Integration
- Database Validation
- Cloud Execution (BrowserStack/SauceLabs)

---

## 👨‍💻 Author

### Thirumurugan

QA Automation Engineer

**Skills**

- Selenium WebDriver
- Java
- Cucumber BDD
- JUnit
- Maven
- Jenkins
- Allure Reports
- Log4j2
- SQL
- API Testing
- Playwright

---

## ⭐ If you found this framework useful, please give the repository a Star.
