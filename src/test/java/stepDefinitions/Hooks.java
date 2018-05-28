package stepDefinitions;


import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.*;
import managers.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;


public class Hooks extends WebDriverManager{

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        WebDriverManager.getDriver();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);
                //This attach the specified screenshot to the test
                Reporter.addScreenCaptureFromPath("./screenshots/"+screenshotName+".png");
            } catch (IOException e) {
            }
        }
        WebDriverManager.closeDriver();
    }


    @Before(order=0)
    public void beforeScenarioStart(Scenario scenario){
        System.out.println("-----------------Start of Scenario-----------------");
    }

    @After(order=0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    }
}