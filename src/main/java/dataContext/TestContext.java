package dataContext;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    public static ScenarioContext scenarioContext;

    public TestContext(){
        //pageObjectManager = new PageObjectManager(WebDriverManager.getDriver());
        //scenarioContext = new ScenarioContext();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public static ScenarioContext getScenarioContext() {
        if(scenarioContext == null){
            scenarioContext = new ScenarioContext();
        }else {
            return scenarioContext;
        }
        return  scenarioContext;
    }
}
