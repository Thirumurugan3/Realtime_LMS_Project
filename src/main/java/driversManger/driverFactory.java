package driversManger;

import constants.browserConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class driverFactory {

    /**
     * Opens the given browser and returns its WebDriver object.
     * @param browser Browser name (Chrome, Firefox, or Edge)
     * @return WebDriver instance of the selected browser
     * @throws RuntimeException if the browser name is invalid
     */

    public static WebDriver launchBrowser(String browser) {

        if (browser.equalsIgnoreCase(browserConstants.CHROME)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            return new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase(browserConstants.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.addArguments("-private");
            return new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase(browserConstants.EDGE)) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--inprivate");
            options.addArguments("--disable-notifications");
            return new EdgeDriver(options);

        } else {
            throw new RuntimeException("Browser not Found");
        }

    }

}
