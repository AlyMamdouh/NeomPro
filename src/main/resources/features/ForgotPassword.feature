#Author: srikanth.mallela@scryai.com

@forgotPassWord
Feature: Forgot Password Test Cases

  Background: 
    Given User is already on the forgot password page

  Scenario Outline: Validate forgor password page
    Then User validates forgot password page

    Examples: 
      | TestCaseName                       |
      | TC01_Validate forgot password page |

  Scenario Outline: Validate email warning message with valid email
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ForgotPasswordTestCases.csv"
    Then User enter email and submit
    Then User validates success notification message
    
    Examples: 
      |	Test Case Name	|
      |	TC02_Validate email warning message with valid email	|

  Scenario Outline: Validate email warning message with invalid email
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ForgotPasswordTestCases.csv"
    Then User enter email and submit
    Then User validates error notification message

    Examples: 
      |	Test Case Name	|
      |	TC03_Validate email warning message with invalid email	|
      