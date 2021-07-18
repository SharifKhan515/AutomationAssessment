package org.qa.sharif.commonutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.sharif.driver.DriverProvider;

public class DriverHelper {


    public static void scrollElementToView(WebElement element) {
        WebDriver driver = DriverProvider.getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToBottom() {
        WebDriver driver = DriverProvider.getDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), AppConfig.getDefaultElementTimeOut());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPageLoad() {
        new WebDriverWait(DriverProvider.getDriver(), AppConfig.getDefaultPageTimeout()).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public static void pageReload() {
        WebDriver driver = DriverProvider.getDriver();
        driver.navigate().refresh();
    }

}
