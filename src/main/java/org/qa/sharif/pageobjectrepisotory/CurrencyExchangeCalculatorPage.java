package org.qa.sharif.pageobjectrepisotory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.sharif.commonutils.DriverHelper;

import java.util.List;


public class CurrencyExchangeCalculatorPage extends BasePage {

    // sell field related locator
    @FindBy(xpath = "//input[contains(@data-ng-model,'filter.from_amount')]")
    private WebElement sellAmountField;
    @FindBy(xpath = "//div[@data-ng-model='currencyExchangeVM.filter.from']//span[@class='ng-binding ng-scope']")
    private WebElement sellAmountCurrencyField;
    @FindBy(xpath = "//div[contains(@data-ng-model,'currencyExchangeVM.filter.from')]//ul//span[@data-ng-bind='currency']")
    private List<WebElement> sellCurrencyList;


    // buy field related locator
    @FindBy(xpath = "//input[contains(@data-ng-model,'filter.to_amount')]")
    private WebElement buyAmountField;
    @FindBy(xpath = "//div[@data-ng-model='currencyExchangeVM.filter.to']//span[@class='ng-binding ng-scope']")
    private WebElement buyAmountCurrencyField;


    @FindBy(xpath = "//div[@data-ng-show='currencyExchangeVM.loading']")
    private WebElement currencyExchangeTableLoader;

    //Country dropdown related locator
    @FindBy(xpath = "//span[@class='js-localization-popover']")
    private WebElement selectCountryButton;
    @FindBy(css = "#countries-dropdown")
    private WebElement selectCountryDropdown;

    @FindBy(css = "[aria-labelledby='countries-dropdown']")
    private WebElement selectCountryMenu;

    @FindBy(xpath = "//ul[@aria-labelledby='countries-dropdown']/li/a")
    private List<WebElement> countryList;


    public void clickOnSellAmount() {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(sellAmountField);
        sellAmountField.click();
    }

    public void enterSellAmount(String amount) {
        setSellAmount(amount);
        sellAmountField.sendKeys(Keys.ENTER);
        DriverHelper.waitForElementVisibility(currencyExchangeTableLoader);
        DriverHelper.waitForElementBecomeInvisible(currencyExchangeTableLoader);
    }

    public void setSellCurrency(String currency) {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(sellAmountCurrencyField);
        sellAmountCurrencyField.click();
        for (WebElement cr : sellCurrencyList) {
            if (cr.getText().equalsIgnoreCase(currency)) {
                cr.click();
                break;
            }
        }
    }
    
    public void setSellAmount(String amount) {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(sellAmountField);
        sellAmountField.clear();
        sellAmountField.sendKeys(amount);
    }

    public String getDefaultSellAmount() {
        DriverHelper.pageReload();
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(currencyExchangeTableLoader);
        return sellAmountField.getAttribute("value");
    }

    public String getSellAmount() {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(sellAmountField);
        return sellAmountField.getAttribute("value");
    }

    public String getSellCurrency() {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(sellAmountCurrencyField);
        return sellAmountCurrencyField.getText();
    }


    public void clickOnBuyAmount() {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(buyAmountField);
        buyAmountField.click();
    }

    public void setBuyAmount(String amount) {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(buyAmountField);
        buyAmountField.clear();
        buyAmountField.sendKeys(amount);
    }

    public String getBuyAmount() {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(buyAmountField);
        return buyAmountField.getAttribute("value");
    }

    public void selectCountry(String countryName) {
        DriverHelper.waitForPageJsLoad();
        DriverHelper.scrollToBottom();
        selectCountryButton.click();
        DriverHelper.waitForElementVisibility(selectCountryDropdown);
        selectCountryDropdown.click();
        for (WebElement country : countryList) {
            if (country.getText().equalsIgnoreCase(countryName)) {
                country.click();
                break;
            }
        }
    }
}
