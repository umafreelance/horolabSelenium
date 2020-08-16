package com.Automation.HoroLab.Modules;

import org.openqa.selenium.By;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.CommonUtil;
import com.Automation.HoroLab.DriverManager;
import com.Automation.HoroLab.LogFileControl;
import com.Automation.HoroLab.TestCases.RepairModuleTestCases;
import com.Automation.HoroLab.Locators.Locator;

public class RepairPage extends Base {

	public static final String repairTabLink_xpath="//*[@role='img']/following-sibling::span[contains(text(),' Repair')]";
	public static final String serviceRequestLink_xpath="//button[text()='Service Record']/following::span[2]";
	public static final String closebutton_xpath="//span[text()='Close']";
	public static final String ServiceReq_xpath="//span[text()='Service Record No']/following::span[1]";//value
	public static final String custname_xpath="//span[text()='Customer Name']/following::span[1]";
	public static final String expectedDate_xpath="//span[text()='Expected Date of Delivery']/following::span[1]";
	public static final String serviceRequestRadio_xpath="//button[contains(text(),'Technician')]/following::div[9]";
	public static final String technitian_select_xpath="//button[text()='Technician']/following::mat-select[1]";
	public static final String searchButton_xpath="//mat-icon[contains(text(),'search')]";
	public static final String searchfield_Xpath="//input[@placeholder='Search']";
	public static final String serviceRecordSelectRadio_xpath="//button[text()='Service Record']/following::mat-radio-button";
	public static final String pendingObservation_xpath="//span[contains(text(),'Pending Observation')]";
	public static final String viewTimeLine_xpath="//button[contains(text(),'Warranty')]/following::mat-icon[1]";
	public static final String timeline_popup_xpath="//h4[contains(text(),'Timelines')]/following::p";
	public static final String observe_xpath="//span[text()='Observe']";
	
	
	
	public static void observClick(){
		try{
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, observe_xpath);
			seleniumUtils.Click(Locator.XPATH, observe_xpath, "Repair Tab", "Observ");
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	
	public static void pendingObservationClick(){
		try{
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, pendingObservation_xpath);
			seleniumUtils.Click(Locator.XPATH, pendingObservation_xpath, "Repair Tab", "Pending Observation");
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void viewTimeLineClick(){
		try{
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, viewTimeLine_xpath);
			seleniumUtils.Click(Locator.XPATH, viewTimeLine_xpath, "Repair Tab", "View Time Line");
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, timeline_popup_xpath);
			if(seleniumUtils.IsDisplayed(Locator.XPATH, timeline_popup_xpath)) {
				LogFileControl.logPass("TimeLine", seleniumUtils.GetText(Locator.XPATH, timeline_popup_xpath));
			}else {
				LogFileControl.logFailwithScreenCapture("TimeLine", "TimeLine not found");
			}
			CommonUtil.escPress();
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}


	public static void closeButtonClick(){
		try{
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, closebutton_xpath);
			seleniumUtils.Click(Locator.XPATH, closebutton_xpath, "Repair Tab", "Close");
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void repairTabClick(){
		try{
			seleniumUtils.waitForPageLoad();
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, repairTabLink_xpath);
			seleniumUtils.Click(Locator.XPATH, repairTabLink_xpath, "Repair Tab", "Repair");
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void searchButtonClick(){
		try{
			seleniumUtils.waitForPageLoad();
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, searchButton_xpath);
			seleniumUtils.Click(Locator.XPATH, searchButton_xpath, "Repair", "Search Button");

		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void serviceRecordSearch(){
		try{
			String serviceno = getPropertyData("Service No");
			seleniumUtils.waitForPageLoad();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, searchfield_Xpath);
			seleniumUtils.SendKeys(Locator.XPATH, searchfield_Xpath, serviceno , "Repair", "Service No");	
			seleniumUtils.waitForPageLoad();
			if(seleniumUtils.Size(Locator.XPATH, "//span[text()='"+serviceno+"']")>0) {
				LogFileControl.logPass("Service Reord Search", "Service Record Displayed");
			}else {
				LogFileControl.logFail("Service Reord Search", "Service Record is not Displayed");
			}
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void serviceRecordClick(){
		try{
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, serviceRequestLink_xpath);
			seleniumUtils.Click(Locator.XPATH, serviceRequestLink_xpath, "Repair", "Service Record Number");
			Thread.sleep(7000);
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
//	public static void serviceRecordRepairClick(){
//		try{
//			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, "//button[text()='Warranty']/following::span[2]");
//			seleniumUtils.Click(Locator.XPATH, "//button[text()='Warranty']/following::span[2]", "Repair", "Service Record Number");
//			Thread.sleep(7000);
//		}
//		catch(Exception e){
//			System.out.println(e);
//			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
//		}
//	}
	public static void serviceRecordValidation(){
		try{
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, closebutton_xpath);
			String serviceReqNum = seleniumUtils.GetText(Locator.XPATH, ServiceReq_xpath);
			String customerName = seleniumUtils.GetText(Locator.XPATH, custname_xpath);
			String expectedDate = seleniumUtils.GetText(Locator.XPATH, expectedDate_xpath);
			//			String custname = getPropertyData("Service No");
			//			String customerName = getPropertyData("Customer Name");
			//			String Date = getPropertyData("Future Date");
			if(getPropertyData("Service No").contains(serviceReqNum)) {
				LogFileControl.logPass("The Service request number field has filled in Receive is Displaying Successfully", serviceReqNum);
			}else {
				LogFileControl.logFailwithScreenCapture("The Service request number", "Not Verified");
			}
			if(getPropertyData("Customer Name").contains(customerName)) {
				LogFileControl.logPass("The Customer Name field has filled in Receive is Displaying Successfully", customerName);
			}else {
				LogFileControl.logFailwithScreenCapture("Customer Name", "Not Verified");
			}
			if(getPropertyData("Future Date").contains("2020")) {
				LogFileControl.logPass("Future Date field has filled in Receive is Displaying Successfully", expectedDate);
			}else {
				LogFileControl.logFailwithScreenCapture("Future Date", "Not Verified");
			}	
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void assignTechnician(){
		try{
			seleniumUtils.DropDownSelect(Locator.XPATH, "//button[contains(text(),'Technician')]/following::mat-select[1]", "SANGEETA", "Repair", "Technician");
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, "//span[text()='Assign']");
			seleniumUtils.Click(Locator.XPATH, "//span[text()='Assign']", "Repair", "Assign");
			seleniumUtils.waitForPageLoad();
			Thread.sleep(2000);
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void testCase01() {
		try {
			repairTabClick();
			searchButtonClick();
			serviceRecordSearch();
			serviceRecordClick();
			serviceRecordValidation();
			closeButtonClick();
		}catch (Exception e) {
			// TODO: handle exception
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void serviceRadioClick() {
		try {
			seleniumUtils.waitForPageLoad();
			String serviceNo=getPropertyData("Service No");
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, "//span[text()='"+serviceNo+"']/preceding::label[@class='mat-radio-label']");
			seleniumUtils.Click(Locator.XPATH, "//span[text()='"+serviceNo+"']/preceding::label[@class='mat-radio-label']", "", "Radio Button");
//			seleniumUtils.MoveToElement(Locator.XPATH, "//span[text()='"+serviceNo+"']/preceding::label[@class='mat-radio-label']");
//			DriverManager.getDriver().findElement(By.xpath("//span[text()='"+serviceNo+"']/preceding::label[@class='mat-radio-label']")).click();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testCase02() {
		try {
			serviceRadioClick();
			assignTechnician();
			TechSheetPage.navigateToTechSheet();
			TechSheetPage.serviceRecordSearch();
			serviceRecordValidation();
		}catch (Exception e) {
			// TODO: handle exception
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	
	public static void testCase03() {
		try {
			pendingObservationClick();
			searchButtonClick();
			serviceRecordSearch();
			viewTimeLineClick();
			
			serviceRecordClick();
			serviceRecordValidation();
		}catch (Exception e) {
			// TODO: handle exception
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void testCase04() {
		try {
			closeButtonClick();
			serviceRadioClick();
			observClick();
			PendingObservationPage.dateEnter();
			PendingObservationPage.problemDetailEnter();
			PendingObservationPage.save();
			PendingObservationPage.pendingforRepairClick();
		}catch (Exception e) {
			// TODO: handle exception
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void testCase05() {
		try {
			serviceRadioClick();
			PendingForRepairPage.RepairButtonClick();
			PendingForRepairPage.completionDateEnter();
			PendingObservationPage.save();
			PendingForRepairPage.verifyServiceRecordAfterRepaired();
			
		}catch (Exception e) {
			// TODO: handle exception
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void testCase06FirstAssign() {
		try {
			ReceiveModulePage.clickReceive();
			ReceiveModulePage.searchButtonClick();
			ReceiveModulePage.keywordSearch("Uma Sasmal");
			ReceiveModulePage.selectCustomerClickReceive();
			ReceiveModulePage.receiveFormFill();
			repairTabClick();
			searchButtonClick();
			serviceRecordSearch();
			serviceRadioClick();
			assignTechnician();
//			LoginPage.logOut();
//			LoginPage.logIn("sangeeta", "sangeeta123");
//			repairTabClick();
//			pendingObservationClick();
//			searchButtonClick();
//			serviceRecordSearch();
//			PendingObservationPage.dateEnter();
//			PendingObservationPage.reAssignproblemDetailEnter();
//			PendingObservationPage.save();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
