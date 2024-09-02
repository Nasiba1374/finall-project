package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utilities.SeleniumUtility;

public class SignUpPage extends SeleniumUtility {
    public static final By USER_NAME_INPUT=
            By.xpath("//label[@for='username']/following-sibling::input");
    public static final By PASSWORD_INPUT=
            By.xpath("//label[@for='password']/following-sibling::div/input");
    public static final By CONFIRM_PASSWORD_INPUT=
            By.xpath("//label[@for='confirm']/following-sibling::div/input");
}