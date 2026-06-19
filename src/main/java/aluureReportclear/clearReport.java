package aluureReportclear;

import driversManger.driverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;

public class clearReport {


    public static void clearAllureResults() {
        try {
            File resultsFolder = new File("allure-results");
            File reportFolder = new File("allure-report");

            if(resultsFolder.exists()) {
                FileUtils.cleanDirectory(resultsFolder);
            }

            if(reportFolder.exists()) {
                FileUtils.cleanDirectory(reportFolder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] takeScreenshotForAllure(String name) {

        return ((TakesScreenshot) driverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }

}
