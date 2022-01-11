package apr_ui.page.pageobjectmodel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    private static final By homePageImg = By.className("active");
    private static final By logo = By.className("brand");

    private WebElement getLogo() {
        return driver.findElement(logo);
    }

    private WebElement getHomePageImg() {
        return driver.findElement(homePageImg);
    }

    public void clickOnLogoBtn() {
        getLogo().click();
    }

    public boolean homePageImgIsVisible() {
        getHomePageImg().isDisplayed();
        return true;
    }
}
