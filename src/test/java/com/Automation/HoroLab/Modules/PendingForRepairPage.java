package com.Automation.HoroLab.Modules;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.CommonUtil;
import com.Automation.HoroLab.LogFileControl;
import com.Automation.HoroLab.Locators.Locator;

public class PendingForRepairPage extends Base {

	public static final String repairButton_xpath="//span[contains(text(),'ReObserve')]/preceding::button[1]";
	public static final String date_xpath="//input[@placeholder='Repair Completion Date']";
	public static final String observationOutcome_xpath="//mat-icon[contains(text(),'save')]/preceding::mat-select[1]";
	public static final String reObserve_xpath="//span[text()='ReObserve']";

	
	
	
	public static void reObserveButtonClick(){
		try{
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, reObserve_xpath);
			seleniumUtils.Click(Locator.XPATH, reObserve_xpath, "Pending For Repair", "Re Observe");
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	
	public static void RepairButtonClick(){
		try{
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, repairButton_xpath);
			seleniumUtils.Click(Locator.XPATH, repairButton_xpath, "Pending Observation", "Repair");
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void completionDateEnter(){
		try{
			String date = CommonUtil.getDate("MM/dd/yyyy", 3);
			//			storeData("Future Date",date);
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, date_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, date_xpath, date, "Pending Observation", "Repair Completion Date");
			Thread.sleep(3000);
			seleniumUtils.DropDownSelect(Locator.XPATH, observationOutcome_xpath, "PRODUCT REPAIRED", "Pending Observation", "Obbservation Outcome");
			//		CommonUtil.escPress();
			Thread.sleep(3000);
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void verifyServiceRecordAfterRepaired(){
		try{
			seleniumUtils.waitForPageLoad();
			String serviceNo=getPropertyData("Service No");
			if(seleniumUtils.Size(Locator.XPATH, "//span[text()='"+serviceNo+"']")==0) {
				LogFileControl.logPass("Service Record Verification", "Service Record is not displaying in Pending for Repair page after repaired");
			}else {
				LogFileControl.logFailwithScreenCapture("Service Record Verification", "Service Record is displaying in Pending for Repair page after repaired");
			}
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void cancelRepairWithReason(){
		try{
			seleniumUtils.waitForPageLoad();
			Thread.sleep(3000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "//h4[contains(text(),'Repair Observation Outcome')]/following::mat-select[1]", "CANCEL REPAIR", "Pending Observation", "Observation Outcome");
			//seleniumUtils.WaitForElementToBeAvailable(Locator.LINKTEXT, "//h4[contains(text(),'Repair Observation Outcome')]/following::mat-select[2]");
			Thread.sleep(3000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "//h4[contains(text(),'Repair Observation Outcome')]/following::mat-select[2]", "OLD MODEL", "Pending Observation", "Cancelation Reason");
			seleniumUtils.takeScreenshot();
			
			}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
}
