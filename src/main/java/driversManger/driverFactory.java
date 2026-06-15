package driversManger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverFactory {

    /**
     * Opens the given browser and returns its WebDriver object.
     * @param browser Browser name (Chrome, Firefox, or Edge)
     * @return WebDriver instance of the selected browser
     * @throws RuntimeException if the browser name is invalid
     */

    public static WebDriver launchBrowser(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("fireFox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();

        } else {
            throw new RuntimeException("Browser not Found");
        }

    }

}
