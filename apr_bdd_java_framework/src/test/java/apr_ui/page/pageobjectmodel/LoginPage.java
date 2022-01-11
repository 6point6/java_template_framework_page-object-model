package apr_ui.page.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private static final By usernameField = By.id("username");
    private static final By passwordField = By.id("password");
    private static final By showButton = By.cssSelector("button[type='Button']");
    private static final By signinButton = By.cssSelector("button[type='submit']");
    private static final By signOut = By.cssSelector("div[id='header-signOut']");
    private static final By signErrorMsg = By.cssSelector("h3[class='sc-jJoQJp iDpLGa']");
    private static final By usernameErrorMsg = By.xpath("//span[contains(text(),'username')]");
    private static final By passwordErrorMsg = By.xpath("//span[contains(text(),'password')]");

    private WebElement getUsernameField() {
        return driver.findElement(usernameField);
    }

    private WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    private WebElement getShowButton() {
        return driver.findElement(showButton);
    }

    private WebElement getSignButton() {
        return driver.findElement(signinButton);
    }

    private WebElement getSignOut() {
        return driver.findElement(signOut);
    }

    private WebElement getSignErrorMsg() {
        return driver.findElement(signErrorMsg);
    }

    private WebElement getUsernameErrorMsg() {
        return driver.findElement(usernameErrorMsg);
    }

    private WebElement getPasswordErrorMsg() {
        return driver.findElement(passwordErrorMsg);
    }

    public void enterUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnButton(String button) {
        switch (button) {
            case "Show":
                getShowButton().click();
                break;
            case "Signin":
                getSignButton().click();
                break;
            default:
                getUsernameField().click();
        }
    }

    public boolean signOutButtonIsDisplayed() {
        return getSignOut().isDisplayed();
    }

    public String getErrorMsg(String errorMsg) {
        if (errorMsg.contains("sign in"))
            return getSignErrorMsg().getText();
        else if (errorMsg.contains("username"))
            return getUsernameErrorMsg().getText();
        else
            return getPasswordErrorMsg().getText();
        }
}
