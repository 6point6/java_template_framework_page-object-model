package apr_ui.steps;

import apr_ui.page.pageobjectmodel.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class HomePageSteps {

    private final HomePage page = new HomePage();

    @When("I click on the logo icon")
    public void iHaveNavigatedToTheZeroWebappsecurityPage() {
        page.clickOnLogoBtn();
    }

    @Then("The Home page image is visible")
    public void theHomePageImageIsVisible() {
        Assert.assertTrue(page.homePageImgIsVisible());
    }
}
