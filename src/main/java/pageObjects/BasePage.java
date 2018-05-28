package pageObjects;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage{

    protected WebDriver driver = WebDriverManager.getDriver();
    public BasePage() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,90);
        PageFactory.initElements(factory, this);
    }

}
