package tek.bdd.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private  static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);
    private static WebDriverWait getWait(){

        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }
    public static WebElement waitForVisibility(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickOnElement(By locator){
        LOGGER.debug("Clicking on {}",locator);
        waitForVisibility(locator).click();
    }
    public void sendText(By locator,String text){
        LOGGER.debug("Sending {} in {}",text,locator);
        waitForVisibility(locator).clear();
        if (text!=null){
            waitForVisibility(locator).sendKeys(text);}
    }
    public String gettingText(By locator ){
        LOGGER.debug("Returning element {}",locator);
        return waitForVisibility(locator).getText();
    }
    public boolean isElementEnable(By locator){

        return waitForVisibility(locator).isEnabled();
    }
    public boolean isDisplayed(By locator)
    {LOGGER.debug("Checking if the element {} is displayed",locator);
        return waitForVisibility(locator).isDisplayed();
    }
    public List<WebElement> getElements(By locator){
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public byte[] takeScreenshot(){
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }
    public String RandomEmail(){

        return "Nasiba"+(int)(Math.random()*10000)+"@gmail.com";
    }
    public String RandomUsername(){

        return "Mehraban"+(int)(Math.random()*1000);
    }
    public String todayDate(){
        LocalDateTime today=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMMM d,yyyy");
        return today.format(formatter);
    }

    public String tomorrowDate(){
        LocalDateTime today=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMMM d,yyyy");
        LocalDateTime tomorrow=today.plusDays(1);
        return tomorrow.format(formatter);
    }

}