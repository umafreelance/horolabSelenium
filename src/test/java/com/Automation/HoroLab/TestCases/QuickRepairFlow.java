package com.Automation.HoroLab.TestCases;

import org.testng.annotations.Test;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.Modules.BookProductRepairAddressInfoModuePage;
import com.Automation.HoroLab.Modules.BookProductRepairModulePage;
import com.Automation.HoroLab.Modules.BookProductRepairOtherInfoModulePage;
import com.Automation.HoroLab.Modules.BookProductRepairPersonalInfoModuePage;
import com.Automation.HoroLab.Modules.LoginPage;
import com.Automation.HoroLab.Modules.ReceiveModulePage;

public class QuickRepairFlow extends Base{

	@Test(priority=0, description="Quick Repair End To End Process" ,groups = {"Quick Repair"})
	public static void TC_BookRepairE2E_001() {
		LoginPage.logIn("pawan", "punshegde");
		ReceiveModulePage.clickReceive();
		ReceiveModulePage.searchButtonClick();
		ReceiveModulePage.enterSearchNameRecv("Uma Sasmal");
		ReceiveModulePage.selectCustomerClickRepair();
		ReceiveModulePage.quickRepairFormFill("6/4/2020", "321321321");
	}
}
