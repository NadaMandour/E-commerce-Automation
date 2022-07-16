@smoke
Feature: F03_Change Currency Feature

  Scenario: user can change currency feature
    Given user go to home page
    When user clicks on currency drop list
    And user select Euro currency
    Then Euro currency selected successfully

