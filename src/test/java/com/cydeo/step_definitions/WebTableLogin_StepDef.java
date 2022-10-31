package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTableLogin_StepDef {

    WebTableLoginPage loginPage = new WebTableLoginPage();

    @Given("user is on the login page of  web table app")
    public void userIsOnTheLoginPageOfWebTableApp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.usernameText.sendKeys(username);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.passwordText.sendKeys(password);
    }

    @And("user clicks to login button")
    public void userClicksToLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("user should see url contains orders")
    public void userShouldSeeUrlContainsOrders() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("etsy"));
    }

    @When("user enter username {string} password {string} and logins")
    public void userEnterUsernamePasswordAndLogins(String username, String password) {
       /* loginPage.usernameText.sendKeys(username);
        loginPage.passwordText.sendKeys(password);
        loginPage.loginButton.click();*/
        loginPage.login(username,password);
    }

    @When("user enters below credentials")
    public void userEntersBelowCredentials(Map<String,String> credentials) {
        loginPage.login(credentials.get("username"),credentials.get("password"));
    }
}
