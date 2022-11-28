package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.LoginPage;
import utils.ConfigurationReader;
import utils.Driver;

import java.time.Duration;

public class Login_StepDefinition {

    WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(10));
    LoginPage loginPage = new LoginPage();

    @Given("The user goes to homepage")
    public void theUserGoesToHomepage() {
        Driver.driver.get(ConfigurationReader.getProperty("url_test"));
    }

    @Then("The user verifies that the url is {string}")
    public void theUserVerifiesThatTheUrlIs(String url) {
        Assert.assertEquals(url,Driver.driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOf(loginPage.cookiesButton)).click();
    }

    @When("The user enters with the right credentials")
    public void theUserEntersWithTheRightCredentials() {

        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameInput)).sendKeys(ConfigurationReader.getProperty("username"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput)).sendKeys(ConfigurationReader.getProperty("password"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();
    }

    @Then("The user should login successfully")
    public void theUserShouldLoginSuccessfully() {
        Assert.assertTrue(loginPage.successMessage.isDisplayed());
    }

    @When("The user enters with the right username but wrong password")
    public void theUserEntersWithTheRightUsernameButWrongPassword() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameInput)).sendKeys(ConfigurationReader.getProperty("username"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput)).sendKeys(ConfigurationReader.getProperty("wrongPassword"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();
    }

    @Then("The user should not login successfully")
    public void theUserShouldNotLoginSuccessfully() {
        Assert.assertTrue(loginPage.invalidButton.isDisplayed());
    }

    @When("The user enters with the wrong username but right password")
    public void theUserEntersWithTheWrongUsernameButRightPassword() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameInput)).sendKeys(ConfigurationReader.getProperty("wrongUsername"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput)).sendKeys(ConfigurationReader.getProperty("password"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();
    }
}
