package apr_ui.page.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public abstract class BasePage {

    public static WebDriver driver;

    public static final String BASE_URL = "http://localhost:3000/apr/";

    public static final Map<String, String> PAGE_URLS = Map.ofEntries(
            Map.entry("login", BASE_URL + "login"));


    public static void navigateToSelectedPage(String pageName){
        switch (pageName){
            case "login" :
                BasePage.driver.get(BasePage.PAGE_URLS.get("login"));
            break;

            default:
                BasePage.driver.get(BasePage.BASE_URL);

        }
    }

}
