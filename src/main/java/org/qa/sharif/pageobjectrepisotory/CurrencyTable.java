package org.qa.sharif.pageobjectrepisotory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CurrencyTable extends BasePage {
    private By officialRateLocator = By.xpath(".//td[2]");

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> currencyTableRow;

    public String getOfficialExchangeRateByCurrency(String currencyProvided) {
        String officialRate = null;
        for (WebElement currencyRow : currencyTableRow) {
            if (currencyRow.getText().contains(currencyProvided)) {
                officialRate = currencyRow.findElement(officialRateLocator).getText();
                break;
            }
        }

        return officialRate;
    }

}
