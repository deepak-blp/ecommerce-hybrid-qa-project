package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void captureScreenshot(
            WebDriver driver,
            String screenshotName
    ) {

        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destinationFile = new File(
                "screenshots/" + screenshotName + ".png"
        );

        try {

            FileUtils.copyFile(srcFile, destinationFile);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}