package hooks;

import aluureReportclear.clearReport;
import configReaderfolder.readConfig;
import driversManger.driverFactory;
import driversManger.driverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.baseClass;
import org.apache.logging.log4j.Logger;
import utilities.excelUtil;
import utilities.loggerUtil;
import utilities.testdataManager;

import java.util.Map;

public class hooksClass {

    private static final Logger log =
            loggerUtil.getLogger(hooksClass.class);


    @Before
    public void setup() {

        clearReport.clearAllureResults();
        log.info("Allure reports cleared");

        String browser =
                System.getProperty("browser");

        if (browser == null || browser.isEmpty()) {
            browser = readConfig.getProp("browser");
        }

        driverManager.setDriver(
                driverFactory.launchBrowser(browser));

        baseClass.windowMax();

        log.info("Browser launched : {}", browser);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            clearReport.takeScreenshotForAllure(
                    "Failed Screenshot");

            log.error("Scenario Failed : {}",
                    scenario.getName());
        }

        testdataManager.unloadData();

        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }

        log.info("Browser Closed");
    }
}