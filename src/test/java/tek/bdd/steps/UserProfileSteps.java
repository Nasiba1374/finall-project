package tek.bdd.steps;


import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.utilities.SeleniumUtility;

import java.util.List;

public class UserProfileSteps extends SeleniumUtility {
    @Then("validate information is in Profile Side Drawer is correct")
    public void validateInformationIsInProfileSideDrawerIsCorrect() {
        String text=gettingText(By.xpath("//span[text()='Active']"));
        Assert.assertEquals("Active",text);
        List<WebElement> webElementList= getElements
                (By.xpath("//div[@id='chakra-modal--body-:r3:']//p/following-sibling::*"));
        List<String> expected= List.of("CSR","Supervisor","supervisor","admin");
        for (int  i=1;i<webElementList.size();i++){
            Assert.assertEquals(expected.get(i-1),webElementList.get(i).getText());
        }
    }
}
