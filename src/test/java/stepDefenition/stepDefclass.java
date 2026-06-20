package stepDefenition;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import utilities.excelUtil;
import utilities.loggerUtil;
import utilities.testdataManager;

import java.util.Map;

public class stepDefclass {

    private static final Logger log =
            loggerUtil.getLogger(stepDefclass.class);

    @Given("user data {string}")
    public void loadData(String tcid) {

        Map<String,String> data =
                excelUtil.getTestData(
                        "src/test/resources/testdata.xlsx",
                        "Sheet1",
                        tcid);
        System.out.println(data);

        testdataManager.setTestData(data);
    }
}