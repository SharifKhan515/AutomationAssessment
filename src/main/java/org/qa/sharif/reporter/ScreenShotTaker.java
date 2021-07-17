package org.qa.sharif.reporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static org.qa.sharif.environment.Environment.screenshotDirectory;

public class ScreenShotTaker {

    public static String getScreenshot(String methodName, WebDriver driver) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String filename = screenshotDirectory + "\\" + methodName + ".png";
        FileUtils.copyFile(source, new File(filename));
        return filename;
    }
}
