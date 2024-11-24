#Author: srikanth.mallela@scryai.com

@workspaces
Feature: Workspaces Test Cases

  Background: 
    Given User should be on GroundX login page

    @Skip
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
    Then User logged into GroundX application as "Internal User"
#    Then User validates construction footage page
    Then User navigates to workspaces
    Then User selects workspace
    Then User creates Main Folder in workspace
    Then User validates newly created folder
    Then User uploads assets into the folder
#    Then User logout from GroundX application
####
    Examples:
      | Test Case Name                   |
      | TC01_Lock Folders - Internal user create lock folder with only folder name	|
      | TC02_Lock Folders - Internal user create lock folder with only folder name, description and date	|
#
#
#
  @Skip
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
    Then User logged into GroundX application as "Internal User"
# #   Then User validates construction footage page
    Then User navigates to workspaces
    Then User selects workspace
    Then User Navigates to old existing folder
    Then User creates Nested folder in workspace
   Then User validates newly created folder
##    Then User logout from GroundX application
####
    Examples:
      | Test Case Name                   |
      | TC03_Lock Folders - Internal user create lock folder inside existing standard folder	|
      | TC05_Lock Folders - Internal user create lock folder inside existing locked folder |
#      ###      | TC07_Lock Folders - External user with broader access create lock folder inside existing standard folder	|	Login as an external partner or vendor	|	User With Broader Access4	|
####      |	TC08_Lock Folders - External user with broader access create lock folder inside existing locked folder	|	Login as an external partner or vendor	|	User With Broader Access4	|
#
#
#####
  @Skip
 Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
    Then User logged into GroundX application as "Internal User"
 #   Then User validates construction footage page
    Then User navigates to workspaces
    Then User selects workspace
    Then User creates Main Folder in workspace
    Then User validates newly created folder
    Then User creates Nested folder in workspace
    Then User validates newly created folder
    Then User uploads assets into the folder
 #   Then User logout from GroundX application
##
    Examples:
   | Test Case Name                   |
    |	TC04_Lock Folders - Internal user create lock folder inside newly created standard folder	|
    |	TC06_Lock Folders - Internal user create lock folder inside newly created locked folder	|
###
###
    @Skip
    Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
      Then User logged into GroundX application as "Internal User"
##    Then User validates construction footage page
    Then User navigates to workspaces
    Then User selects workspace
    Then User creates folder with existing folder name in workspace
# #   Then User logout from GroundX application
####
    Examples:
      | Test Case Name                   |
      | TC09_Lock Folders - Internal user create lock folder with only folder name with existing folder name	|
      | TC10_Lock Folders - Internal user create lock folder with only folder name, description and date with existing folder name	|
###
  @Skip
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
    Then User logged into GroundX application as "Internal User"
#    Then User validates construction footage page
    Then User navigates to workspaces
    Then User selects workspace
    Then User navigates to folder
    Then User creates folder with existing folder name in workspace
    Then User uploads assets into the folder
##    Then User logout from GroundX application
###
   Examples:
      | Test Case Name                   |
      | TC11_Lock Folders - Internal user create lock folder inside existing standard folder with existing folder name	|
      |	TC12_Lock Folders - Internal user create lock folder inside existing locked folder with existing folder name	|
###      | TC13_Lock Folders - External user with broader access create lock folder inside existing standard folder with existing folder name	|	Login as an external partner or vendor	|	User With Broader Access4	|
###      |	TC14_Lock Folders - External user with broader access create lock folder inside existing locked folder with existing folder name	|	Login as an external partner or vendor	|	User With Broader Access4	|
###


  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
    Then User logged into GroundX application as "Internal User"
#    Then User validates construction footage page
    Then User navigates to workspaces
    Then User selects workspace
#    Then User navigates to folder
    Then User creates Main Folder in workspace
    Then User uploads assets into the folder
    Then User invites user to collaborate folder by Internal user
    Then User navigates to workspaces
    Then User selects workspace
    Then User logout from GroundX application
#    ###################################

    Then User should be on GroundX login page
    Then User waits to go to Login again
    Then User should select user Type as "Login as an external partner or vendor"
    Then User logged into GroundX application as "External User5"
    Then User navigates to Shared with me
    Then User navigates to shared folder
    Then User download assets
    Then User logout from GroundX application
#
#
    Examples:
      | Test Case Name                   |
      | TC17_Internal user creates new locked folder and invite external user |
#      |	TC18_External user with broader access creates new locked folder and invite external user	|	Login as an external partner or vendor	| User With Broader Access4	|
#
@Skip
  Scenario Outline: constructionFootage Test Cases
    Then User should select user Type as "Login as an external partner or vendor"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
    Then User logged into GroundX application as "External User5"
    Then User navigates to Shared with me
    Then User navigates to folder
#    Then User creates Main Folder in workspace
    Then External User uploads assets into the folder
    Then User invites user to collaborate folder by External user
    Then User logout from GroundX application
#    ####################################
    Then User waits to go to Login again
    Then User should be on GroundX login page
    Then User should select user Type as "Login as an external partner or vendor"
    Then User logged into GroundX application as "External User6"
    Then User navigates to Shared with me
    Then User navigates to shared folder
    Then User download assets
    Then User logout from GroundX application
#
    Examples:
      | Test Case Name                   |
      | TC19_External user creates new locked folder and invite external user |
#
#  Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "<Login>"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "<User Name>"
#    Then User validates construction footage page
#    Then User navigates to workspaces
#    Then User selects workspace
#    Then User navigates to folder
#    Then User uploads assets into the folder
#    Then User invites user to collaborate folder
#    Then User logout from GroundX application
#    ####################################
#    Then User should be on GroundX login page
#    Then User should select user Type as "Login as an external partner or vendor"
#    Then User logged into GroundX application as "External User5"
#    Then User navigates to Shared with me
#    Then User navigates to shared folder
#    Then User download assets
#    Then User logout from GroundX application
#
#
#    Examples:
#      | Test Case Name                   | Login	|	User Name	|
#      | TC20_Internal user invite external user to existing locked folders |	Login with NEOM account	|	Internal User	|
#      |	TC21_Internal user with admin rights invite external user to existing locked folders	|	Login with NEOM account	|	Internal User	|
#      |	TC22_External user having broader acess with admin rights invite external user to existing locked folders	|	Login as an external partner or vendor	|	User With Broader Access4	|
#
#
# Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "<Login>"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "<User Name>"
#    Then User validates construction footage page
#    Then User navigates to workspaces
#    Then User selects workspace
#    Then User navigates to folder
#    Then User uploads assets into the folder
#    Then User removes user from folder
#    Then User logout from GroundX application
#    ####################################
#    Then User should be on GroundX login page
#    Then User should select user Type as "Login as an external partner or vendor"
#    Then User logged into GroundX application as "External User5"
#    Then User navigates to Shared with me
#    Then User navigates to shared folder
#    Then User download assets
#    Then User logout from GroundX application
#
#
#    Examples:
#      | Test Case Name                   | Login	|	User Name	|
#      |	TC23_Internal user with admin rights remove user from locked folders	|	Login with NEOM account	|	Internal User	|
#      |	TC24_External user having broader acess with admin rights remove user from locked folders	|	Login as an external partner or vendor	|	User With Broader Access4	|
#
#   Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "Login as an external partner or vendor"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "External User5"
#    Then User navigates to Shared with me
#    Then User navigates to folder
#    Then User uploads assets into the folder
#    Then User removes user from folder
#    Then User logout from GroundX application
#    ####################################
#    Then User should be on GroundX login page
#    Then User should select user Type as "Login as an external partner or vendor"
#    Then User logged into GroundX application as "External User6"
#    Then User navigates to Shared with me
#    Then User navigates to shared folder
#    Then User download assets
#    Then User logout from GroundX application
#
#    Examples:
#      | Test Case Name                   |
#      | TC25_External user with admin righs removes user from locked folders |
#
#  Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "<Login>"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "<User Name>"
#    Then User validates construction footage page
#    Then User navigates to workspaces
#    Then User selects workspace
#    Then User navigates to folder
#    Then User uploads assets into the folder
#    Then User invites user to collaborate folder
#    Then User logout from GroundX application
#    ####################################
#    Then User should be on GroundX login page
#    Then User should select user Type as "Login as an external partner or vendor"
#    Then User logged into GroundX application as "External User5"
#    Then User navigates to Shared with me
#    Then User navigates to shared folder
#    Then User download assets
#    Then User logout from GroundX application
#
#    Examples:
#      | Test Case Name                   | Login	|	User Name	|
#      | TC26_Internal user invite external user to existing locked folders with only download |	Login with NEOM account	|	Internal User	|
#      |	TC27_Internal user with admin rights invite external user to existing locked folders with only download	|	Login with NEOM account	|	Internal User	|
#      |	TC28_External user having broader acess with admin rights invite external user to existing locked folders with only download	|	Login as an external partner or vendor	|	User With Broader Access4	|
#	    | TC29_Internal user invite external user to existing locked folders with only upload |	Login with NEOM account	|	Internal User	|
#      |	TC30_Internal user with admin rights invite external user to existing locked folders with only upload	|	Login with NEOM account	|	Internal User	|
#      |	TC31_External user having broader acess with admin rights invite external user to existing locked folders with only upload	|	Login as an external partner or vendor	|	User With Broader Access4	|
#
#  Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "Login as an external partner or vendor"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "External User5"
#    Then User navigates to Shared with me
#    Then User navigates to folder
#    Then User uploads assets into the folder
#    Then User invites user to collaborate folder
#    Then User logout from GroundX application
#    ####################################
#    Then User should be on GroundX login page
#    Then User should select user Type as "Login as an external partner or vendor"
#    Then User logged into GroundX application as "External User6"
#    Then User navigates to Shared with me
#    Then User navigates to shared folder
#    Then User download assets
#    Then User logout from GroundX application
#
#    Examples:
#      | Test Case Name                   |
#      | TC21_External user invite external user to existing locked folder |
#
#  Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User validates construction footage page
#    Then User navigates to workspaces
#    Then User selects workspace
#   	Then User copy items to folder
#   	Then User validates items
#    Then User logout from GroundX application
#
#    Examples:
#      | Test Case Name                   |
#      | TC32_Lock Folders - Copy lock folder to lock folder within the workspace	|
#      |	TC34_Lock Folders - Copy lock folder to lock folder in another the workspace	|
#
# Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User validates construction footage page
#    Then User navigates to workspaces
#    Then User navigates to folder
#    Then User selects workspace
#    Then User move items to folder
#    Then User logout from GroundX application
#
#    Examples:
#      | Test Case Name                   |
#      | TC36_Lock Folders - Move lock folder to lock folder within workspace	|
#      |	TC42_Lock Folders - Move lock folder to standard folder within workspace	|
#
#  Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User validates construction footage page
#    Then User navigates to workspaces
#    Then User navigates to folder
#    Then User selects workspace
#    Then User move items to folder
#    Then User logout from GroundX application
#
#    Examples:
#      | Test Case Name                   |
#      |	TC37_Lock Folders - Move lock assets to folder within the workspace	|
#
#  Scenario Outline: constructionFootage Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/WorkspacesTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User validates construction footage page
#    Then User navigates to workspaces
#    Then User selects workspace
#    Then User navigates to folder
#    Then User copy items to folder
#    Then User logout from GroundX application
#
#    Examples:
#      | Test Case Name                   |
#      |	TC33_Lock Folders - Copy lock assets to standard folder within the workspace	|
#      |	TC35_Lock Folders - Copy lock assets to standard folder in another the workspace	|