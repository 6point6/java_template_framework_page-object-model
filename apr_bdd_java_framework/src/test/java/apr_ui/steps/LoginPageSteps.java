package apr_ui.steps;

import apr_ui.page.pageobjectmodel.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage();

    @And("I enter {string} in the username field")
    public void iEnterInTheUsernameField(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter {string} on the password field")
    public void iEnterOnThePasswordField(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String button) {
            loginPage.clickOnButton(button);
    }

    @Then("I am successfully login")
    public void iAmSuccessfullyLogin() {
        Assert.assertTrue(loginPage.signOutButtonIsDisplayed());
    }

    @And("^I enter ([^\"]*) in the username field and ([^\"]*) in the password field$")
    public void iEnterUsernameInTheUsernameFieldAndPasswordInThePasswordField(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("I can see error message {string}")
    public void iCanSeeErrorMessage(String text) {
        Assert.assertEquals(loginPage.getErrorMsg(text),text);
    }
}