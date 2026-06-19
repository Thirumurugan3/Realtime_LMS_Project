package utilities;

import driversManger.driverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.waitConstants;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class baseClass {
    protected baseClass() {

    }
    private static final Logger log = loggerUtil.getLogger(baseClass.class);

    private static JavascriptExecutor js() {
        return (JavascriptExecutor) driverManager.getDriver();
    }

    private static WebDriverWait getWait(int time) {
        return new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(time));
    }

    /**
     * This method used to Maximize the Window
     */
    public static void windowMax() {
        try {
            driverManager.getDriver().manage().window().maximize();
            log.info("Browser window maximized");
        } catch (Exception e) {
            log.error("Unable to maximize browser window", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method used to Get the URL
     */
    public static String getURl(String url) {
        try {
            driverManager.getDriver().get(url);
            log.info("Navigated to URL: {}", url);
            return url;
        } catch (Exception e) {
            log.error("Unable to navigate to URL: {}", url, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method waits until element to be clickable
     */
    public static WebElement wait_for_click(WebElement element) {
        try {
            WebElement ele = getWait(waitConstants.explicit_Wait)
                    .until(ExpectedConditions.elementToBeClickable(element));

            log.info("Element is clickable");
            return ele;

        } catch (Exception e) {
            log.error("Element is not clickable", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method clicks the element
     */
    public static void click(WebElement element) {
        try {
            wait_for_click(element).click();
            log.info("Clicked on element");
        } catch (Exception e) {
            log.error("Unable to click element", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method waits until element to be visible
     */
    public static WebElement Wait_for_visible(WebElement element) {
        try {
            WebElement ele = getWait(waitConstants.explicit_Wait)
                    .until(ExpectedConditions.visibilityOf(element));

            log.info("Element is visible");
            return ele;

        } catch (Exception e) {
            log.error("Element is not visible", e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method waits until element is present by locator
     */
    public static WebElement Wait_for_presence(By locator) {
        try {
            WebElement element = getWait(waitConstants.explicit_Wait)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));

            log.info("Element is present: {}", locator);
            return element;

        } catch (Exception e) {
            log.error("Element not present: {}", locator, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method waits until element is visible by locator
     */
    public static WebElement Wait_for_visible(By locator) {
        try {
            WebElement element = getWait(waitConstants.explicit_Wait)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            log.info("Element is visible: {}", locator);
            return element;

        } catch (Exception e) {
            log.error("Element not visible: {}", locator, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method waits until element is clickable by locator
     */
    public static WebElement Wait_for_clickable(By locator) {
        try {
            WebElement element = getWait(waitConstants.explicit_Wait)
                    .until(ExpectedConditions.elementToBeClickable(locator));

            log.info("Element is clickable: {}", locator);
            return element;

        } catch (Exception e) {
            log.error("Element not clickable: {}", locator, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method waits until title contains expected text
     */
    public static boolean Wait_for_title_contains(String title) {
        try {
            boolean status = getWait(waitConstants.explicit_Wait)
                    .until(ExpectedConditions.titleContains(title));

            log.info("Title contains: {}", title);
            return status;

        } catch (Exception e) {
            log.error("Title does not contain: {}", title, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method waits until URL contains expected text
     */
    public static boolean Wait_for_url_contains(String url) {
        try {
            boolean status = getWait(waitConstants.explicit_Wait)
                    .until(ExpectedConditions.urlContains(url));

            log.info("URL contains: {}", url);
            return status;

        } catch (Exception e) {
            log.error("URL does not contain: {}", url, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method waits until alert is present
     */
    public static Alert Wait_for_alert() {
        try {
            Alert alert = getWait(waitConstants.explicit_Wait)
                    .until(ExpectedConditions.alertIsPresent());

            log.info("Alert is present");
            return alert;

        } catch (Exception e) {
            log.error("Alert not present", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method used to enter the values in the element
     */
    public static void sendValues(WebElement element, String value) {
        try {
            Wait_for_visible(element).sendKeys(value);
            log.info("Entered value: {}", value);
        } catch (Exception e) {
            log.error("Unable to enter value: {}", value, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method used to switch the tabs or windows in browser
     */
    public static void windowHandles() {
        try {

            Set<String> windowHandles =
                    driverManager.getDriver().getWindowHandles();

            List<String> tabs =
                    new ArrayList<>(windowHandles);

            for (String tab : tabs) {
                driverManager.getDriver().switchTo().window(tab);
            }

            log.info("Switched to latest window");

        } catch (Exception e) {
            log.error("Unable to switch window", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method used to random single click
     */
    public static void singleClick() {
        try {

            Actions act =
                    new Actions(driverManager.getDriver());

            act.click().perform();

            log.info("Performed single click");

        } catch (Exception e) {
            log.error("Unable to perform single click", e);
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
            File destination = new File("target/Screenshots/" + fileName + ".png");

            FileUtils.copyFile(source, destination);

            log.info("Screenshot captured: {}", fileName);

        } catch (Exception e) {
            log.error("Unable to capture screenshot", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method scrolls down the page by the given pixels.
     */
    public static void scrollDown(int pixels) {
        try {

            js().executeScript(
                    "window.scrollBy(0, arguments[0])",
                    pixels);

            log.info("Scrolled down by {} pixels", pixels);

        } catch (Exception e) {
            log.error("Unable to scroll down", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method clicks the element using JavaScript.
     */
    public static void jsClick(WebElement element) {
        try {
            js().executeScript("arguments[0].click();", element);
            log.info("Clicked element using JavaScript");
        } catch (Exception e) {
            log.error("Unable to click element using JavaScript", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method moves the mouse over the element.
     */
    public static void mouseHover(WebElement element) {
        try {
            Actions act = new Actions(driverManager.getDriver());
            act.moveToElement(element).perform();
            log.info("Mouse hovered on element");
        } catch (Exception e) {
            log.error("Unable to hover on element", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method returns the text of the element.
     */
    public static String getText(WebElement element) {
        try {
            String text = Wait_for_visible(element).getText();
            log.info("Captured text: {}", text);
            return text;
        } catch (Exception e) {
            log.error("Unable to get text from element", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method scrolls to the specified element.
     */
    public static void scrollToElement(WebElement element) {
        try {

            js().executeScript(
                    "arguments[0].scrollIntoView(true);",
                    element);

            log.info("Scrolled to element");

        } catch (Exception e) {
            log.error("Unable to scroll to element", e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method performs double click on element.
     */
    public static void doubleClick(WebElement element) {
        try {

            Actions act =
                    new Actions(driverManager.getDriver());

            act.doubleClick(element).perform();

            log.info("Double clicked on element");

        } catch (Exception e) {
            log.error("Unable to double click element", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method performs right click on element.
     */
    public static void rightClick(WebElement element) {
        try {

            Actions act =
                    new Actions(driverManager.getDriver());

            act.contextClick(element).perform();

            log.info("Right clicked on element");

        } catch (Exception e) {
            log.error("Unable to right click element", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method performs drag and drop.
     */
    public static void dragAndDrop(
            WebElement source,
            WebElement target) {

        try {

            Actions act =
                    new Actions(driverManager.getDriver());

            act.dragAndDrop(source, target).perform();

            log.info("Drag and Drop performed");

        } catch (Exception e) {
            log.error("Unable to perform drag and drop", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method scrolls up the page by given pixels.
     */
    public static void scrollUp(int pixels) {
        try {

            js().executeScript(
                    "window.scrollBy(0,-arguments[0])",
                    pixels);

            log.info("Scrolled up by {} pixels", pixels);

        } catch (Exception e) {
            log.error("Unable to scroll up", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method refreshes the current page.
     */
    public static void refreshPage() {
        try {
            driverManager.getDriver().navigate().refresh();
            log.info("Page refreshed");
        } catch (Exception e) {
            log.error("Unable to refresh page", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method navigates back to previous page.
     */
    public static void navigateBack() {
        try {
            driverManager.getDriver().navigate().back();
            log.info("Navigated back");
        } catch (Exception e) {
            log.error("Unable to navigate back", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method navigates forward.
     */
    public static void navigateForward() {
        try {
            driverManager.getDriver().navigate().forward();
            log.info("Navigated forward");
        } catch (Exception e) {
            log.error("Unable to navigate forward", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method gets current page title.
     */
    public static String getTitle() {
        try {

            String title =
                    driverManager.getDriver().getTitle();

            log.info("Page title: {}", title);

            return title;

        } catch (Exception e) {
            log.error("Unable to get title", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method gets current page URL.
     */
    public static String getCurrentUrl() {
        try {

            String url =
                    driverManager.getDriver().getCurrentUrl();

            log.info("Current URL: {}", url);

            return url;

        } catch (Exception e) {
            log.error("Unable to get current URL", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method checks whether element is displayed.
     */
    public static boolean isDisplayed(WebElement element) {
        try {

            boolean status =
                    element.isDisplayed();

            log.info("Element displayed status: {}", status);

            return status;

        } catch (Exception e) {
            log.error("Unable to verify displayed status", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method checks whether element is enabled.
     */
    public static boolean isEnabled(WebElement element) {
        try {

            boolean status =
                    element.isEnabled();

            log.info("Element enabled status: {}", status);

            return status;

        } catch (Exception e) {
            log.error("Unable to verify enabled status", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method checks whether element is selected.
     */
    public static boolean isSelected(WebElement element) {
        try {

            boolean status =
                    element.isSelected();

            log.info("Element selected status: {}", status);

            return status;

        } catch (Exception e) {
            log.error("Unable to verify selected status", e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method accepts alert.
     */
    public static void acceptAlert() {
        try {

            Wait_for_alert().accept();

            log.info("Alert accepted");

        } catch (Exception e) {
            log.error("Unable to accept alert", e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method dismisses alert.
     */
    public static void dismissAlert() {
        try {

            Wait_for_alert().dismiss();

            log.info("Alert dismissed");

        } catch (Exception e) {
            log.error("Unable to dismiss alert", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method gets alert text.
     */
    public static String getAlertText() {
        try {

            String text =
                    Wait_for_alert().getText();

            log.info("Alert text: {}", text);

            return text;

        } catch (Exception e) {
            log.error("Unable to get alert text", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method sends text to alert.
     */
    public static void sendTextToAlert(String value) {
        try {

            Wait_for_alert().sendKeys(value);

            log.info("Entered text in alert: {}", value);

        } catch (Exception e) {
            log.error("Unable to enter text in alert", e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method switches to frame using index.
     */
    public static void switchToFrame(int index) {
        try {
            driverManager.getDriver().switchTo().frame(index);

            log.info("Switched to frame using index: {}", index);
        } catch (Exception e) {
            log.error("Unable to switch to frame using index: {}", index, e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method switches to frame using name.
     */
    public static void switchToFrame(String name) {
        try {
            driverManager.getDriver().switchTo().frame(name);

            log.info("Switched to frame using name: {}", name);
        } catch (Exception e) {
            log.error("Unable to switch to frame using name: {}", name, e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method switches to frame using WebElement.
     */
    public static void switchToFrame(WebElement frame) {
        try {
            driverManager.getDriver().switchTo().frame(frame);

            log.info("Switched to frame using WebElement");
        } catch (Exception e) {
            log.error("Unable to switch to frame using WebElement", e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method switches back to default content.
     */
    public static void switchToDefaultContent() {
        try {
            driverManager.getDriver().switchTo().defaultContent();

            log.info("Switched to default content");
        } catch (Exception e) {
            log.error("Unable to switch to default content", e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method selects dropdown value by visible text.
     */
    public static void selectByVisibleText(WebElement element, String text) {
        try {
            new Select(element).selectByVisibleText(text);
            log.info("Selected dropdown value: {}", text);
        } catch (Exception e) {
            log.error("Unable to select dropdown value: {}", text, e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method selects dropdown value by value.
     */
    public static void selectByValue(WebElement element, String value) {
        try {
            new Select(element).selectByValue(value);

            log.info("Selected dropdown value: {}", value);
        } catch (Exception e) {
            log.error("Unable to select dropdown value: {}", value, e);
            throw new RuntimeException(e);
        }
    }
    /**
     * This method selects dropdown value by index.
     */
    public static void selectByIndex(WebElement element, int index) {
        try {
            new Select(element).selectByIndex(index);

            log.info("Selected dropdown index: {}", index);
        } catch (Exception e) {
            log.error("Unable to select dropdown index: {}", index, e);
            throw new RuntimeException(e);
        }
    }


}
