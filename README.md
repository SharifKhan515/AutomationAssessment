# Automation Assessment
This is an automation framework build from scratch using selenium-java as part of an automation assesment.

## Language used: Java

## Technology Used
1. Maven
1. Selenium Webdriver
2. Webdriver Manager
3. JXL API
4. Log4j2
5. ExtentReport

## Steps to run the test
1. Go to the root folder of the project.
2. Run below maven command to run the test in chrome
```
mvn clean verify -DsuiteFile=src/test/resources/testsuites/testng.xml -Dbrowser=chrome
```
3. Run below command to run the test in firefox
```
mvn clean verify -DsuiteFile=src/test/resources/testsuites/testng.xml -Dbrowser=firefox
```
4. If ```-Dbrowser``` is not provided then test will run on chrome.
5. To run the test from any directory run the below command
```
mvn clean verify -DsuiteFile=absolutePathOfTestng.file -Dbrowser=driverOfChoose
```


## After test run completed
1. Test log will be found under ```reports\log``` directory
2. Test report will be found under ```reports``` directory
3. Test failures screenshot will be found under ```reports\screenshot``` directory

## Properties user can set:
From ```application.properties``` file

* base.url
* defaultBrowser.name
* element.timeout
* pageLoad.timeout
* script.timeout


