package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private static WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private static WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX :
                System.setProperty(GECKO_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getGeckoDriverPath());
                driver = new FirefoxDriver();
                break;
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER :
                System.setProperty(IE_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getIEDriverPath());
                driver = new InternetExplorerDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver() throws IOException {
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
}
