package tek.bdd.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.utilities.SeleniumUtility;
import java.util.List;

public class PlansSteps extends SeleniumUtility {
    @Then("user validate four row of data is present")
    public void userValidateRowOfDataIsPresent() {
        List<WebElement> webElementList= getElements
                (By.xpath("//td[4]"));
        // System.out.println(webElementList.size());
        Assert.assertEquals(4,webElementList.size());

    }

    @When("user validate create date is today date \\(EST Time zone) and expire date is tomorrow date \\(EST Time zone)")
    public void userValidateCreateDateIsTodayDateESTTimeZone() {
        List<WebElement> dateCreated = getElements
                (By.xpath("//td[4]"));
        List<WebElement> expireDate = getElements
                (By.xpath("//td[5]"));

        for(int i=0;i<dateCreated.size();i++){
            Assert.assertEquals(todayDate(),dateCreated.get(i).getText());
            Assert.assertEquals(tomorrowDate(),expireDate.get(i).getText());
        }

    }

}