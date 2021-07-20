package org.qa.sharif.testcases;

import org.qa.sharif.dataproviders.ReadData;
import org.qa.sharif.pageobjectrepisotory.CurrencyExchangeCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoEmptyFieldTest extends BaseTestClass {

    public CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage;

    @BeforeClass
    public void createCurrencyPage() {
        currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
    }

    @Test(dataProvider = "autoEmptyFileTest", dataProviderClass = ReadData.class)
    public void Verify_Sell_Has_Default_Value(String message, String value) {
        String defaultSellValue = currencyExchangeCalculatorPage.getDefaultSellAmount();
        Assert.assertEquals(defaultSellValue, value, message + " not matched with expected value");

    }

    @Test(dataProvider = "autoEmptyFileTest", dataProviderClass = ReadData.class)
    public void Verify_Sell_Amount_Not_Emptied_By_Click_On_Buy_Amount(String message, String value) {
        currencyExchangeCalculatorPage.setSellAmount(value);
        currencyExchangeCalculatorPage.clickOnBuyAmount();
        Assert.assertEquals(currencyExchangeCalculatorPage.getSellAmount(), value, "Test failed for data type: " + message);

    }

    @Test(dataProvider = "autoEmptyFileTest", dataProviderClass = ReadData.class)
    public void Verify_Sell_Amount_Empty_By_Buy_Amount(String message, String value) {
        currencyExchangeCalculatorPage.setSellAmount(value);
        currencyExchangeCalculatorPage.setBuyAmount(value);
        Assert.assertEquals(currencyExchangeCalculatorPage.getSellAmount().isEmpty(), "Test failed for data type: " + message);
    }

    @Test(dataProvider = "autoEmptyFileTest", dataProviderClass = ReadData.class)
    public void Verify_Buy_Amount_Not_Emptied_By_Click_On_Sell_Amount(String message, String value) {
        currencyExchangeCalculatorPage.setBuyAmount(value);
        currencyExchangeCalculatorPage.clickOnSellAmount();
        Assert.assertEquals(currencyExchangeCalculatorPage.getBuyAmount(), value, "Test failed for data type: " + message);
    }

    @Test(dataProvider = "autoEmptyFileTest", dataProviderClass = ReadData.class)
    public void Verify_Buy_Amount_Empty_By_Sell_Amount(String message, String value) {
        currencyExchangeCalculatorPage.setBuyAmount(value);
        currencyExchangeCalculatorPage.setSellAmount(value);
        Assert.assertEquals(currencyExchangeCalculatorPage.getBuyAmount().isEmpty(), "Test failed for data type: " + message);
    }

}
