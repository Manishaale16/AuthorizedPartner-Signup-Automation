# Authorized Partner Signup Automation

## Project Overview

This project automates the complete signup process of the Authorized Partner Portal using Selenium WebDriver, Java, TestNG, Maven, and the Page Object Model (POM) design pattern.

Application Under Test:

https://authorized-partner.vercel.app/

The automation covers the complete registration workflow:

* Terms & Conditions Acceptance
* Account Setup
* Email OTP Verification
* Agency Details
* Professional Experience
* Verification & Preferences
* Final Registration Submission

The entire signup flow is fully automated without any manual intervention.

---

## Technology Stack

* Java 21
* Selenium WebDriver 4
* TestNG
* Maven
* Page Object Model (POM)
* WebDriverManager
* Jakarta Mail API (OTP Retrieval)
* Extent Reports

---

## Project Structure

```text
AuthorizedPartner-Signup-Automation
│
├── src
│   └── test
│       └── java
│           ├── Base
│           ├── Page_object_pattern
│           ├── Practice
│           └── Utilities
│
├── reports
│   └── ExtentReport.html
│
├── Screenshots1
│   └── CompleteSignupFlow.png
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## Prerequisites

Before running the project, ensure the following are installed:

* JDK 21
* Maven 3.9+
* Google Chrome Browser
* IntelliJ IDEA or VS Code

---

## Environment Setup

### Clone Repository

```bash
git clone <repository-url>
```

### Navigate to Project

```bash
cd AuthorizedPartner-Signup-Automation
```

### Install Dependencies

```bash
mvn clean install
```

---

## How to Run the Automation

### Run Using Maven

```bash
mvn test
```

### Run Using TestNG

Execute the following suite:

```text
testng.xml
```

---

## Test Data Used

The automation generates dynamic test data during execution.

Example:

### Email

```text
alemenka410+timestamp@gmail.com
```

### Phone Number

```text
98123XXXXX
```

### Password

```text
Manisha@123
```

---

## OTP Verification

OTP retrieval is automated using Gmail IMAP and Jakarta Mail API.

The framework:

* Reads the OTP email automatically
* Extracts the OTP using Regex
* Enters the OTP into the application
* Continues the registration flow automatically

No manual OTP entry is required.

---

## Assertions Covered

The automation validates:

* Terms Page Displayed
* Account Setup Page Displayed
* OTP Verification Page Displayed
* Account Successfully Created
* Agency Details Page Displayed
* Professional Experience Page Displayed
* Verification & Preferences Page Displayed
* Signup Completed Successfully

---

## Reports

Execution results are generated in:

```text
reports/ExtentReport.html
```

---
## Demo Video

Google Drive Video:
https://drive.google.com/file/d/1jkos1RuwQgxO6Jevff-URwl6VO8aL6SI/view?usp=drive_link

The video demonstrates:
- Complete signup automation execution
- Automated OTP retrieval from Gmail
- Agency Details form submission
- Professional Experience form submission
- Verification & Preferences form submission
- Successful account creation
- Extent Report generation

## Author

Manisha Ale

Bachelor of Computer Science and Information Technology (BCSIT)

QA Automation Assignment Submission
