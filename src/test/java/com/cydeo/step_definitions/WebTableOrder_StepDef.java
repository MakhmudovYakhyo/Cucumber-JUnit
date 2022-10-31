package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.pages.WebTableOrderPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class WebTableOrder_StepDef {

    WebTableLoginPage loginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    WebTableOrderPage orderPage = new WebTableOrderPage();
    ViewAllOrdersPage allOrdersPage = new ViewAllOrdersPage();
    Select select;

    @Given("user is already logged in and on order page")
    public void userIsAlreadyLoggedInAndOnOrderPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        basePage.orderButtonNavItem.click();
    }

    @When("user selects product type {string}")
    public void userSelectsProductType(String arg0) {
        select = new Select(orderPage.productTypeDropdown);
        select.selectByVisibleText(arg0);
    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {
        // default there was already number in this input
        // first we need to clean that input, and we will send keys later

        //orderPage.inputQuantity.clear();
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);

        // accepting int arg and sending text using sendKeys() method
        // since sendKeys() method only accepts String, we need either concat with ""
        // or send String.valueOf(int)
        // webTableOrderPage.inputQuantity.sendKeys(int+"");
        orderPage.inputQuantity.sendKeys(String.valueOf(arg0));
    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String arg0) {
        orderPage.inputName.sendKeys(arg0);
    }

    @And("user enters street {string}")
    public void userEntersStreet(String arg0) {
        orderPage.inputStreet.sendKeys(arg0);
    }

    @And("user enters city {string}")
    public void userEntersCity(String arg0) {
        orderPage.inputCity.sendKeys(arg0);
    }

    @And("user enters state {string}")
    public void userEntersState(String arg0) {
        orderPage.inputState.sendKeys(arg0);
    }

    @And("user enters zipcode {string}")
    public void userEntersZipcode(String arg0) {
        orderPage.inputZip.sendKeys(arg0);
    }

    @And("user selects credit card type {string}")
    public void userSelectsCreditCardType(String arg0) {
        BrowserUtils.clickRadioButton(orderPage.cardType, arg0);
    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String arg0) {
        orderPage.inputCardNo.sendKeys(arg0);
    }

    @And("user enters expiry date {string}")
    public void userEntersExpiryDate(String arg0) {
        orderPage.inputCardExp.sendKeys(arg0);
    }

    @And("user enters process order button")
    public void userEntersProcessOrderButton() {
        orderPage.processOrderButton.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void userShouldSeeInFirstRowOfTheWebTable(String arg0) {
        String actual = allOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(arg0,actual);
    }
}
