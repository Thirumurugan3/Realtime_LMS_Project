package runnerFile;

import configReaderfolder.readConfig;
import driversManger.driverFactory;
import driversManger.driverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.baseClass;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/featureFolder/sample.feature", glue = "stepDefenition",
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class runnerClass extends baseClass {

    @BeforeClass
    public static void startBrowser() {
        String browser = readConfig.getProp("browser");
        driverManager.setDriver(driverFactory.launchBrowser(browser));
        windowMax();
    }

    @AfterClass
    public static void tearDown() {
        driverManager.getDriver().quit();
    }
}
