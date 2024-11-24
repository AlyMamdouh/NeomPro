#Author: marina.adel@neom.com

@workspaces
Feature: Settings Test Cases

  Background:
    Given User should be on GroundX login page

    @Skip
  Scenario Outline: Settings Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
    Then User logged into GroundX application as "Internal User"
    Then User go to settings page
    Then User go to list view
    Then User copy installation ID in "List_View"
#####
    Examples:
      | Test Case Name                   |
      | GC01_ GX-5880_UAT_List View_Check when user is trying to copy installation ID |
##
##
  @Skip
 Scenario Outline: Settings Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
    Then User logged into GroundX application as "Internal User"
    Then User go to settings page
    Then User go to list view
    Then User press on edit link "List_View"
###
    Examples:
      | Test Case Name                   |
      | GC03_GX-5880_UAT_List View_User is trying to Edit device |
##
##
  @Skip
  Scenario Outline: Settings Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
    Then User logged into GroundX application as "Internal User"
    Then User go to settings page
    Then User go to list view
    Then User press on delete link "List_View"
###
    Examples:
      | Test Case Name                   |
      | GC04_GX-5880_UAT_List View_check when user tries to delete device |
#
#

  @Skip
 Scenario Outline: Settings Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
    Then User logged into GroundX application as "Internal User"
    Then User go to settings page
    Then User go to list view
    Then User filter by device type
###
   Examples:
      | Test Case Name    |
      | GC05_GX-5880_UAT_List View_Try to filter with 360  |
      | GC06_GX-5880_UAT_List View_Try to filter with Drone  |
      | GC07_GX-5880_UAT_List View_Try to filter with Live  |
      | GC08_GX-5880_UAT_List View_Try to filter with Timelapse  |
      | GC09_GX-5880_UAT_List View_Try to filter with Underwater  |
      | GC10_GX-5880_UAT_List View_Try to filter with Weather  |
#

  @Skip
  Scenario Outline: Settings Test Cases
    Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
    Then User logged into GroundX application as "Internal User"
    Then User go to settings page
     Then User go to list view
    Then User filter by device status and type
    Then User hovering on device name
####
    Examples:
      | Test Case Name                   |
      | GC11_GX-5880_UAT_List_View_Try_to_hovering_for_online_devices   |
##
##
  Scenario Outline: Settings Test Cases
   Then User should select user Type as "Login with NEOM account"
    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
    Then User logged into GroundX application as "Internal User"
    Then User go to settings page
    Then User copy installation ID in "Grid_View"
####
    Examples:
      | Test Case Name                   |
      | GC12_GX-5880_UAT_Grid_View_Check when user is trying to copy installation ID   |
##
##
#     Scenario Outline: Settings Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User go to settings page
#    Then User press on edit link "Grid_View"
######
#    Examples:
#      | Test Case Name                   |
#      | GC13_GX-5880_UAT_Grid_View_User is trying to Edit device without filter |
##
##
#  Scenario Outline: Settings Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User go to settings page
#    Then User filter by device status
#    Then User press on edit link "Grid_View"
########
#    Examples:
#      | Test Case Name                   |
#      | GC14_GX-5880_UAT_Grid_View_User is trying to Edit device with status Online |
#      | GC15_GX-5880_UAT_Grid_View_User is trying to Edit device with status Offline |
#      | GC16_GX-5880_UAT_Grid_View_User is trying to Edit device with status Registered |
#      | GC17_GX-5880_UAT_Grid_View_User is trying to Edit device with status Decommissioned |
#####
##
##
#  Scenario Outline: Settings Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User go to settings page
#    Then User press on delete link "Grid_View"
######
#    Examples:
#      | Test Case Name                   |
#      | GC18_GX-5880_UAT_Grid View_check when user tries to delete device |
###
##
##
#  Scenario Outline: Settings Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User go to settings page
#    Then User filter by device status
#    Then User validate that delete is not available "Grid_View"
#   Then User press on delete link "Grid_View"
###
#    Examples:
#      | Test Case Name                   |
#      | BC01_GX-5880_UAT_Grid View_check_that_delete_is_not_exist_with_Online |
#      | BC02_GX-5880_UAT_Grid View_check_that_delete_is_not_exist_with Offline |
#      | BC03_GX-5880_UAT_Grid View_check_that_delete_is_not_exist_with_Decommissioned |
###
##
##  Scenario Outline: Settings Test Cases
##    Then User should select user Type as "Login with NEOM account"
##    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
##    Then User logged into GroundX application as "Internal User"
##    Then User go to settings page
##    Then User go to list view
##    Then User filter by device status
##    Then User validate that delete is not available "List_View"
##
###
##    Examples:
##      | Test Case Name                   |
##      | BC04_GX-5880_UAT_List_View_check_that_delete_is_not_exist_with_Online |
##     | BC05_GX-5880_UAT_List_View_check_that_delete_is_not_exist_with_Offline |
##     | BC06_GX-5880_UAT_List_View_check_that_delete_is_not_exist_with_Decommissioned |
##
#
#  Scenario Outline: Settings Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User go to settings page
#    Then User filter by device status
#    Then User validate the date is returned
###
######
#    Examples:
#      | Test Case Name                   |
#      | GC19_GX-5880_UAT_Grid View_check that offline devices displayed with date|
#      | GC24_GX-5880_UAT_Grid View_check that online devices displayed with date|
#      | GC25_GX-5880_UAT_Grid View_check that registered devices displayed with date|
#      | GC26_GX-5880_UAT_Grid View_check that Decommissioned devices displayed with date|
##
###
#
#   Scenario Outline: Settings Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User go to settings page
#    Then User filter by device status
#    Then User press on view button
#    Then Validate View Screen
######
#    Examples:
#      | Test Case Name                   |
#      | GC20_GX-5880_UAT_Grid View_press on view button for Online Devices|
#      | GC21_GX-5880_UAT_Grid View_press on view button for Offline Devices |
#      | GC22_GX-5880_UAT_Grid View_press on view button for Decommissioned Devices|
#
##

#    Scenario Outline: Settings Test Cases
#    Then User should select user Type as "Login with NEOM account"
#    Then User fetch test data for "<Test Case Name>" from "./src/main/resources/testData/SettingsTestCases.csv"
#    Then User logged into GroundX application as "Internal User"
#    Then User go to settings page
#    Then User filter by device status
#    Then Verify that view button is dimmed
######
#    Examples:
#      | Test Case Name                   |
#      | GC23_GX-5880_UAT_Grid View_Verify View button is dimmed with registered status|



# create test case for copy link
# create test case for download and add to favorite
  # create test case for moving between images by arrows
  # create test case for info icon and history