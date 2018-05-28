package utils;

import helpers.Log;
import managers.FileReaderManager;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.BasePage;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Common extends BasePage {

    protected  LocalFileDetector detector = new LocalFileDetector();
    public static Common getInstance( ){
        return new Common();
    }

    public  boolean waitForPageLoad(int waitTimeInSec, ExpectedCondition<Boolean>... conditions) {
        boolean isLoaded = false;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTimeInSec, TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(2, TimeUnit.SECONDS);
        for (ExpectedCondition<Boolean> condition : conditions) {
            isLoaded = wait.until(condition);
            if (isLoaded == false) {
                //Stop checking on first condition returning false.
                break;
            }
        }
        return isLoaded;
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    //Scroll to element
    public  void scrollToElement(int x, int y) {
        Log.info("Scroll to element");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy("+ x + "," + y + ")");
    }


    // ----------------------------------------------------------------------------------------------------------------------------------------
    // Check x amount of secs for element to exist
    public static boolean isElementPresent(WebElement element, int time) throws Exception {
        boolean flag = false;
        int i = 0;

        /*try{*/
        while (i < time) {
            //if (element.isDisplayed() || element.isEnabled()) {
            if (element.isDisplayed() || element.isEnabled()) {
                Log.info("        Webelement found: " + element);
                flag = true;
                break;
            } else {
                Log.error("        Webelement Not found");
                Thread.sleep(1000);
                i++;
            }
        }
        Thread.sleep(2000);
        return flag;
		/*} catch(Exception ex){
			logger.info("        WebElement not Found");
			return flag;
		}*/
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    // Accept popup by passing true and display title of Alert. Passing false dismisses popup
    public  String closeAlertAndGetItsText(boolean acceptNextAlert) throws Exception {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
            Log.info("        Accepting Alert popup: " + alertText);
            alert.accept();
        } else {
            Log.info("        Declining Accepting Alert popup: " + alertText);
            alert.dismiss();
        }
        return alertText;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    // Overloading Switch to popup window and returns p for  parent or c for child window handler
    public  String switchToPopupWin(String winType) throws Exception {
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String switchWin = null;

        if(winType.equals("c")){
            //skip first element which is parent
            it.next();
        }
        while (it.hasNext()){
            switchWin = it.next();
            Log.info("        Switching to Pop Up Window: " + driver.switchTo().window(switchWin).getTitle());
            driver.switchTo().window(switchWin);
            driver.manage().window().maximize();
        }
        Thread.sleep(2000);
        if(winType.equals("c")){
            return switchWin;
        }
        return parentWindow;
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    // Switch to popup window and returns parent window handler
    public  String switchToPopupWin() throws Exception {
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String switchWin = null;

        while (it.hasNext()){
            switchWin = it.next();
            Log.info("        Switching to Pop Up Window: " + driver.switchTo().window(switchWin).getTitle());
            driver.switchTo().window(switchWin);
            driver.manage().window().maximize();
        }
        Thread.sleep(2000);
        return parentWindow;
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    // Switch to Parent window by passing parent window handler
    public  void switchToParentWin(String parentWindow) throws Exception {
        Log.info("        Switching to Parent Window: " + driver.switchTo().window(parentWindow).getTitle());
        driver.switchTo().window(parentWindow);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    // Switch to window by passing parent window handler
    public  void switchToWin(String window) throws Exception {
        Log.info("        Switching to Window: " + driver.switchTo().window(window).getTitle());
        driver.switchTo().window(window);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    // Switch to frame in the browser
    public  void switchToFrame(WebElement element) throws Exception {

        if (isElementPresent(element, 5)){
            Log.info("        Switching to Frame: " + element.getAttribute("name") );
            driver.switchTo().frame(element);
        } else {
            Log.error("        Frame not found: " + element.getAttribute("name"));
        }

    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    // Switch back to default window from frame
    public  void switchToDefaultWinFromFrame() throws Exception {
        Log.info("        Switching to Default window: " + driver.getTitle() );
        driver.switchTo().defaultContent();
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    //Upload File - Tells WebDriver that you’re uploading files from your local computer to a remote server
    public  void uploadFile(WebElement element, String fileName) throws Exception {
        File upOne = new File(System.getProperty("user.dir")).getParentFile();
        String filePath = (upOne + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + fileName);

        File file = detector.getLocalFile(filePath);
        ((RemoteWebElement)element).setFileDetector(detector);

        if (file.exists()){
            element.sendKeys(filePath);
            Log.info("        Adding File path: " + filePath);
        } else {
            Log.error("        File not found path: " + filePath);
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    //Click on the hidden link
    public  void clickHiddenPageObject(WebElement element, int elementArg) throws Exception{

        if(element != null) {
            ((JavascriptExecutor)driver).executeScript("arguments[" + elementArg  +"].click();", element);
            Log.info("        Click on element " + element);
            Thread.sleep(1000);
        } else {
            Log.error("        Element " + element + " does not exist");
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    //Click on the hidden link
    public  void setClearInputValue(WebElement element, int elementArg) throws Exception{

        if(element != null) {
            ((JavascriptExecutor)driver).executeScript("arguments[" + elementArg  +"].value = '';", element);
            Log.info("        Cleared Input value for element " + element);
            Thread.sleep(1000);
        } else {
            Log.error("        Element " + element + "does not exist");
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    //Wait until the element is not visible anymore. Wait time in seconds
    public static void waitUntilElementIsNotVisible(WebElement element, int waitTime) throws Exception{
        Log.info("        Waiting for : " + element.getText() + " to finish.");
        for (int i = 0; i < waitTime; i++)

        {

            if (!element.isDisplayed())

            {
                Log.info("        Element: " + element.getText() + " is not visible anymore.");
                break;

            } else {
                Log.info("        Element: " + element.getText() + " is still visible anymore.");
            }

            Thread.sleep(1000);

        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    //Wait until the element is not visible anymore. Wait time in seconds
    public static boolean isElementNotPresent(WebElement element, int time) throws Exception {
        boolean flag = false;
        int i = 0;

        while (i < time) {
            try{
                if ((element.isDisplayed() || element.isEnabled())) {
                    Log.info("        Element: " + element.getText() + " is visible.");
                }
            } catch (Exception e){
                flag = true;
                Log.info("        Element is not visible.");
                break;
            }
            Thread.sleep(1000);
            i++;
        }
        return flag;
    }

    //This method verifies if the an element is hidden
    public static boolean isElementHidden(WebElement element, int time) throws Exception{
        boolean flag = false;
        int i = 0;
        while (i < time) {
            if(element.getAttribute("style").contains("none")){
                flag = true;
                Log.info("        Element is hidden.");
                break;
            }
            Thread.sleep(1000);
            i++;
        }
        return flag;
    }

}
