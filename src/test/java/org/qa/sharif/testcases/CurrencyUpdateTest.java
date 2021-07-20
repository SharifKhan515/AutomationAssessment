package org.qa.sharif.testcases;

import org.qa.sharif.dataproviders.CountryData;
import org.qa.sharif.dataproviders.ReadData;
import org.qa.sharif.pageobjectrepisotory.CurrencyExchangeCalculatorPage;
import org.qa.sharif.pageobjectrepisotory.CurrencyTable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CurrencyUpdateTest extends BaseTestClass {

    @BeforeClass
    public void createCurrencyPage() {
        currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        currencyTable = new CurrencyTable();
        softVerify = new SoftAssert();
    }

    @Test(dataProvider = "CountryCurrencyUpdateTest", dataProviderClass = ReadData.class)
    public void verify_Currency_Update_With_Selected_Country(String firstCountry, String secondCountry) {
        float officialRateOfFirstCurrency, officialRateOfSecondCurrency;

        currencyExchangeCalculatorPage.selectCountry(CountryData.valueOf(firstCountry).getCountryName());
        softVerify.assertEquals(currencyExchangeCalculatorPage.getSellCurrency(), CountryData.valueOf(firstCountry).getCurrency());
        officialRateOfFirstCurrency = currencyTable.getOfficialExchangeRateByCurrency(CountryData.USA.getCurrency());

        currencyExchangeCalculatorPage.selectCountry(CountryData.valueOf(secondCountry).getCountryName());
        softVerify.assertEquals(currencyExchangeCalculatorPage.getSellCurrency(), CountryData.valueOf(secondCountry).getCurrency());
        officialRateOfSecondCurrency = currencyTable.getOfficialExchangeRateByCurrency(CountryData.USA.getCurrency());

        softVerify.assertNotEquals(officialRateOfFirstCurrency, officialRateOfSecondCurrency, "Currency rate not updated");
        softVerify.assertAll();
    }
}
