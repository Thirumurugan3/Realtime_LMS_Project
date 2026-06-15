package utilities;

import driversManger.driverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import timeouts.timeOut;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class baseClass {
    protected baseClass() {

    }

    private static JavascriptExecutor js() {
        return (JavascriptExecutor) driverManager.getDriver();
    }

    private static WebDriverWait wait(int time) {
        return new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(time));
    }

    /**
     * This method used to Maximize the Window
     */
    public static void windowMax() {
        try {
            driverManager.getDriver().manage().window().maximize();
        } catch (Exception e) {
            throw new RuntimeException("Cannot maximize window");
        }
    }

    /**
     * This method used to Get the URL
     */
    public static String getURl(String Url) {
        try {
            driverManager.getDriver().get(Url);
            return Url;
        } catch (Exception e) {
            throw new RuntimeException("URl not Found");
        }
    }

    /**
     * This method waits until element to be clickable
     */
    public static WebElement wait_for_click(WebElement element) {
        try {
            return wait(timeOut.explicit_Wait).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new RuntimeException("Element Cant be Clickble");
        }
    }

    /**
     * This method clicks the element
     */
    public static void click(WebElement element) {
        try {
            wait_for_click(element).click();
        } catch (Exception e) {
            throw new RuntimeException("Element Cant be Clickble");
        }
    }

    /**
     * This method waits until element to be visible
     */
    public static WebElement Wait_for_visible(WebElement element) {
        try {
            return wait(timeOut.explicit_Wait).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw new RuntimeException("Element not visible");
        }
    }

    /**
     * This method used to enter the values in the element
     */
    public static void sendValues(WebElement element, String value) {
        try {
            Wait_for_visible(element).sendKeys(value, Keys.ENTER);
        } catch (Exception e) {
            throw new RuntimeException("Cannot enter the Value");
        }
    }

    /**
     * This method used to switch the tabs or windows in browser
     */
    public static void windowHandles() {
        try {
            Set<String> windowHandles = driverManager.getDriver().getWindowHandles();
            List<String> tabs = new ArrayList<>(windowHandles);
            for (String tab : tabs) {
                driverManager.getDriver().switchTo().window(tab);
            }
        } catch (Exception e) {
            throw new RuntimeException("can't switch current Window");
        }

    }

    /**
     * This method used to random single click
     */
    public static void singleClick() {
        try {
            Actions act = new Actions(driverManager.getDriver());
            act.click().perform();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to capture a screenshot of the current page.
     */
    public static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driverManager.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File("target/Screenshots" + fileName + ".png");
            FileUtils.copyFile(source, destination);

        } catch (Exception e) {
            throw new RuntimeException("Unable to capture screenshot");
        }
    }

    /**
     * This method scrolls down the page by the given pixels.
     */
    public static void scrollDown(int pixels) {
        try {
            js().executeScript("window.scrollBy(0, arguments[0])", pixels);
        } catch (Exception e) {
            throw new RuntimeException("Unable to scroll down");
        }
    }

    /**
     * This method clicks the element using JavaScript.
     */
    public static void jsClick(WebElement element) {
        try {
            js().executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to click using JavaScript");
        }
    }

    /**
     * This method moves the mouse over the element.
     */
    public static void mouseHover(WebElement element) {
        try {
            Actions act = new Actions(driverManager.getDriver());
            act.moveToElement(element).perform();
        } catch (Exception e) {
            throw new RuntimeException("Unable to hover over element");
        }
    }

    /**
     * This method returns the text of the element.
     */
    public static String getText(WebElement element) {
        try {
            return Wait_for_visible(element).getText();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get element text");
        }
    }

    /**
     * This method scrolls to the specified element.
     */
    public static void scrollToElement(WebElement element) {
        try {
            js().executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to scroll to element");
        }
    }


}
