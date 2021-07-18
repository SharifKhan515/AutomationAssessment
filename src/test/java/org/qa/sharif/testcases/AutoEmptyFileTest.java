package org.qa.sharif.testcases;

import org.qa.sharif.dataproviders.ReadData;
import org.qa.sharif.pages.CurrencyExchangeCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoEmptyFileTest extends BaseTestClass{

    @Test(dataProvider = "autoEmptyFileTest",dataProviderClass = ReadData.class)
    public void Verify_Sell_Has_Default_Value(String message, String value) throws InterruptedException {
        CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        String defaultSellValue = currencyExchangeCalculatorPage.getDefaultSellAmount();
        Assert.assertEquals(defaultSellValue,value, message+" not matched with expected value");
    }

    @Test(dataProvider = "autoEmptyFileTest",dataProviderClass = ReadData.class)
    public void Verify_Sell_Amount_Not_Emptied_By_Click_On_Buy_Amount(String message, String value){
        CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        currencyExchangeCalculatorPage.setSellAmount(value);
        currencyExchangeCalculatorPage.clickOnBuyAmount();
        Assert.assertEquals(currencyExchangeCalculatorPage.getSellAmount(),value,"Test failed for data type: "+message);
    }

    @Test(dataProvider = "autoEmptyFileTest",dataProviderClass = ReadData.class)
    public void Verify_Sell_Amount_Empty_By_Buy_Amount(String message,String value){
        CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        currencyExchangeCalculatorPage.setSellAmount(value);
        currencyExchangeCalculatorPage.setBuyAmount(value);
        Assert.assertTrue(currencyExchangeCalculatorPage.getSellAmount().isEmpty(),"Test failed for data type: "+message);
    }

    @Test(dataProvider = "autoEmptyFileTest",dataProviderClass = ReadData.class)
    public void Verify_Buy_Amount_Not_Emptied_By_Click_On_Sell_Amount(String message,String value){
        CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        currencyExchangeCalculatorPage.setBuyAmount(value);
        currencyExchangeCalculatorPage.clickOnBuyAmount();
        Assert.assertEquals(currencyExchangeCalculatorPage.getBuyAmount(),value,"Test failed for data type: "+message);
    }

    @Test(dataProvider = "autoEmptyFileTest",dataProviderClass = ReadData.class)
    public void Verify_Buy_Amount_Empty_By_Sell_Amount(String message,String value){
        CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        currencyExchangeCalculatorPage.setBuyAmount(value);
        currencyExchangeCalculatorPage.setSellAmount(value);
        Assert.assertTrue(!currencyExchangeCalculatorPage.getBuyAmount().isEmpty(),"Test failed for data type: "+message);
    }

}
