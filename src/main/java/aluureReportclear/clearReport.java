package aluureReportclear;

import org.apache.commons.io.FileUtils;


import java.io.File;

public class clearReport {


    public static void clearAllureResults() {
        try {
            File resultsFolder = new File("allure-results");
            File reportFolder = new File("allure-report");

            if (resultsFolder.exists()|| reportFolder.exists()) {
                FileUtils.cleanDirectory(resultsFolder);
                FileUtils.cleanDirectory(reportFolder);
                System.out.println("Allure results and Report are cleaned");
            }
        } catch (Exception e) {
            e.printStackTrace();
}
    }

}
