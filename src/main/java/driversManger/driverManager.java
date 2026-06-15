package driversManger;

import org.openqa.selenium.WebDriver;

public class driverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Returns the WebDriver of the current thread.
     * @return WebDriver instance
     */

    public static WebDriver getDriver() {
        return driver.get();
    }


    /**
     * Stores the WebDriver for the current thread.
     * @param driverref WebDriver instance to be stored
     */

    public static void setDriver(WebDriver driverref) {
        driver.set(driverref);
    }
}
