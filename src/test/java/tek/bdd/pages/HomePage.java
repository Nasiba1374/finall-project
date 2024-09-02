package tek.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.utilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {
    public static final String TITLE= getDriver().getTitle();
    public static final By CREATE_PRIMARY_ACCOUNT_LINK=
            By.xpath("//a[text()='Create Primary Account']");
    public static final By LOGIN_LINK=
            By.xpath("//a[@href='/login']");
}
