##  Web Test Automation Framework -TestNG

## Description
Web Test Automation framework using selenium-Java and TestNG Framework.
Please read the document for its features, capability and usage 

## Libraries Used:
    1.Selenium - Web Automation
    2.TestNG -   Testing Library
    3.Extent Reports - Reporting Library to generate beautiful html reports
    4.AssertJ - Fluent Assertion Library in Java
    5.WebDriverManager - Executables management
    6.Lombok - To reduce boilerplate codes
    7.Apache poi -To control the text execution run and test data in excel
    8.RestAssured – To send the data to ELK real time Kibana dashboard

### Note: All the mentioned libraries are open-source and does not include any license.


## Capabilities:
    1.This framework has the capability to run the tests in 
        a)	Local 
        b)	Remote dockized Selenium grid.
        c)	Remote dockized Solenoid.
    2.It can also be extended to run on clouds like browser stack or Sause Labs.
    3.Web Tests can be run on chrome, Firefox and edge browsers.
    4.Configuration can be changed from config. properties inside src/test/resources
    5.Utility methods available for Web Interactions
    6.Realtime live execution dashboard will be available

## Adding more pages:
    1.Pages should be added as per the convention followed. New page should be created inside the src/test/page folder.
    2.All the tests should extend BasePagejava
    3.In each page , the element locators should be either of type By Locators or can be string which uses dynamic xpath. All by locators should be private 
    4.Naming convention for locators should be preceed link,txtbx,drpdn,txt,btn etc for better reability.
    5.Action should written as public method with web page interaction done only through seleniumeInteractionsUtil.The naming convention should 
      should be meaniful preferably with action followed by acted element (For ex: enterUsername)

## Adding more tests:
    Prerequisites: Java 8+, Maven 3.6.3 Installed and path set
    1.Tests should be added as per the convention followed. New testng tests should be created inside the src/test/java folder.
    2.All the tests should extend BaseTest.java
    3.Each test created should define the author and category in the @TestInfo annotation as mandatory parameters. This will be helpful while creating the extent             reports.
    4.All the tests should have an Assertion. Have maximum of one to two assertions per test.
    5.Tests should interact only with the page layer. This can be used to wrap the business logic.The Page layers has been moved under test folder , this would help the user to add new pages.

## Including a Test 
    1. Update the @Test Method name in RunManager &  TestData sheet in src/test/resources/excel/
       TestInput.xlsx under TestName column 
    2. Update "Yes" Or "No" under the column Execute in both the sheet.
    3. Invocation count determines , how many runs the test should run
    
## Running Tests:
    Prerequisites: Java 8+, Maven 3.6.3 Installed and path set
    1.There are multiple ways to run the tests. During development phase you can use the testng.xml present in the root folder to run. Right click and choose run.
    2.Each of the testng xml file should contain the test classes to pick for the run.
    3.User can also choose the thread-count parameter to run the tests in parallel.
    4.User can also choose to run via maven commands which is highly recommended.
    5.Maven profiles are configured in the pom.xml. You can run these from IDE Terminal or any OS Terminal inside the project folder.
        mvn clean test -Pall - To run all the tests available in the testng.xml

### Note: User should not try to run the test from test class - Might end up in NPE. Because the listeners are configured only in testng.xml

## Report Interpretation:
    1.Dashboard view clearly indicates the start time, end time of the run, number of tests passed and failed. It also shows the time took for the individual tests       in form of timeline. Hover the mouse over the timeline to get the exact time details. 
    2.Tags tab in the Dashboard view clearly indicates the pass and fail according to the functionality.
    3.Click on each test tab to view the corresponding test log events.
    4.All the web tests will have a screenshot attached on failure
    5.After each test run, reports can be found under root directory and Extent Reports folder.
    6.Press "l" on the keyboard after opening the report to switch the theme to Standard.  

![Report](https://user-images.githubusercontent.com/105458040/211056913-e6b21fdb-9714-4bcd-8218-2e1c58d4ce7d.png)


## GitHub Integration:
    1.	This project has been integrated with GitHub Actions.
    2.	The GitHub actions yml file are present under workflow.
    3.	The User can created additional workflow files as per their needs

### Command to run the docker container
    1.	Make sure to have the selenium grid or solenoid grid up and running
    2.	Start selenoid container
        Start selenium standalone container or grid
        Start selenoid ui (only need to view live execution)
        With the help of the docker compose files (included in the project)

    5.	Also Start the docker images for ELK to view the live Dashboard reporting of execution

## Final Notes:
    1.	I have not written any unit tests because all the methods are relatively small and static
    2.	I have performed sonar lint analysis to check the code quality.
    3.	Base image used in the docker file is customized from maven:3.6.3-jdk-8 where the maven dependencies are downloaded and kept handy to avoid downloading maven dependencies during each run.
    4.	I have used amazon.com,OrangeHRM.com,Automationexercise.com website for sample testcases and page objects

### Questions:
For any further clarification - please reach out to Lakshminarasimhan254@gmail.com




