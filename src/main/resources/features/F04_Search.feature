@smoke
Feature: F04_Search | user can search using product name or sku

  Scenario Outline: user could search using product name
    Given user go to home page
    When user enters <search_word> in search field and clicks on search button
    Then search results with <search_word> will displayed

    Examples:
      |search_word|
      |book|
    |laptop|
      |nike|

  Scenario Outline: user could search for product using sku
    Given user go to home page
    When user enters <search_sku> in search field and clicks on search button
    Then search results with <search_sku> will displayed

    Examples:
      | search_sku |
      | SCI_FAITH  |
      | APPLE_CAM  |
      | SF_PRO_11  |