Feature: Wikipedia Search Functionality and verifications\

  Background:
    Given User is on Wikipedia home page

  Scenario: Wikipedia Search Functionality Title Verification
    #Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" in the wiki title

  @scenarioOutlinePractice
  Scenario Outline: Wikipedia Search Functionality Title Verification with using DOT
    #Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" in the wiki title

    Examples:
      | searchValue  | expectedTitle |
      | Steve Jobs   | Steve Jobs    |
      | Bill Gates   | Bill Gates    |
      | Elon Musk    | Elon Musk     |
      | Donald Trump | Donald Trump  |
      | Joe Biden    | Joe Biden     |