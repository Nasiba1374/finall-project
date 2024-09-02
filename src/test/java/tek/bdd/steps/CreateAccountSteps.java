package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utilities.SeleniumUtility;

public class CreateAccountSteps extends SeleniumUtility {
    private final String randomUsername;

    public CreateAccountSteps() {
        this.randomUsername = RandomUsername();
    }

    @When("validate user in {string} page")
    public void validateUserInAPage(String text){
        String xpath="//h2[text()='"+text+"']";
        Assert.assertEquals(gettingText(By.xpath(xpath))
                ,text);
    }



    @Then("user click on profile icon")
    public void userClickOnProfileIcon() {

        clickOnElement(By.xpath("//button[@aria-label='profile']"));
    }

    @Then("validate full name display at profile section")
    public void validateFullNameDisplayAtProfileSection() {
        String expectedFullName="Nasiba Mehraban";
        String fullName=gettingText(By.xpath("//p[text()='Nasiba Mehraban']"));
        Assert.assertEquals(expectedFullName,fullName);
    }

    @When("user enter signUp information")
    public void userEnterSignUpInformation() {
        //randomUsername=RandomUsername();
        sendText(SignUpPage.USER_NAME_INPUT,randomUsername);
        sendText(SignUpPage.PASSWORD_INPUT,"Mehraban22");
        sendText(SignUpPage.CONFIRM_PASSWORD_INPUT,"Mehraban22");
    }

    @When("user enter {string} and {string} to signIn")
    public void userEnterSignInInformation(String usernameInput,String passwordInput) {
        if (usernameInput.equalsIgnoreCase("randomUserName")){
            sendText(SignUpPage.USER_NAME_INPUT,randomUsername);}
        else {
            sendText(SignUpPage.USER_NAME_INPUT,usernameInput);
        }
        sendText(SignUpPage.PASSWORD_INPUT,passwordInput);
    }
}
