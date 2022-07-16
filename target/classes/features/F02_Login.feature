@smoke
Feature: F02-Login | users could Login to the system
#Tc1 valid data
Scenario: user could login with valid email and password
Given user go to login page
When user login with "valid" "test@example.com" and "P@ssw0rd"
And user press on login button
Then user login to the system successfully

#Tc2 invalid data
Scenario: user could login with invalid email and password
Given user go to login page
When user login with "invalid" "test@example.com" and "P@ssw0rd"
And user press on login button
Then user could not login to the system