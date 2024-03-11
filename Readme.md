# Test Automation Framework

## Description
This project is a comprehensive testing framework for API, Web UI, and Mobile platforms. It delivers interface reliability, enhanced user experience, and cross-platform functionality.

## Modules
This project is organized into several modules:

- `Automation_Framework` (Project root folder)
    - `API_Framework` (Module) -- Completed
    - `Web_UI_Selenium_Framework` (Module) -- Work in progress
    - `Mobile_Framework` (Module) -- Completed

## Instructions

### Running Tests

### Automation_Framework (Project root folder)

To run all tests in the `Automation_Framework`, navigate to the project root folder and use the following Maven command:

```bash
mvn clean install

```

###  API_Framework (Module)
To run tests in the API_Framework module, navigate to the API_Framework directory and use the following Maven command:
```
cd API_Framework
mvn clean test

```
### Web_UI_Selenium_Framework (Module)
To run tests in the Web_UI_Selenium_Framework module, navigate to the Web_UI_Selenium_Framework directory and use this Maven command:

```
cd Web_UI_Selenium_Framework
mvn clean test
```

### Mobile_Framework (Module)
Run the Appium server and the simulators for iOS and Android from their respective apps (iOS:-> Xcode, Android:->Android Studio) before running the test cases.
```
Appium
```

To run tests in the Mobile_Framework module, navigate to the Mobile_Framework directory and use this Maven command:

```
cd Mobile_Framework
mvn clean test

```
### To Genreate the Allure report

cd into the module after running the test cases through mvn clean install command from the project directory or from the module.

```
allure serve
```
