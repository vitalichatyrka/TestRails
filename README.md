# 🚀 TestRail Automation Project

## 📝 **Project Overview**

This project is designed for **automated testing of TestRail** using both **API and UI tests**. 
The goal is to verify TestRail core functionalities, integrate API and UI automation, and build 
a fully functional framework for practical QA application.

---


## 💡 **What is TestRail?**

[TestRail](https://testprojectchatyrka.testrail.io/) is a test management system used to create test cases, suites, plans, execute runs, and generate detailed reports for QA processes.

---

## ⚙️ **Technologies Used**

| Technology | Purpose |
|------------|---------|
| **Java 17+** | Programming language |
| **Selenide** | UI automation |
| **RestAssured** | API automation |
| **TestNG** | Test framework |
| **Allure** | Reporting tool |
| **Lombok** | Simplifying POJO models |
| **Faker** | Test data generation |
| **Maven** | Dependency management |
| **Log4j2** | Dependency management |
| **GitHub Actions** | CI/CD for automated test execution |

---

✅ Project Test Scope
🔗 API Tests: Projects Management
✔️ GET /projects – Get all projects
✔️ POST /projects – Create a new project
✔️ PUT /projects/{id} – Update existing project
✔️ DELETE /projects/{id} – Delete a project

🖥️ UI Tests: Test Cases Management
✔️ Login Page
- Login with valid credentials
- Login with invalid credentials
- Error message display verification

✔️ Test Cases Page
- Create a new test case via UI
- Verify created test case details
- Edit an existing test case via UI
- Verify edited test case details
- Delete a test case via UI