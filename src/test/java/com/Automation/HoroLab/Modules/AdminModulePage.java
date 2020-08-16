package com.Automation.HoroLab.Modules;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.CommonUtil;
import com.Automation.HoroLab.DriverManager;
import com.Automation.HoroLab.LogFileControl;
import com.Automation.HoroLab.Locators.Locator;

public class AdminModulePage extends Base{

	public static final String adminTabLink_xpath="//div[@class='mat-tab-label-content']/span[contains(text(),'Admin')]";//"//mat-icon[contains(text(),'apps')]/following::mat-icon[2]";
	public static final String locationLink_xpath="//mat-panel-title[contains(text(),'Location')]";
	public static final String state_Link_xpath="//span[contains(text(),'State')]";
	public static final String city_Link_xpath="//span[contains(text(),'City')]";
	public static final String area_Link_xpath="//span[contains(text(),'Area')]";
	public static final String branch_Link_xpath="//span[contains(text(),'Branch')]";
	public static final String addNew_Button_xpath="//mat-icon[contains(text(),'add')]";
	public static final String codeTextBox_xpath="//span[text()='Save']/preceding::input[3]";
	public static final String tinTextBox_xpath="//span[text()='Save']/preceding::input[2]";
	public static final String nameTextBox_xpath="//span[text()='Save']/preceding::input[1]";
	public static final String saveState_xpath="//span[text()='Save']";
	public static final String stateCancel_Button_xpath="//span[text()='Cancel']";
	public static final String errorMsgCodeTinLessThan2_xpath="//mat-error[contains(text(),'less than 2')]";
	public static final String errorMsgCodeTinMorethan2_xpath="//mat-error[contains(text(),'more than 2')]";
	public static final String validMsgCodeTinExact2Entry_xpath="//mat-hint[contains(text(),'2/2')]";
	public static final String errorMsgNameMoreThan100Char_xpath="//mat-error[contains(text(),'more than 100')]";
	public static final String validMsgNameUnder100_xpath="//mat-hint[contains(text(),'/100')]";
	public static final String isActiveSwitchCheckboxFirstRow_xpath="//mat-header-cell[contains(text(),'Active')]/following::div[1]";
	public static final String restoreSwitchCheckbox_xpath="//mat-header-cell[contains(text(),'Res')]/following::div[6]";
	public static final String editRecordFirstRow_xpath="(//mat-icon[contains(text(),'edit')])[1]";
	public static final String ViewTimeLineFirstRecord_xpath="(//mat-icon[contains(text(),'schedule')])[1]";
	public static final String deleteYes_xpath="//p[contains(text(),'Are you sure?')]/following::span[1]";
	public static final String nameFirstRow_xpath="(//mat-icon[contains(text(),'delete')])[1]/preceding::span[7]";
	public static final String errorMsgNameNonAlphabet_xpath="//mat-error[contains(text(),'Only alph')]";
	public static final String errorMsgSameState_xpath="//mat-error[text()='State with this name already exists']";
	public static final String errorAlreadyStateExists_xpath="//mat-error[contains(text(),'already exists')]";
	public static final String cityName_xpath ="//input[@placeholder='Name']";
	public static final String repairReason_xpath ="//input[@placeholder='ReRepair Reason']";
	public static final String repairCancellationReason_xpath ="//input[@placeholder='Repair Cancellation Reason']";
	public static final String replacementReason_xpath ="//input[@placeholder='Relacement Reason']";
	public static final String description_xpath ="//textarea[@placeholder='Description']";
	public static final String areaCode_xpath ="//input[@placeholder='Code']";
	public static final String hsn_xpath ="//input[@placeholder='HSN']";
	public static final String gst_xpath ="//input[@placeholder='GST Rate']";
	public static final String addressLine_xpath ="//input[@placeholder='Address Line 1']";
	public static final String pinCode_xpath ="//input[@placeholder='Pin Code']";
	public static final String statedropdown_xpath ="//span[contains(@class,'mat-select-placeholder')]";
	public static final String emptyCodeErrorMsg_xpath="(//mat-error[@class='mat-error'])[1]";
	public static final String deleteRecordFirstRow_xpath="(//mat-icon[contains(text(),'delete')])[1]";
	public static final String clearIcon_xpath="//mat-icon[contains(text(),'close')]";
	public static final String isActive_xpath="(//*[contains(@id,'mat-slide-toggle')])[1]";
	public static final String isActive2_xpath="(//*[contains(@id,'mat-slide-toggle')])[5]";
	public static final String delete_popUpMessage_xpath="(//*[text()='Item Deleted.'])[2]";
	public static final String deleteStateYesUndo_xpath="(//*[text()='Item Deleted.'])[2]/following::button[1]";
	public static final String deleteNoButton_xpath="//span[text()='No']";
	public static final String viewTimeLines_xpath="(//mat-icon[contains(text(),'schedule')])[1]";
	public static final String searchButton_xpath="//mat-icon[text()='search']";
	public static final String searchLocationTextBox_xpath="//input[@placeholder='Search']";
	public static final String errormsg_xpath="//mat-error[contains(@id,'mat-error')]";




	public static void navigateToSubmodule(String module,String submodule){
		try {  
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, adminTabLink_xpath);
			seleniumUtils.Click(Locator.XPATH, adminTabLink_xpath, "Admin", "Admin Tab");
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, "//mat-panel-title[contains(text(),'"+module+"')]");
			Thread.sleep(1000);
			if(!seleniumUtils.GetAttribute(Locator.XPATH, "//mat-panel-title[contains(text(),'"+module+"')]/../..", "class").contains("expanded")) {
				seleniumUtils.Click(Locator.XPATH, "//mat-panel-title[contains(text(),'"+module+"')]", "Admin", module);
				seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, "//span[contains(text(),'"+submodule+"')]");
				seleniumUtils.waitForPageLoad();
			}
			seleniumUtils.Click(Locator.XPATH, "//span[contains(text(),'"+submodule+"')]", "Admin", submodule);
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e) {
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}



	public static void clickOnAdd(){
		try {  
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, addNew_Button_xpath);
			seleniumUtils.Click(Locator.XPATH, addNew_Button_xpath, "Admin", "Add");
		}
		catch(Exception e) {
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void addState(String stateName){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, codeTextBox_xpath, "AZ", "State", "Code");
			seleniumUtils.SendKeys(Locator.XPATH, tinTextBox_xpath, "TN", "State", "tin");
			seleniumUtils.SendKeys(Locator.XPATH, nameTextBox_xpath, stateName, "State", "State Name");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, "State", "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void addReRepair(String repairReason){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH,repairReason_xpath , repairReason, "Re Repair", "Re Repair Reason");
			seleniumUtils.SendKeys(Locator.XPATH, description_xpath, "Automation Test", "Re Repair", "Description");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, "Re Repair", "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void addRepairCancellation(String repairCancellationReason){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH,repairCancellationReason_xpath , repairCancellationReason, "Repair Cancellation", "Repair Cancellation Reason");
			seleniumUtils.SendKeys(Locator.XPATH, description_xpath, "Automation Test", "Repair Cancellation", "Description");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, "Repair Cancellation", "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void addreplacement(String replacementReason){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH,replacementReason_xpath , replacementReason, "Replacement", "Replacement Reason");
			seleniumUtils.SendKeys(Locator.XPATH, description_xpath, "Automation Test", "Replacement", "Description");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, "Replacement", "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void addCity(String name){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, cityName_xpath, name, "Add City", "Name");
			Thread.sleep(1000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])", "1", DriverManager.getDriver().getTitle(), "State");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, DriverManager.getDriver().getTitle(), "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void addArea(String name){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, cityName_xpath, name, "Add Area", "Name");
			Thread.sleep(1000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])[1]", "2", DriverManager.getDriver().getTitle(), "City");
			Thread.sleep(2000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])[2]", "1", DriverManager.getDriver().getTitle(), "State");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, DriverManager.getDriver().getTitle(), "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void addBranch(String code){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, cityName_xpath, "AutoTest", "Add Branch", "Name");
			seleniumUtils.SendKeys(Locator.XPATH, areaCode_xpath, code, "Add Branch", "Code");
			Thread.sleep(1000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])[1]", "BRANCH", DriverManager.getDriver().getTitle(), "Office Type");
			seleniumUtils.SendKeys(Locator.XPATH, addressLine_xpath, "Marathalli", "Add Branch", "Adress Line1");
			Thread.sleep(1000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])[2]", "1", DriverManager.getDriver().getTitle(), "State");
			Thread.sleep(2000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])[3]", "1", DriverManager.getDriver().getTitle(), "City");
			Thread.sleep(1000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])[4]", "1", DriverManager.getDriver().getTitle(), "Area");
			seleniumUtils.SendKeys(Locator.XPATH, pinCode_xpath, "560037", "Add Branch", "Pin Code");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, "Branch", "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void addRepairInfoSubmodules(String name,String code){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, areaCode_xpath, code, DriverManager.getDriver().getTitle(), "Code");
			seleniumUtils.SendKeys(Locator.XPATH, cityName_xpath, name, DriverManager.getDriver().getTitle(), "Name");
			if(seleniumUtils.Size(Locator.XPATH, description_xpath)>0) {
				seleniumUtils.SendKeys(Locator.XPATH, description_xpath, "Auto Description", DriverManager.getDriver().getTitle(), "Description");
			}
			Thread.sleep(1000);
			int i=seleniumUtils.Size(Locator.XPATH, "(//span[contains(@class,'mat-select')])");
			for(int j=1;j<=i;j++) {
				String elementName=seleniumUtils.GetText(Locator.XPATH, "(//span[contains(@class,'mat-select')])["+j+"]/following::mat-label[1]");
				seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])["+j+"]", "1", DriverManager.getDriver().getTitle(), elementName);
				Thread.sleep(2000);
			}
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, DriverManager.getDriver().getTitle(), "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	
	public static void addAccessories(String name,String prodCategory){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, cityName_xpath, name, DriverManager.getDriver().getTitle(), "Name");
			Thread.sleep(1000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "(//span[contains(@class,'mat-select')])", prodCategory.toUpperCase(), DriverManager.getDriver().getTitle(), "Product Category");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, DriverManager.getDriver().getTitle(), "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void addProductCategory(String name,String code,String hsn,String gst){
		try{	
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, areaCode_xpath, code, DriverManager.getDriver().getTitle(), "Code");
			seleniumUtils.SendKeys(Locator.XPATH, cityName_xpath, name, DriverManager.getDriver().getTitle(), "Name");
			seleniumUtils.SendKeys(Locator.XPATH, hsn_xpath, hsn, DriverManager.getDriver().getTitle(), "HSN");
			seleniumUtils.SendKeys(Locator.XPATH, gst_xpath, gst, DriverManager.getDriver().getTitle(), "GST Rate");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, DriverManager.getDriver().getTitle(), "Save");
			seleniumUtils.waitForPageLoad();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	
	public static void verifyCreatedName(String name,String submodule){

		try{
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, addNew_Button_xpath);
			if(seleniumUtils.Size(Locator.XPATH, "//span[text()=' "+name.toUpperCase()+" ']")>0) {
				LogFileControl.logPass(submodule, "Added "+submodule+" is displaying successfully");
			}else {
				LogFileControl.logFailwithScreenCapture(submodule, "Added "+submodule+" is not displaying successfully");
			}
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void verifytimeline(String reason,String userName){

		try{
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, addNew_Button_xpath);
			seleniumUtils.Click(Locator.XPATH, "(//span[text()=' "+reason.toUpperCase()+" ']/following::mat-icon[text()='schedule'])[1]", DriverManager.getDriver().getTitle(), "View TimeLine");
			seleniumUtils.waitForPageLoad();
			if(seleniumUtils.Size(Locator.TAGNAME, "mat-dialog-container")>0) {
				LogFileControl.logPass(DriverManager.getDriver().getTitle(), "TimeLine PopUp is displaying");
				if(seleniumUtils.Size(Locator.XPATH, "//td[text()='Created']")>0
						&& seleniumUtils.Size(Locator.XPATH, "//small[text()='By "+userName.toUpperCase()+"']")>0) {
					CommonUtil.escPress();
					LogFileControl.logPass(DriverManager.getDriver().getTitle(), "Create By is displaying correctly");
				}else {
					CommonUtil.escPress();
					LogFileControl.logFailwithScreenCapture(DriverManager.getDriver().getTitle(), "Create By is not displaying correctly");
				}
			}else {
				LogFileControl.logFailwithScreenCapture(DriverManager.getDriver().getTitle(), "TimeLine PopUp is not displaying");
			}
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void deleteAndVerify(String reason){

		try{
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, addNew_Button_xpath);
			seleniumUtils.Click(Locator.XPATH, "(//span[text()=' "+reason.toUpperCase()+" ']/following::mat-icon[text()='delete'])[1]", DriverManager.getDriver().getTitle(), "Delete");
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, "//button//span[text()='Yes']");
			seleniumUtils.Click(Locator.XPATH, "//button//span[text()='Yes']", DriverManager.getDriver().getTitle(), "Yes");
			seleniumUtils.waitForPageLoad();
			if(seleniumUtils.Size(Locator.XPATH, "//span[text()=' "+reason.toUpperCase()+" ']")>0) {
				LogFileControl.logPass(DriverManager.getDriver().getTitle(), "Deleted one is not displaying in the list");
			}else {
				LogFileControl.logFailwithScreenCapture(DriverManager.getDriver().getTitle(), "Deleted one is still displaying in the list");
			}
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void edit(String reason){

		try{
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, addNew_Button_xpath);
			seleniumUtils.Click(Locator.XPATH, "(//span[text()=' "+reason.toUpperCase()+" ']/following::mat-icon[text()='edit'])[1]", DriverManager.getDriver().getTitle(), "Edit");
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			if(seleniumUtils.Size(Locator.XPATH, description_xpath)>0)
				seleniumUtils.SendKeys(Locator.XPATH, description_xpath, "Auto Edit", DriverManager.getDriver().getTitle(), "Description");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, DriverManager.getDriver().getTitle(), "Save");
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, addNew_Button_xpath);
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	
	public static void editprodandVerify(String oldName,String newName){

		try{
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, addNew_Button_xpath);
			seleniumUtils.Click(Locator.XPATH, "(//span[text()=' "+oldName.toUpperCase()+" ']/following::mat-icon[text()='edit'])[1]", DriverManager.getDriver().getTitle(), "Edit");
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, saveState_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, cityName_xpath, newName, DriverManager.getDriver().getTitle(), "Name");
			seleniumUtils.Click(Locator.XPATH, saveState_xpath, DriverManager.getDriver().getTitle(), "Save");
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, addNew_Button_xpath);
			if(seleniumUtils.Size(Locator.XPATH, "//span[text()=' "+oldName.toUpperCase()+" ']")>0) {
				LogFileControl.logFailwithScreenCapture(DriverManager.getDriver().getTitle(), "After edit Old Name is still displaying in the list");
			}else {
				LogFileControl.logPass(DriverManager.getDriver().getTitle(), "After edit Old Name is not displaying in the list");
			}
			if(seleniumUtils.Size(Locator.XPATH, "//span[text()=' "+newName.toUpperCase()+" ']")>0) {
				LogFileControl.logPass(DriverManager.getDriver().getTitle(), "After edit New Name is displaying in the list");
			}else {
				LogFileControl.logFailwithScreenCapture(DriverManager.getDriver().getTitle(), "After edit New Name is not displaying in the list");
			}
			
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void verifyErrorOnSameName(){

		try{
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, errormsg_xpath);
			String error = seleniumUtils.GetText(Locator.XPATH, errormsg_xpath);
			if(seleniumUtils.Size(Locator.XPATH, errormsg_xpath)>0) {
				seleniumUtils.Click(Locator.XPATH, stateCancel_Button_xpath, DriverManager.getDriver().getTitle(), "Cancel");
				seleniumUtils.waitForPageLoad();
				LogFileControl.logPass("State", "Already exist error message is displaying correctly, Error displayed as : "+error);
			}else {
				LogFileControl.logFailwithScreenCapture("State", "Already exist error message is not displaying correctly, Error displayed as : "+error);
			}
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

}
