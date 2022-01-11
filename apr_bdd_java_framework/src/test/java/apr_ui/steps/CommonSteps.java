package apr_ui.steps;

import apr_ui.DriverManager;
import apr_ui.page.pageobjectmodel.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonSteps {

    @Before
    public void setup() {
        BasePage.driver = DriverManager.getDriver();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        BasePage.driver.quit();
    }

    @Given("I have navigated to webappsecurity home page")
    public void iHaveNavigatedToWebappsecurityHomePage() {
        BasePage.driver.get(BasePage.PAGE_URLS.get("login"));
    }

    @Given("I have navigated to the DIO APR {string} page")
    public static void iHaveNavigatedToTheDIOAPRPage(String pageName) {
        BasePage.navigateToSelectedPage(pageName);
    }
}
