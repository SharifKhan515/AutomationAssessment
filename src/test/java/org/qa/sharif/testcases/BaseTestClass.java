package org.qa.sharif.testcases;

import org.openqa.selenium.WebDriver;
import org.qa.sharif.commonutils.AppConfig;
import org.qa.sharif.driver.DriverProvider;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTestClass {
    private final String baseUrl = AppConfig.getBaseUrl();
    public WebDriver driver;
    public SoftAssert softAssert;

    @BeforeClass
    public void init() {
        driver = DriverProvider.getDriver();
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void beforeTestMethod() {
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void afterTestMethod() {
        softAssert.assertAll();
    }

    @AfterClass
    public void exit() {
        DriverProvider.quitDriver();
    }
}
