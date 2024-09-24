package tek.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class BaseSetup {

    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    private static WebDriver driver;
    private Properties properties;
    public BaseSetup(){
        try {
            String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/dev-configs.properties";

            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex){
            throw new RuntimeException("Something is wrong with Config file", ex);
        }
    }



    public void setupBrowser(){
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        if (browserType.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver=new ChromeDriver(options);
        } else  if (browserType.equalsIgnoreCase("edge")){
            EdgeOptions options=new EdgeOptions();
            if (isHeadless)options.addArguments("--headless");
            driver=new EdgeDriver(options);

        }else if(browserType.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            if(isHeadless)options.addArguments("--headless");
            driver=new FirefoxDriver(options);
        }else { throw new RuntimeException("Wrong browser type choose between chrome, firefox or edge");
        }
        String url=properties.getProperty("ui.url");
        LOGGER.info("Navigating to URL {}", url);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public static WebDriver getDriver(){
        return driver;
    }

    public void quiteBrowse(){
        if (driver!=null){
            driver.quit();
        }
    }

}