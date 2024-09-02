package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tek.bdd.utilities.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {
    public String randomEmail;
    @When("user click on {string} link")
    public void userClickOnLink(String text){
        clickOnElement(By.linkText(text));
    }
    @When("user click on {string} button")
    public void userClickOnButton(String text){
        String xpath = "//button[text()='"+text+"']";
        clickOnElement(By.xpath(xpath));
    }
    @When("user enter {string} in the {string} field")
    public void userInput(String input,String text){
        String xpath="//label[text()='"+ text +"']/following-sibling::input";
        if(input.equalsIgnoreCase("randomEmail")){
            randomEmail=RandomEmail();
            sendText(By.xpath(xpath),randomEmail);
        }else sendText(By.xpath(xpath),input);
    }

    @When("user select {string} from {string} field")
    public void userSelectFromField(String arg0, String arg1) {
        String xpath = "//option[text()='Select "+arg1+"']/..";
        WebElement element= getDriver().findElement(By.xpath(xpath));
        Select select=new Select(element);
        select.selectByVisibleText(arg0);
    }

    @Then("wait for {int} ms")
    public void waitForS(int arg0) throws InterruptedException {
        Thread.sleep(arg0);
    }

    @Then("validate user navigate to page and email address shows as expected")
    public void validateUserNavigateToPageAndEmailAddressShowsAsExpected() {
        String text = gettingText(By.xpath("//form/../h2[3]"));
        Assert.assertEquals(text,randomEmail);
    }

    @When("user enter {string} in the {string} field with no text attribute")
    public void userEnterInTheFieldWithoutTextAtribut(String input,String text) {
        text=text.toLowerCase();
        String xpath="//label[@for='"+ text +"']/following-sibling::input";
        sendText(By.xpath(xpath),input);
    }

}