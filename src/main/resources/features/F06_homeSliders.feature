@smoke
Feature: F06_homeSliders | user clicks on the two sliders

  Scenario: first slider is clickable on home page
    Given user go to home page
    When user click on first slider
    Then user directed to url for first slider


  Scenario: second slider is clickable on home page
    Given user go to home page
    When user click on second slider
    Then user directed to url for second slider