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
import utilities.loggerUtil;

public class hooksClass {

    private static final Logger log =
            loggerUtil.getLogger(hooksClass.class);

    @Before
    public void setup() {

        log.info("Browser Launch Started");

        String browser = System.getProperty("browser");

        if(browser == null || browser.isEmpty()){
            browser = readConfig.getProp("browser");
        }

        log.info("Selected Browser : {}", browser);

        driverManager.setDriver(
                driverFactory.launchBrowser(browser));

        baseClass.windowMax();

        log.info("Browser Launched Successfully");
    }

    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {

            log.error("Scenario Failed : {}",
                    scenario.getName());

            clearReport.takeScreenshotForAllure(
                    "Failed Screenshot");
        }

        driverManager.getDriver().quit();

        log.info("Browser Closed");
    }
}