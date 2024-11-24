package ScryAIGroundX.com.qa.stepdefinitions.Settings;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import ScryAIGroundX.com.qa.pages.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.formula.atp.Switch;
import org.apache.velocity.runtime.directive.Break;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import ScryAIGroundX.com.qa.pages.GroundXDashboardPage;
import ScryAIGroundX.com.qa.pages.GroundXSettingsPage;
import ScryAIGroundX.com.qa.base.Base;
import ScryAIGroundX.com.qa.reports.Reports;
import ScryAIGroundX.com.qa.util.CSVFileReader;
import ScryAIGroundX.com.qa.util.PropertyReader;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@Listeners(Reports.class)
public class GroundXSettingsStepDefinitions extends Base{

    private GroundXLoginPage groundXLoginPage = new GroundXLoginPage(Base.getDriver());
    private GroundXConstructionFootagePage groundXConstructionFootagePage;
    String Actual_Result = "";
    private GroundXSettingsPage groundXSettingsPage;
    private GroundXDashboardPage groundXDashboardPage;
    CSVRecord testData;


    @Given("User should be on GroundX login page")
    public void groundX_LoginPage() {
        logger.info("Application launched successfully");
        String title = getTitle();
        Assert.assertEquals(title, "Ground X DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
    }

    @Then("User should select user Type as {string}")
    public void user_select_GroundX_UserType(String userType) throws InterruptedException, AWTException {
        groundXLoginPage.selectUserType(userType);
        logger.info(userType + " is selected successfully");
        String title = getTitle();
        Assert.assertEquals(title, "Sign in to your account", "GroundX application login page title is incorrect");
    }

    @Then("User fetch test data for {string} from {string}")
    public void user_fetch_test_data_from(String TestCaseName, String path) throws IOException {
        testData = CSVFileReader.readFromCsv(TestCaseName, path);
    }

    @Then("User logged into GroundX application as {string}")
    public void user_logged_into_GroundX(String user) throws InterruptedException {
        groundXDashboardPage = groundXLoginPage.loginAsInternalUser(user);
        logger.info("Internal user"+"User entered username, password and clicked on login");
        System.out.println("Internal User entered username, password and clicked on login");

    }

    @Then("User go to settings page")
    public void user_navigate_to_settings() throws IOException, InterruptedException {

        groundXSettingsPage = groundXLoginPage.navigateToSettings();
        logger.info("User navigated to workspaces");
        groundXSettingsPage.navigateToDevices();
        //Devices selected by default and grid view selected by default
        Thread.sleep(2000);
        takeScreenshot();
      //  boolean result = groundXSettingsPage.CheckDefaultSelection();
      //  Assert.assertTrue(result);
    }


    @Then("User go to list view")
    public void user_go_to_list_view() {
        groundXSettingsPage.ListView();
    }


    @Then("User copy installation ID in {string}")
    public void User_copy_installation_ID(String ViewType) throws IOException, InterruptedException {
        switch(ViewType) {
            case "List_View": {
                String ExpectedResult = groundXSettingsPage.GetFirstDeviceID_BeforeSearch(ViewType);
                groundXSettingsPage.CopyInstallationID("List_View");

                Thread.sleep(3000);
                groundXSettingsPage.Click_On_SearchText();
                PasteText();
                String ActualResult = groundXSettingsPage.GetFirstDeviceID_AfterSearch(ViewType);
                Assert.assertEquals(ActualResult, ExpectedResult);
                takeScreenshot();
                break;
            }
            case "Grid_View": {
                String ExpectedResult = groundXSettingsPage.GetFirstDeviceID_BeforeSearch(ViewType);
                groundXSettingsPage.CopyInstallationID("Grid");
                groundXSettingsPage.Click_On_SearchText();
                PasteText();
                String ActualResult = groundXSettingsPage.GetFirstDeviceID_AfterSearch(ViewType);
                //String ExpectedResult = groundXSettingsPage.GetFirstDeviceID_BeforeSearch();
                Assert.assertEquals(ActualResult, ExpectedResult);
                takeScreenshot();
                break;
            }

            default:
                System.out.println("some code for default");
        }
    }

    @Then("User press on edit link {string}")
    public void user_press_on_edit_link(String View) throws InterruptedException, IOException {
       if (View.contains( "Grid_View")) {
           String ExpectedResult = groundXSettingsPage.GetFirstDeviceID_BeforeSearch(View);
           String ActualResult = groundXSettingsPage.PressOnEditLink(View);
           takeScreenshot();
           Assert.assertEquals(ActualResult,": " +ExpectedResult);
           groundXSettingsPage.CloseEditPage();
       }
       else
       {
           String ActualResult = groundXSettingsPage.PressOnEditLink(View);
           takeScreenshot();
           String ExpectedResult = groundXSettingsPage.GetFirstDeviceID_BeforeSearch(View);
           Assert.assertEquals(ActualResult,": " +ExpectedResult);
           groundXSettingsPage.CloseEditPage();
       }

    }

    @Then("User press on delete link {string}")
    public void User_press_on_delete_link(String View) throws InterruptedException {
     //First filter by status registration
        if(View.contains("Grid_View")){
            groundXSettingsPage.FilterStatus("Registered");
            String ActualResult = groundXSettingsPage.PressOnDeleteLink(View);
            //String ViewType = "Grid_View";
            String DeviceName = groundXSettingsPage.GetFirstDeviceID_AfterSearch(View);
            String ExpectedResult = "Are you sure you want to delete \"" + DeviceName + "\"?";
            Assert.assertEquals(ActualResult, ExpectedResult);
        }
        else {
            groundXSettingsPage.FilterStatus("Registered");
            String ActualResult = groundXSettingsPage.PressOnDeleteLink(View);
            String ViewType = "List_View";
            String DeviceName = groundXSettingsPage.GetFirstDeviceID_AfterSearch(ViewType);
            String ExpectedResult = "Are you sure you want to delete \"" + DeviceName + "\"?";
            Assert.assertEquals(ActualResult, ExpectedResult);
        }
    }

    boolean Filter_results = false;
    @Then("User filter by device type")
    public void User_filter_by_device_type() throws Exception {
        String DeviceType = testData.get("DeviceType");
     //   String filterVal= testData.get(DeviceType);

//        String title = getTitle();
//        Assert.assertEquals(title, "Ground X DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
        groundXSettingsPage.FilterDeviceType(DeviceType);
        switch (DeviceType){
            case "360":
                Actual_Result = groundXSettingsPage.validateFilterResults();
                if(Actual_Result.startsWith("O")){
                    Filter_results = true;
                    // System.out.println("Drone devices returned correctly");
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                }
                else
                {
                    Filter_results = false;
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                    //System.out.println("Filter is not working");
                }
                break;
                //takeScreenshot();
            //
            case "Drone":
             Actual_Result = groundXSettingsPage.validateFilterResults();
             if(Actual_Result.startsWith("D")){
               //  System.out.println("Drone devices returned correctly");
                 Filter_results = true;
                 Assert.assertTrue(Filter_results);
                 takeScreenshot();
             }
             else
             {
                 Filter_results = false;
                 Assert.assertTrue(Filter_results);
                 takeScreenshot();
                // System.out.println("Filter is not working");
             }

             break;
            case "Live":
                 Actual_Result = groundXSettingsPage.validateFilterResults();
                if(Actual_Result.startsWith("L")){
                    //System.out.println("Drone devices returned correctly");
                    Filter_results = true;
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                }
                else
                {
                    Filter_results = false;

                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                   // System.out.println("Filter is not working");
                }


                break;
            case "TimeLapse":
                Actual_Result = groundXSettingsPage.validateFilterResults();
                if(Actual_Result.startsWith("T")){
                    Filter_results = true;
                   // System.out.println("Drone devices returned correctly");
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                }
                else
                {
                    Filter_results = false;
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                   // System.out.println("Filter is not working");
                }


                break;

            case "Underwater":
                Actual_Result = groundXSettingsPage.validateFilterResults();
                if(Actual_Result.startsWith("U")){
                    Filter_results = true;
                   // System.out.println("Drone devices returned correctly");
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                }
                else
                {
                    Filter_results = false;
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                    //System.out.println("Filter is not working");
                }


                break;

            case "Weather":
                Actual_Result = groundXSettingsPage.validateFilterResults();
                if(Actual_Result.startsWith("W")){
                    Filter_results = true;
                    //System.out.println("Drone devices returned correctly");
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                }
                else
                {
                    Filter_results = false;
                    Assert.assertTrue(Filter_results);
                    takeScreenshot();
                    //System.out.println("Filter is not working");
                }


                break;

            default:
                    // code block

        }
      // Assert.assertTrue(groundXSettingsPage.validateFilterResults());

    }

    @Then("User hovering on device name")
    public void User_hovering_on_device_name() throws Exception {
        boolean result = groundXSettingsPage.DeviceImageView();
        Assert.assertEquals( String.valueOf(result),"true");

    }

    @Then("User filter by device status and type")
    public void User_Filter_by_device_status_Type() throws Exception {
        String DeviceType = testData.get("DeviceType");
        String DeviceStatus = testData.get("DeviceStatus");
        groundXSettingsPage.FilterDeviceStatusAndType(DeviceType,DeviceStatus);
        String Expected_Result = "Online";
        Assert.assertEquals(groundXSettingsPage.validateFilterStatus(),Expected_Result,"Filter is not working");

    }

    @Then("User filter by device status")
    public void User_Filter_by_device_status() throws Exception {

        String DeviceStatus = testData.get("DeviceStatus");
        groundXSettingsPage.FilterStatus(DeviceStatus);
        //String Expected_Result = "Online";
      //  Assert.assertEquals(groundXSettingsPage.validateFilterStatus(),Expected_Result,"Filter is not working");

    }

    @Then("User validate that delete is not available {string}")
    public void User_validate_delete_option_availability(String View){

           groundXSettingsPage.ValidateDeleteOption(View);
    }


    @Then("User validate the date is returned")
    public void userValidateTheDate() throws IOException {
        String DeviceStatus = testData.get("DeviceStatus");
       boolean Actual_Result = groundXSettingsPage.ValidateDate(DeviceStatus);
       //Boolean result = Actual_Result.contains(" Offline Since ");
       Assert.assertTrue(Actual_Result);
       takeScreenshot();
    }

    @Then("Verify that view button is dimmed")
    public void verifyThatViewButtonIsDimmed() {
      boolean Actual_Result =   groundXSettingsPage.ValidateViewButton_Visibility();
      Assert.assertFalse(Actual_Result);
    }

    @Then("User press on view button")
    public void userPressOnViewButton() throws IOException {
        groundXSettingsPage.PressOnViewButton();
        takeScreenshot();
    }

    @Then("Validate View Screen")
    public void validateViewScreen() {
      boolean result =  groundXSettingsPage.ValidateViewScreen();
      Assert.assertTrue(result);

    }
}
