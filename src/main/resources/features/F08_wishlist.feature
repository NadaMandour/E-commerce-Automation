@smoke
Feature: F08_wishList | user add products to wish list
  Scenario: user add product to wish list
Given user go to home page
    When user click add to wishList icon
    Then the green success message is displayed


    Scenario: user check the product added successfully
    Given user go to home page
      When user click add to wishList icon
      Then product added successfully to wishList