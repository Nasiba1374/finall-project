package tek.bdd.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import tek.bdd.utilities.SeleniumUtility;

public class HooksSteps extends SeleniumUtility {
    @Before
    public void beforeEachScenario(){
        setupBrowser();
    }
    @After
    public void afterEachScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = takeScreenshot();
            scenario.attach(screenshot,"image/png", "failed_scenario");
        }
        quiteBrowse();
    }
}