package org.qa.sharif.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.sharif.commonutils.DriverHelper;
import org.qa.sharif.driver.DriverProvider;


public class CurrencyExchangeCalculatorPage {


    public CurrencyExchangeCalculatorPage() {

        PageFactory.initElements(DriverProvider.getDriver(), this);
    }

    //input[@data-ng-model='currencyExchangeVM.filter.from_amount']

    @FindBy(xpath = "//input[contains(@data-ng-model,'from_amount')]")
    private WebElement sellAmountField;


    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement currencyExchangeTableFirstRow;


    public String getDefaultSellAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView(sellAmountField);
        DriverHelper.waitForElementVisibility(currencyExchangeTableFirstRow);
        return sellAmountField.getAttribute("value");
    }

    public void setSellAmount(String amount) {
        DriverHelper.scrollElementToView(sellAmountField);
        sellAmountField.clear();
        sellAmountField.sendKeys(amount);
    }

    public String getSellAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView(sellAmountField);
        return sellAmountField.getAttribute("value");
    }


}
