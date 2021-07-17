package org.qa.sharif.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider {

    private static WebDriver driver;


    public static WebDriver initiateDriver(){
        String browser = null;
        if(System.getProperty("browser")==null){

        }else{
            browser = System.getProperty("browser");
        }

        if(driver==null){
            if(browser.equalsIgnoreCase("CHROME")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(browser.equalsIgnoreCase("FIREFOX")){
                WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver();
            } else {
                throw  new IllegalArgumentException(browser +" is not currently covered by automation");
            }

            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
