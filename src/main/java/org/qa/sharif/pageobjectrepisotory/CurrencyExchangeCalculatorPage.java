package org.qa.sharif.pageobjectrepisotory;

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


    // buy field related locator
    @FindBy(xpath = "//input[contains(@data-ng-model,'filter.to_amount')]")
    private WebElement buyAmountField;
    @FindBy(xpath = "//div[@data-ng-model='currencyExchangeVM.filter.to']//span[@class='ng-binding ng-scope']")
    private WebElement buyAmountCurrencyField;


    // Currency Table related locator when country is lithuania
    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement currencyExchangeTableFirstRow;


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
        DriverHelper.pageReload();
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

    public String getSellCurrency() {
        DriverHelper.waitForPageLoad();
        DriverHelper.waitForElementVisibility(sellAmountCurrencyField);
        DriverHelper.scrollElementToView(sellAmountCurrencyField);
        return sellAmountCurrencyField.getText();
    }


    public void clickOnBuyAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView(buyAmountField);
        buyAmountField.click();
    }

    public void setBuyAmount(String amount) {
        DriverHelper.scrollElementToView(buyAmountField);
        buyAmountField.clear();
        buyAmountField.sendKeys(amount);
    }

    public String getBuyAmount() {
        DriverHelper.waitForPageLoad();
        DriverHelper.scrollElementToView(buyAmountField);
        return buyAmountField.getAttribute("value");
    }

    public void selectCountry(String countryName) {
        DriverHelper.waitForPageLoad();
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
