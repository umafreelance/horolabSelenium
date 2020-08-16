package com.Automation.HoroLab.TestCases;

import org.testng.annotations.Test;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.Modules.BookProductRepairAddressInfoModuePage;
import com.Automation.HoroLab.Modules.BookProductRepairModulePage;
import com.Automation.HoroLab.Modules.BookProductRepairOtherInfoModulePage;
import com.Automation.HoroLab.Modules.BookProductRepairPersonalInfoModuePage;


public class BookRepairFlow extends Base{

	@Test(priority=0, description="Book Repair End To End Process" ,groups = {"Book Repair"})
	public static void TC_BookRepairE2E_001() {
		BookProductRepairModulePage.bookProductRepairClick();
		BookProductRepairModulePage.bookProductRepairProductInfo();
		BookProductRepairOtherInfoModulePage.otherInfoEnter();
		BookProductRepairPersonalInfoModuePage.bookProductRepairPersonalInfoEnter();
		BookProductRepairAddressInfoModuePage.bookProductRepairAddressEnter();
	}
}
