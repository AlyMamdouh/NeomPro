#Author: srikanth.mallela@scryai.com

@constructionFootage
Feature: Construction Footage Test Cases

  Background: 
    Given User should be on GroundX login page

 Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "Drone Operator4"
    Then User validates construction footage page
    Then User filter the assets
    Then User logout from GroundX application
###
    Examples:
      | Test Case Name                   |
     | TC01_Drone operator filter with region     |
      | TC02_Drone operator filter with subArea    |
    | TC03_Drone operator filter with deviceID   |
     | TC04_Drone operator filter with deviceType |
     | TC05_Drone operator filter with format     |
      | TC06_Drone operator filter with date	|


#
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "Drone Operator2"
    Then User validates construction footage page
    Then User uploads assets from construction footage page
    Then User logout from GroundX application
###
    Examples:
      | Test Case Name          |
      |    TC07_Drone operator upload assets .doc from construction footage page	|
      |	TC08_Drone operator upload assets .txt from construction footage page	|
      |    TC09_Drone operator upload assets .pdf from construction footage page	|
      |	TC10_Drone operator upload assets .xls from construction footage page |
      |	TC11_Drone operator upload assets .jpg from construction footage page	|
      |	TC12_Drone operator upload assets .gif from construction footage page	|

 ###################needs combine with above tests as similar features
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "Drone Operator5"
    Then User validates construction footage page
    Then User uploads assets from construction footage page
    Then User logout from GroundX application
####
    Examples:
      | Test Case Name          |
      |	TC13_Drone operator upload assets .png from construction footage page	|
      | TC14_Drone operator upload assets .SRT from construction footage page	|
      | TC15_Drone operator upload large assets from construction footage page	|
      | TC16_Drone operator upload assets with minimum size from construction footage page 	|
      | TC17_Drone operator upload assets with maximum size from construction footage page 	|


  ####### Test data not working correctly
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "Drone Operator3"
    Then User validates construction footage page
    Then User uploads assets from workspace
    Then User logout from GroundX application
#####
    Examples:
      | Test Case Name          |
      | TC18_Drone operator upload assets from workspace	|

  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "Drone Operator5"
    Then User validates construction footage page
    Then User validates assets uploaded by self
    Then User logout from GroundX application
#####
    Examples:
      | Test Case Name          |
      | TC19_Drone operator validates assets uploaded by self	|
#
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "Drone Operator5"
    Then User validates construction footage page
    Then User uploads assets from construction footage page and cancel
    Then User logout from GroundX application
##
    Examples:
      | Test Case Name          |
      | TC20_Drone operator upload assets and cancel from construction footage page	|
      | TC21_Drone operator upload assets and validate srt files message from construction footage page	|
##
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "External User3"
    Then User vlaidates links to construction footage
    Then User logout from GroundX application
##
    Examples:
      | Test Case Name          |
      | TC22_ExternalUser with no access vlaidates links to construction footage	|
#
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "External User2"
    Then User validates construction footage page
    Then User filter the assets
    Then User logout from GroundX application
###
    Examples:
      | Test Case Name                   |
  #   | TC23_ExternalUser filter with region     |
   #  | TC24_ExternalUser filter with subArea    |
    # | TC25_ExternalUser filter with deviceID   |
   #   | TC26_ExternalUser filter with deviceType |
#      | TC27_ExternalUser filter with format     |
#      |  TC28_ExternalUser filter with date	|
#
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/ConstructionFootageTestCases.csv"
    Then User logged into GroundX application as "External User3"
    Then User validates construction footage page
    Then User uploads assets from construction footage page
    Then User logout from GroundX application
####
    Examples:
    | Test Case Name          |
      | TC29_External User upload assets .doc from construction footage page	|
