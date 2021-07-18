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


    @FindBy(xpath = "//input[contains(@data-ng-model,'filter.from_amount')]")
    private WebElement sellAmountField;
    @FindBy(xpath="//div[@data-ng-model='currencyExchangeVM.filter.from']//span[@class='ng-binding ng-scope']")
    private WebElement sellAmountCurrencyField;


    @FindBy(xpath = "//input[contains(@data-ng-model,'filter.to_amount')]")
    private WebElement buyAmountField;
    @FindBy(xpath="//div[@data-ng-model='currencyExchangeVM.filter.to']//span[@class='ng-binding ng-scope']")
    private WebElement buyAmountCurrencyField;



    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement currencyExchangeTableFirstRow;



    public void clickOnSellAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView(sellAmountField);
        sellAmountField.click();
    }

    public void setSellAmount(String amount) {
        DriverHelper.scrollElementToView(sellAmountField);
        sellAmountField.clear();
        sellAmountField.sendKeys(amount);
    }
    public String getDefaultSellAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView(sellAmountField);
        DriverHelper.waitForElementVisibility(currencyExchangeTableFirstRow);
        return sellAmountField.getAttribute("value");
    }


    public String getSellAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView(sellAmountField);
        return sellAmountField.getAttribute("value");
    }

    public void clickOnBuyAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView(buyAmountField);
        buyAmountField.click();
    }

    public void setBuyAmount(String amount) {
        DriverHelper.scrollElementToView( buyAmountField);
        buyAmountField.clear();
        buyAmountField.sendKeys(amount);
    }

    public String getBuyAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView( buyAmountField);
        return  buyAmountField.getAttribute("value");
    }


}
