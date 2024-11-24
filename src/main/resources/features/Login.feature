#Author: srikanth.mallela@scryai.com

@loginToGroundX
Feature: Construction Footage Test Cases

Background: 
		Given User launch the GroundX application

	Scenario Outline: Validate login page
  	Given User should be on GroundX login page
  	Then User validates login page
  	
  	Examples:
    |	Test Case Name	|
    |	TC01_Validate login page	|
    
 	Scenario Outline: Validate external user login page
  	Given User should be on GroundX login page
    Then User should select user Type as "Login as an external partner or vendor"
    Then User validates external user login page
    
    Examples:
    |	Test Case Name	|
    |	TC02_Validate external user login page	|
    
  Scenario Outline: Validate forgot password link
  	Given User should be on GroundX login page
    Then User validates forgot passwor link
    
    Examples:
    |	Test Case Name	|
    |	TC03_Validate forgot password link	|
    
  #Feature has removed  
  #Scenario Outline: Validate need an account link
  #	Given User should be on GroundX login page
    #Then User should select user Type as "Login as an external partner or vendor"
    #Then user validates need an account link
    #
    #Examples:
    #|	Test Case Name	|
    #|	TC04_Validate need an account link	|    
    
  Scenario Outline: GroundX login as external user
  	Given User should be on GroundX login page
  	Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/GroundXLoginPageTestCases.csv"
    Then User should select user Type as "Login as an external partner or vendor"
    Then User logged into GroundX application as "External User"
    Then Dashboard page should display
    Then User logout from GroundX application
    
    Examples:
    |	Test Case Name	|
    |	TC05_Login as external user|