package com.Automation.HoroLab.Modules;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.CommonUtil;
import com.Automation.HoroLab.LogFileControl;
import com.Automation.HoroLab.Locators.Locator;

public class PendingObservationPage extends Base {

	public static final String pendingobservationDate_xpath="//input[@placeholder='Repair Observation Date']";
	public static final String blockdropdown_xpath="//h4[contains(text(),'Problem Details')]/following::mat-select[1]";
	public static final String blockComponent_xpath="//h4[contains(text(),'Problem Details')]/following::mat-select[2]";
	public static final String repairCode_xpath="//h4[contains(text(),'Problem Details')]/following::mat-select[3]";
	public static final String observationDropdown_xpath="//h4[contains(text(),'Observation Outco')]/following::mat-select[1]";
	public static final String technician_xpath="//h4[contains(text(),'Repair Observation Outcome')]/following::mat-select[1]";
	public static final String save_xpath="//mat-icon[contains(text(),'save')]";
	public static final String pendingforRepair_xpath="//span[contains(text(),'Pending for Repair')]";
	public static final String reassign_xpath="//span[contains(text(),'Re Assign')]";
	
	public static void dateEnter(){
		try{
			String date = CommonUtil.getDate("MM/dd/yyyy", 0);
//			storeData("Future Date",date);
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, pendingobservationDate_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, pendingobservationDate_xpath, date, "Pending Observation", "Repair Observation Date");
			}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void problemDetailEnter(){
		try{
			Thread.sleep(3000);
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, blockdropdown_xpath);
			seleniumUtils.DropDownSelect(Locator.XPATH, blockdropdown_xpath, "KEYBOARD", "Pending Observation", "Block");
			CommonUtil.escPress();
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, blockComponent_xpath);
			seleniumUtils.DropDownSelect(Locator.XPATH, blockComponent_xpath, "KEYBOARD - COMMON SHEET", "Pending Observation", "Block Component");
			CommonUtil.escPress();
			seleniumUtils.DropDownSelect(Locator.XPATH, repairCode_xpath, "Charge, Re-charge", "Pending Observation", "Repair Code");
			CommonUtil.escPress();
			seleniumUtils.DropDownSelect(Locator.XPATH, observationDropdown_xpath, "PRODUCT CAN BE REPAIR", "Pending Observation", "Observation Outcome");
			CommonUtil.escPress();
			}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	
	public static void save(){
		try{
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, save_xpath);
			seleniumUtils.Click(Locator.XPATH, save_xpath, "Pending Observation", "Save");
			seleniumUtils.waitForPageLoad();
			Thread.sleep(5000);
			}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void pendingforRepairClick(){
		try{
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, pendingforRepair_xpath);
			seleniumUtils.Click(Locator.XPATH, pendingforRepair_xpath, "Pending Observation", "Pending For Repair");
			seleniumUtils.waitForPageLoad();
			if(seleniumUtils.Size(Locator.XPATH, "//span[text()='ReObserve']")<=0)
				pendingforRepairClick();
			}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	
	public static void reAssignproblemDetailEnter(){
		try{
			Thread.sleep(3000);
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, blockdropdown_xpath);
			seleniumUtils.DropDownSelect(Locator.XPATH, blockdropdown_xpath, "KEYBOARD", "Pending Observation", "Block");
			CommonUtil.escPress();
			seleniumUtils.DropDownSelect(Locator.XPATH, blockComponent_xpath, "KEYBOARD - COMMON SHEET", "Pending Observation", "Block Component");
			CommonUtil.escPress();
			seleniumUtils.DropDownSelect(Locator.XPATH, repairCode_xpath, "Charge, Re-charge", "Pending Observation", "Repair Code");
			CommonUtil.escPress();
			seleniumUtils.Click(Locator.XPATH, reassign_xpath, "Pending Observation", "Re Assign");
			Thread.sleep(1000);
			seleniumUtils.DropDownSelect(Locator.XPATH, technician_xpath, "NEHA", "Pending Observation", "Observation Outcome");
//			seleniumUtils.DropDownSelect(Locator.XPATH, "//h4[contains(text(),'Repair Observation Outcome')]/following::mat-select[2]", "2", "Pending Observation", "Cancelation Reason");
			
			}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void reObservationDetailEnter(){
		try{
			Thread.sleep(3000);
			seleniumUtils.waitForPageLoad();
			seleniumUtils.DropDownSelect(Locator.XPATH, blockdropdown_xpath, "KEYBOARD", "Pending Observation", "Block");
			CommonUtil.escPress();
			seleniumUtils.DropDownSelect(Locator.XPATH, blockComponent_xpath, "KEYBOARD - COMMON SHEET", "Pending Observation", "Block Component");
			CommonUtil.escPress();
			seleniumUtils.DropDownSelect(Locator.XPATH, repairCode_xpath, "Charge, Re-charge", "Pending Observation", "Repair Code");
			CommonUtil.escPress();
			Thread.sleep(1000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "//h4[contains(text(),'Repair Observation Outcome')]/following::mat-select", "PRODUCT CAN BE REPAIR", "Pending Observation", "Repair Observation Outcome");
			
			}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
}
