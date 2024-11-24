package ScryAIGroundX.com.qa.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ScryAIGroundX.com.qa.base.Base;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class GroundXSettingsPage extends Base{




    private WebDriver driver;


    @FindBy(xpath = "/html/body/app-root/main/app-settings/section/section/div[2]/div/div[1]/app-setting-navigation/div[2]/ul/li[1]/div[2]/ul/a[1]/li")
    WebElement Devices;

    @FindBy(xpath = "")
    WebElement icon;

   // @FindBy(xpath = "//*[@id=\"more-options-menu\"]")
    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[4]/table/tr[3]/td[8]/img")
    WebElement DeleteDeviceBtn_List;

    @FindBy(xpath = "//*[@id=\"offline-date-since\"]/p[1]")
    WebElement StatusDate;

    @FindBy(xpath = "//*[@id=\"btn-view\"]")
    WebElement View_btn;

    @FindBy(xpath = "//*[@id=\"delete-icon\"]")
    WebElement  DeleteDeviceBtn_Grid;

    @FindBy(xpath = "//*[@id=\"more-options-menu\"]")
    WebElement GridOptions;
    //*[@id="child"]/app-device-settings/div/div[4]/div/app-device-grid-view/app-device-regions[1]/section/div/app-device-card[1]/section/div[2]/div[1]/span
//*[@id="child"]/app-device-settings/div/div[4]/div/app-device-grid-view/app-device-regions[1]/section/div/app-device-card[1]/section/div[2]/div[1]/img[2]
    @FindBy(xpath = "//*[@id=\"edit-icon\"]")
    WebElement EditDeviceLink_Grid;
    //*[@id="child"]/app-device-settings/div/div[4]/div/app-device-grid-view/app-device-regions[1]/section/div/app-device-card[1]/section/div[2]/div[1]/img[2]

    @FindBy(xpath = "//*[@id=\"navbarDropdown\"]/div/div/div[1]")
    WebElement DeviceStatus;

    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[4]/table/tr[2]/td[7]")
    WebElement EditDeviceLink_List;
    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[4]/table/tr[2]/td[2]/div/div[1]")
    WebElement FirstDeviceID_List;

    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[4]/div/app-device-grid-view/app-device-regions/section/div/app-device-card[1]/section/div[2]/div[1]/div[1]/h5")
    WebElement FirstDeviceID_Grid;
    //*[@id="child"]/app-device-settings/div/div[4]/div/app-device-grid-view/app-device-regions[1]/section/div/app-device-card[1]/section/div[2]/div[1]/h5

    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[2]/span/input")
    WebElement DeviceSearch;

    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[4]/table/tr[2]/td[2]/div/div[1]")
    WebElement FilterResults;

    @FindBy(xpath = "//*[@id='child']/app-device-settings/div/div[4]/table/tr[2]/td[3]/div")
    WebElement CopyButton;

    @FindBy(xpath = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-asset-popup/section/footer/div[1]/div/span")
    WebElement ImageWorkspace;

    @FindBy(xpath = "//*[@id=\"copy-btn\"]")
    WebElement CopyButton_Grid;
    @FindBy(xpath = "//*[@id='modal-component']/div/div/app-create-device-modal/div/h3/span")
    WebElement DeviceName_EditPopup;

    @FindBy(xpath = "//*[@id='modal-component']/div/div/app-create-device-modal/div/h3/button")
    WebElement CloseEditPopup;

    @FindBy(xpath = "//div[text()='Status']/following-sibling::div/input")
    WebElement StatusDropdown;

    @FindBy(xpath = "//div[text()='Device type']/following-sibling::div/input")
    WebElement DeviceTypeDropdown;

    @FindBy(xpath = "//div[text()='Status']/following-sibling::div/input")
    WebElement DeviceStatusDropdown;

    @FindBy(xpath = "//*[@class='deleteBlock break-line-deleted']")
    WebElement DeleteMsgText_List;

    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[4]/div/app-device-grid-view/app-device-regions[1]/section/div/app-device-card[1]/section/div[2]/div[1]/app-delete-popup/section/p")
    WebElement DeleteMsgText_Grid;

    //*[@id="child"]/app-device-settings/div/div[4]/div/app-device-grid-view/app-device-regions[1]/section/div/app-device-card[1]/section/div[2]/div[1]/app-delete-popup/section/p
    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[2]/div/img[2]")
    WebElement ListView;
    @FindBy(xpath = "//*[@id=\"child\"]/app-device-settings/div/div[4]/table/tr[2]/td[2]/div/div[2]")
    WebElement SliderImage;

    @FindBy(xpath = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-asset-popup/section/header/div[1]/div[1]")
    WebElement Classification;

    public GroundXSettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToDevices() throws InterruptedException {
        Thread.sleep(6000);
       Devices.click();

    }

    public boolean ValidateDate(String DeviceStatus)
    {

        if(StatusDate.isDisplayed()){
            if(StatusDate.getText().contains(DeviceStatus + " " + "Since" )){
             //   if(StatusDate.getText().contains("test" )){
                return true;
            }
            else
            {
                return false;

            }

        }
        else
        {
            return false;
        }

    }

    public  boolean CheckDefaultSelection(){
        return icon.isEnabled();
    }
    static String currentDir = System.getProperty("user.dir");
    public  void success() throws IOException {
        takeScreenshot();
    }

    public void CopyInstallationID(String Type) throws InterruptedException {
        if(Type.contains("List_View")) {
            Thread.sleep(2000);
            waitUntilElementClickable(CopyButton);
            CopyButton.click();
        }
        else{
            Thread.sleep(2000);
            waitUntilElementClickable(CopyButton_Grid);
            CopyButton_Grid.click();
        }
    }

    public void PressOnViewButton(){
        View_btn.click();
    }
    public boolean ValidateViewScreen(){
      boolean classification_Is_Exist = Classification.isDisplayed();
    //  boolean Date_Is_Exist = ImageDate.isDisplayed();
   //   boolean Time_Is_Exist = ImageTime.isDisplayed();
      boolean Worksapce_Name_Is_Exist = ImageWorkspace.isDisplayed();
        if((classification_Is_Exist == true)  && (Worksapce_Name_Is_Exist == true)) {
            return true;
        }
        else {
            return false;
        }
     //   }
    }

    public void Click_On_SearchText(){
        DeviceSearch.click();
    }

    public String GetFirstDeviceID_AfterSearch(String ViewType){
        if (ViewType.contains("List_View")){
            return FirstDeviceID_List.getText();
        }
        else
        {
            return FirstDeviceID_Grid.getText();
        }

    }

    public String GetFirstDeviceID_BeforeSearch(String ViewType){
        if (ViewType.contains( "List_View")){
            return FirstDeviceID_List.getText();
        }
        else
        {
            return FirstDeviceID_Grid.getText();
        }

    }



    public String PressOnEditLink(String ViewType) throws InterruptedException {
        if(ViewType.contains("Grid_View")){
            Thread.sleep(10000);
            GridOptions.click();
            EditDeviceLink_Grid.click();
            return DeviceName_EditPopup.getText();
        }
        else {
            Thread.sleep(10000);
            EditDeviceLink_List.click();
            return DeviceName_EditPopup.getText();
        }
    }

    public void CloseEditPage(){
        CloseEditPopup.click();
    }

    public String PressOnDeleteLink(String View) throws InterruptedException {
        if(View.contains("List_View")) {
            DeleteDeviceBtn_List.click();
            return DeleteMsgText_List.getText();
        }
        else
        {
            //Thread.sleep(1000);
            GridOptions.click();
            Thread.sleep(1000);
            DeleteDeviceBtn_Grid.click();
            Thread.sleep(1000);
            return DeleteMsgText_Grid.getText();
        }
    }

    public void ValidateDeleteOption(String View){
        if(View.contains("Grid_View")) {
            GridOptions.click();
            //List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"more-options-menu\"]"));

            List<WebElement> results = driver.findElements(By.xpath("//div[@class=\"more-options-menu ng-star-inserted\"]/div"));
            int size = results.size();
            //System.out.println(" First item"+ results.get(0).getText());
           // System.out.println(" Seocnd item"+ results.get(1).getText());
            Assert.assertEquals(size,1);
        }
        else
        {
            boolean Visible = DeleteDeviceBtn_List.isDisplayed();
            Assert.assertFalse(Visible);
        }
    }

    public void FilterStatus(String status){
        StatusDropdown.sendKeys(status);
        WebElement selectStatus = driver.findElement(By.xpath("//div[@role='option']/span[text()=' " + status + " ']"));
        selectStatus.click();


       // selectByText(StatusDropdown,status);
    }

    public void FilterDeviceType(String DeviceType){
        DeviceTypeDropdown.sendKeys(DeviceType);
        WebElement selectDeviceType = driver.findElement(By.xpath("//div[@role='option']/span[text()=' " + DeviceType + " ']"));
        selectDeviceType.click();
        // selectByText(StatusDropdown,status);
    }

    public void ListView(){
        ListView.click();
    }

    public void FilterDeviceStatusAndType(String DeviceType , String DeviceStatus){

        DeviceTypeDropdown.sendKeys(DeviceType);
        WebElement selectDeviceType = driver.findElement(By.xpath("//div[@role='option']/span[text()=' " + DeviceType + " ']"));
        selectDeviceType.click();
        DeviceStatusDropdown.sendKeys(DeviceStatus);
        WebElement selectStatusType = driver.findElement(By.xpath("//div[@role='option']/span[text()=' " + DeviceStatus + " ']"));
        selectStatusType.click();
        // selectByText(StatusDropdown,status);
    }

//    public void FilterDeviceStatus(String DeviceStatus){
//
//       // DeviceTypeDropdown.sendKeys(DeviceType);
//       // WebElement selectDeviceType = driver.findElement(By.xpath("//div[@role='option']/span[text()=' " + DeviceType + " ']"));
//       // selectDeviceType.click();
//        DeviceStatusDropdown.sendKeys(DeviceStatus);
//        WebElement selectStatusType = driver.findElement(By.xpath("//div[@role='option']/span[text()=' " + DeviceStatus + " ']"));
//        selectStatusType.click();
//        // selectByText(StatusDropdown,status);
//    }

    public String validateFilterResults() throws Exception {
        Thread.sleep(5000);

        //boolean x = FilterResults.isDisplayed();
        String x = FilterResults.getText();
       // return FilterResults.isDisplayed();
        return x;
    }

    public String validateFilterStatus() throws Exception {
        Thread.sleep(5000);

        //boolean x = FilterResults.isDisplayed();
        String DeviceStatusText = DeviceStatus.getText();
        // return FilterResults.isDisplayed();
        return DeviceStatusText;
    }

    public boolean DeviceImageView() throws InterruptedException {
       String ViewType = "List_View";
        String DeviceName = GetFirstDeviceID_AfterSearch(ViewType);
        if (DeviceName != ""){
            mouseHoverOnElement(FirstDeviceID_List);
            Thread.sleep(5000);
            try{
                waitVisible(SliderImage);
                boolean ImageAvailable = SliderImage.isDisplayed();
                return ImageAvailable;
            }
            catch (Exception e){
                return false;
            }

        }
        return false;

    }
    boolean result;
    public boolean ValidateViewButton_Visibility(){
        List<WebElement> AllViewButtons = driver.findElements(By.xpath("//*[@id=\"btn-view\"]"));
        for(int i = 0; i< AllViewButtons.size(); i++){
            if(AllViewButtons.get(i).isEnabled()){
                 result = true;
            }
            else
            {
                result = false;
            }
        }
        return result;
    }


}
