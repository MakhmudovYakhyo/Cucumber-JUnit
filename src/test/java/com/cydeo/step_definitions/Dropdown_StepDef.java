package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class Dropdown_StepDef {

    DropdownsPage dropdownsPage = new DropdownsPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> dataTable) {

        // This utility method returns list of String of given dropdown WebElement
        List<String> optionsAsString = BrowserUtils.dropdownOptionsAsString(dropdownsPage.monthDropdown);

        // Assert will check the size of the list first. If it is matching, it will check/verify content one by one
        Assert.assertEquals(optionsAsString, dataTable);
    }

}