package org.qa.sharif.testcases;

import org.qa.sharif.dataproviders.CountryData;
import org.qa.sharif.dataproviders.ReadData;
import org.qa.sharif.pageobjectrepisotory.CurrencyExchangeCalculatorPage;
import org.qa.sharif.pageobjectrepisotory.CurrencyTable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CountryCurrencyUpdateTest extends BaseTestClass {

    public CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage;
    public CurrencyTable currencyTable;

    @BeforeClass
    public void createCurrencyPage() {
        currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        currencyTable = new CurrencyTable();
    }

    @Test(dataProvider = "CountryCurrencyUpdateTest", dataProviderClass = ReadData.class)
    public void verify_Currency_Update_With_Country_Select(String firstCountry, String secondCountry) {
        String officialRateOfFirstCurrency, officialRateOfSecondCurrency;

        currencyExchangeCalculatorPage.selectCountry(CountryData.valueOf(firstCountry).getCountryName());
        softAssert.assertEquals(currencyExchangeCalculatorPage.getSellCurrency(), CountryData.valueOf(firstCountry).getCurrency());
        officialRateOfFirstCurrency = currencyTable.getOfficialExchangeRateByCurrency(CountryData.USA.getCurrency());

        currencyExchangeCalculatorPage.selectCountry(CountryData.valueOf(secondCountry).getCountryName());
        softAssert.assertEquals(currencyExchangeCalculatorPage.getSellCurrency(), CountryData.valueOf(secondCountry).getCurrency());
        officialRateOfSecondCurrency = currencyTable.getOfficialExchangeRateByCurrency(CountryData.USA.getCurrency());

        softAssert.assertNotEquals(officialRateOfFirstCurrency, officialRateOfSecondCurrency, "Currency rate not updated");

    }
}
