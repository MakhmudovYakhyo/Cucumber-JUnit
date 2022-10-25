package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EatingCucumber {

    @Given("John is hungary")
    public void john_is_hungary() {
        System.out.println("It is from given");
    }

    @When("he eats some cucumbers")
    public void he_eats_some_cucumbers() {
        System.out.println("It is from when");
    }

    @Then("he will be full")
    public void he_will_be_full() {
        System.out.println("It is from then");
    }

}