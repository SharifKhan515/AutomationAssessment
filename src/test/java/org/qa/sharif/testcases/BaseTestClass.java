package org.qa.sharif.testcases;


import org.openqa.selenium.WebDriver;
import org.qa.sharif.commonutils.AppConfig;
import org.qa.sharif.driver.DriverProvider;
import org.testng.annotations.*;

public class BaseTestClass {

    private final String baseUrl = AppConfig.getBaseUrl();
    public WebDriver driver;


    @BeforeClass
    public void init(){
         driver = DriverProvider.getDriver();
         driver.get(baseUrl);
    }

    @BeforeMethod
    public void beforeTestMethod(){

    }

    @AfterMethod
    public void afterTestMethod(){

    }

    @AfterClass
    public void exit(){

       // DriverProvider.quitDriver();
    }

}
