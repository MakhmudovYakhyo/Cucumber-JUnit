package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WikipediaSearchFunction{

    WikipediaSearchPage searchPage = new WikipediaSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }

    @When("User types {string} in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box(String searchKeyword) {
        searchPage.searchInput.sendKeys(searchKeyword);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        searchPage.searchButton.click();
    }

    @Then("User sees {string} in the wiki title")
    public void user_sees_steve_jobs_in_the_wiki_title(String title) {
        BrowserUtils.verifyTitleContains(title);
    }

}
