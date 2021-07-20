package org.qa.sharif.testcases;

import org.openqa.selenium.WebDriver;
import org.qa.sharif.commonutils.AppConfig;
import org.qa.sharif.driver.DriverProvider;
import org.qa.sharif.pageobjectrepisotory.CurrencyExchangeCalculatorPage;
import org.qa.sharif.pageobjectrepisotory.CurrencyTable;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTestClass {
    private final String baseUrl = AppConfig.getBaseUrl();
    public WebDriver driver;
    public CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage;
    public CurrencyTable currencyTable;
    public  SoftAssert softVerify;


    @BeforeClass
    public void init() {
        driver = DriverProvider.getDriver();
        driver.get(baseUrl);
    }

    @AfterClass
    public void exit() {
        DriverProvider.quitDriver();
    }
}
