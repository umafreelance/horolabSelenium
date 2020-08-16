package com.Automation.HoroLab.Modules;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.LogFileControl;
import com.Automation.HoroLab.Locators.Locator;

public class TechSheetPage extends Base{
	
	public static final String searchButton_xpath="//mat-icon[contains(text(),'search')]";
	public static final String searchfield_Xpath="//input[@placeholder='Search']";
	public static final String techsheetTab_xpath="//span[contains(text(),'TechSheet')]";
	public static final String repairStatus_xpath="//span[text()='Repair Status']/following::span[1]";
	
	public static void serviceRecordSearch(){
		try{
			String servieNo = getPropertyData("Service No");
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, "//span[text()='"+servieNo+"']");
			seleniumUtils.Click(Locator.XPATH, "//span[text()='"+servieNo+"']", "Repair", "Service Record Number");
			Thread.sleep(7000);
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}

	public static void navigateToTechSheet(){
		try{
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, techsheetTab_xpath);
			seleniumUtils.Click(Locator.XPATH, techsheetTab_xpath, "Repair", "Tech Sheet Tab");
			seleniumUtils.waitForPageLoad();
			Thread.sleep(4000);
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void serviceClickandRepairStatus() {
		try {
			String serviceNo = getPropertyData("Service No");
			seleniumUtils.waitForPageLoad();
			seleniumUtils.Click(Locator.XPATH, "//span[text()='"+serviceNo+"']", "Repair", "Tech Sheet Tab");
			seleniumUtils.waitForPageLoad();
			LogFileControl.logPass("Repair Status", seleniumUtils.GetText(Locator.XPATH, repairStatus_xpath));
			RepairPage.closeButtonClick();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
