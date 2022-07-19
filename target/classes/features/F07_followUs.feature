@smoke
Feature: F07_followUs | user clicks on follow us and open new tab

#scenario 1
  Scenario: user opens facebook link
    Given user go to home page
    When user opens facebook link
    Then url "https://www.facebook.com/nopCommerce" is opened in new tab

#scenario 2
  Scenario: user opens twitter link
    Given user go to home page
    When user opens twitter link
    Then url "https://twitter.com/nopCommerce" is opened in new tab

#scenario 3
  Scenario: user opens rss link
    Given user go to home page
    When user opens rss link
    Then url "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

#scenario 4
  Scenario: user opens youtube link
    Given user go to home page
    When user opens youtube link
    Then url "https://www.youtube.com/user/nopCommerce" is opened in new tab