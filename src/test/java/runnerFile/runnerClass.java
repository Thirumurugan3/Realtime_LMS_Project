package runnerFile;

import configReaderfolder.readConfig;
import driversManger.driverFactory;
import driversManger.driverManager;
import aluureReportclear.clearReport;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.baseClass;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/featureFolder/sample.feature", glue = {"stepDefenition","hooks"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class runnerClass extends baseClass {

}
