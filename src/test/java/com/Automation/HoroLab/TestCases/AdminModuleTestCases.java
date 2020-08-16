package com.Automation.HoroLab.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.CommonUtil;
import com.Automation.HoroLab.DriverManager;
import com.Automation.HoroLab.LogFileControl;
import com.Automation.HoroLab.Locators.Locator;
import com.Automation.HoroLab.Modules.AdminModulePage;
import com.Automation.HoroLab.Modules.LoginPage;


public class AdminModuleTestCases extends Base{
	
	//@Test(priority=0, description="Create State and Validate Then try to add same state and validate error message" ,groups = {"Admin"})
	public static void TC_Location_01_02() {
		LoginPage.logIn("pawan", "punshegde");
		AdminModulePage.navigateToSubmodule("Location","State");
		AdminModulePage.clickOnAdd();
		String stateName = CommonUtil.randomName(5);
		AdminModulePage.addState(stateName);
		AdminModulePage.verifyCreatedName(stateName,"State");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addState(stateName);
		AdminModulePage.verifyErrorOnSameName();
	}

	//@Test(priority=1, description="Create City and Validate Then try to add same City and validate error message" ,groups = {"Admin"})
	public static void TC_Location_03_04() {
		LoginPage.logIn("pawan", "punshegde");
		AdminModulePage.navigateToSubmodule("Location","City");;
		AdminModulePage.clickOnAdd();
		String cityName = CommonUtil.randomName(5);
		AdminModulePage.addCity(cityName);
		AdminModulePage.verifyCreatedName(cityName,"City");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addCity(cityName);
		AdminModulePage.verifyErrorOnSameName();
	}
	
	//@Test(priority=2, description="Create Area and Validate Then try to add same Area and validate error message" ,groups = {"Admin"})
	public static void TC_Location_05_06() {
		LoginPage.logIn("pawan", "punshegde");
		AdminModulePage.navigateToSubmodule("Location","Area");;
		AdminModulePage.clickOnAdd();
		String areaName = CommonUtil.randomName(5);
		AdminModulePage.addArea(areaName);
		AdminModulePage.verifyCreatedName(areaName,"Area");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addArea(areaName);
		AdminModulePage.verifyErrorOnSameName();
	}
	
	//@Test(priority=3, description="Create Branch and Validate Then try to add same Branch and validate error message" ,groups = {"Admin"})
	public static void TC_Location_07_08() {
		LoginPage.logIn("pawan", "punshegde");
		AdminModulePage.navigateToSubmodule("Location","Branch");;
		AdminModulePage.clickOnAdd();
		String branchCode = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addBranch(branchCode);
		AdminModulePage.verifyCreatedName(branchCode,"Branch");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addBranch(branchCode);
		AdminModulePage.verifyErrorOnSameName();
	}
	
	//@Test(priority=4, description="Create ReRepair and Validate, try to add same ReRepair and validate error message, view timeline, edit, delete and verify" ,groups = {"Admin"})
	public static void TC_Reason_01_02_03_04() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Reasons","Re-Repair");;
		AdminModulePage.clickOnAdd();
		String reason = "A"+CommonUtil.randomName(5);
		AdminModulePage.addReRepair(reason);
		AdminModulePage.verifyCreatedName(reason,"Re-Repair");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addReRepair(reason);
		AdminModulePage.verifyErrorOnSameName();
		//AdminModulePage.verifytimeline(reason, userName);
		AdminModulePage.edit(reason);
		AdminModulePage.deleteAndVerify(reason);
	}
	
	//@Test(priority=5, description="Create Repair cancellation and Validate, try to add same Repair cancellation and validate error message, view timeline, edit, delete and verify" ,groups = {"Admin"})
	public static void TC_Reason_05_06_07_08() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Reasons","Repair Cancellation");;
		AdminModulePage.clickOnAdd();
		String reason = "A"+CommonUtil.randomName(5);
		AdminModulePage.addRepairCancellation(reason);
		AdminModulePage.verifyCreatedName(reason,"Repair Cancellation");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairCancellation(reason);
		AdminModulePage.verifyErrorOnSameName();
		//AdminModulePage.verifytimeline(reason, userName);
		AdminModulePage.edit(reason);
		AdminModulePage.deleteAndVerify(reason);
	}
	
	//@Test(priority=6, description="Create Replacement and Validate, try to add same Replacement and validate error message, view timeline, edit, delete and verify" ,groups = {"Admin"})
	public static void TC_Reason_09_10_11_12() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Reasons","Replacement");;
		AdminModulePage.clickOnAdd();
		String reason = "A"+CommonUtil.randomName(5);
		AdminModulePage.addreplacement(reason);
		AdminModulePage.verifyCreatedName(reason,"Replacement");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addreplacement(reason);
		AdminModulePage.verifyErrorOnSameName();
		//AdminModulePage.verifytimeline(reason, userName);
		AdminModulePage.edit(reason);
		AdminModulePage.deleteAndVerify(reason);
	}
	
	//@Test(priority=7, description="Create Block and Validate, try to add same Block and validate error message, view timeline, edit, delete and verify" ,groups = {"Admin"})
	public static void TC_RepairInfo_01_02_03_04() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Repair Info","Block");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Block");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		//AdminModulePage.verifytimeline(name, userName);
		AdminModulePage.edit(name);
		AdminModulePage.deleteAndVerify(name);
	}
	
	//@Test(priority=8, description="Create Block Component and Validate, try to add same Block Component and validate error message, view timeline, edit, delete and verify" ,groups = {"Admin"})
	public static void TC_RepairInfo_05_06_07_08() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Repair Info","Block Component");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Block Component");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		//AdminModulePage.verifytimeline(name, userName);
		AdminModulePage.edit(name);
		AdminModulePage.deleteAndVerify(name);
	}
	
	//@Test(priority=9, description="Create Phenomenon and Validate, try to add same Phenomenon and validate error message, view timeline, edit, delete and verify" ,groups = {"Admin"})
	public static void TC_RepairInfo_09_10_11_12() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Repair Info","Phenomenon");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Phenomenon");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		//AdminModulePage.verifytimeline(name, userName);
		AdminModulePage.edit(name);
		AdminModulePage.deleteAndVerify(name);
	}
	
	//@Test(priority=10, description="Create Reason Code and Validate, try to add same Reason Code and validate error message, view timeline, edit, delete and verify" ,groups = {"Admin"})
	public static void TC_RepairInfo_13_14_15_16() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Repair Info","Reason Code");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Reason Code");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		//AdminModulePage.verifytimeline(name, userName);
		AdminModulePage.edit(name);
		AdminModulePage.deleteAndVerify(name);
	}
	
	//@Test(priority=11, description="Create Repair Code and Validate, try to add same Repair Code and validate error message, view timeline, edit, delete and verify" ,groups = {"Admin"})
	public static void TC_RepairInfo_17_18_19_20() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Repair Info","Repair Code");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Repair Code");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		//AdminModulePage.verifytimeline(name, userName);
		AdminModulePage.edit(name);
		AdminModulePage.deleteAndVerify(name);
	}
	
//	@Test(priority=12, description="Create Observation Outcome and Validate, try to add same Observation Outcome and validate error message" ,groups = {"Admin"})
	public static void TC_Outcomes_01_02() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Outcomes","Observation Outcome");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Observation Outcome");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		
	}
	
	//@Test(priority=13, description="Create Replacement Outcome and Validate, try to add same Replacement Outcome and validate error message" ,groups = {"Admin"})
	public static void TC_Outcomes_03_04() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Outcomes","Replacement Outcome");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Replacement Outcome");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		
	}
	
	//@Test(priority=14, description="Create Cancellation Outcome and Validate, try to add same Cancellation Outcome and validate error message" ,groups = {"Admin"})
	public static void TC_Outcomes_05_06() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Outcomes","Cancellation Outcome");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Cancellation Outcome");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		
	}
	
	//@Test(priority=15, description="Create Repair Undertaken and Validate, try to add same Repair Undertaken and validate error message" ,groups = {"Admin"})
	public static void TC_Outcomes_07_08() {
		String userName = "pawan";
		LoginPage.logIn(userName, "punshegde");
		AdminModulePage.navigateToSubmodule("Outcomes","Repair Undertaken");;
		AdminModulePage.clickOnAdd();
		String name = "A"+CommonUtil.randomName(5);
		String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyCreatedName(name,"Repair Undertaken");
		AdminModulePage.clickOnAdd();
		AdminModulePage.addRepairInfoSubmodules(name,code);
		AdminModulePage.verifyErrorOnSameName();
		
	}
	
		@Test(priority=16, description="Create Product Category and Validate, try to add same Product Category and validate error message, add Accessories, verify error on duplicate entry, delete accessories, delete product category" ,groups = {"Admin"})
		public static void TC_PartsandModels_01_02_03_04_05_06() {
			String userName = "pawan";
			LoginPage.logIn(userName, "punshegde");
			AdminModulePage.navigateToSubmodule("Parts and Models","Product Category");
			AdminModulePage.clickOnAdd();
			String name = "A"+CommonUtil.randomName(5);
			String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
			String hsn = String.valueOf(CommonUtil.randomGenerator(4));
			String gst = String.valueOf(CommonUtil.randomGenerator(1));
			AdminModulePage.addProductCategory(name, code, hsn, gst);
			AdminModulePage.verifyCreatedName(name,"Product Category");
			AdminModulePage.clickOnAdd();
			AdminModulePage.addProductCategory(name, code, hsn, gst);
			AdminModulePage.verifyErrorOnSameName();
			AdminModulePage.navigateToSubmodule("Parts and Models","Accessories");
			AdminModulePage.clickOnAdd();
			String name1 = "A"+CommonUtil.randomName(5);
			AdminModulePage.addAccessories(name1, name);
			AdminModulePage.verifyCreatedName(name1,"Accessories");
//			*******************************************Bug on Duplicate entry*************************************
//			AdminModulePage.clickOnAdd();
//			AdminModulePage.addAccessories(name1, name);
//			AdminModulePage.verifyErrorOnSameName();
			AdminModulePage.deleteAndVerify(name1);
			AdminModulePage.navigateToSubmodule("Parts and Models","Product Category");
			AdminModulePage.deleteAndVerify(name);
		}
	
		
		//@Test(priority=17, description="Create Product Category and Validate, add Accessories under same prod category, edit Accessories and prod Category delete product category verify Accessories entry delete automatically" ,groups = {"Admin"})
		public static void TC_PartsandModels_07_08_09() throws Exception {
			String userName = "pawan";
			LoginPage.logIn(userName, "punshegde");
			AdminModulePage.navigateToSubmodule("Parts and Models","Product Category");
			AdminModulePage.clickOnAdd();
			String name = "A"+CommonUtil.randomName(5);
			String code = "C"+String.valueOf(CommonUtil.randomGenerator(5));
			String hsn = String.valueOf(CommonUtil.randomGenerator(4));
			String gst = String.valueOf(CommonUtil.randomGenerator(1));
			AdminModulePage.addProductCategory(name, code, hsn, gst);
			AdminModulePage.verifyCreatedName(name,"Product Category");
			AdminModulePage.navigateToSubmodule("Parts and Models","Accessories");
			AdminModulePage.clickOnAdd();
			String name1 = "A"+CommonUtil.randomName(5);
			AdminModulePage.addAccessories(name1, name);
			AdminModulePage.verifyCreatedName(name1,"Accessories");
			String newName1 = "A"+CommonUtil.randomName(5);
			AdminModulePage.editprodandVerify(name1, newName1);
			AdminModulePage.navigateToSubmodule("Parts and Models","Product Category");
			String newName = "A"+CommonUtil.randomName(5);
			AdminModulePage.editprodandVerify(name, newName);
			AdminModulePage.deleteAndVerify(newName);
			AdminModulePage.navigateToSubmodule("Parts and Models","Accessories");
			seleniumUtils.waitForPageLoad();
			if(seleniumUtils.Size(Locator.XPATH, "//span[text()=' "+newName1.toUpperCase()+" ']")>0) {
				LogFileControl.logPass(DriverManager.getDriver().getTitle(), "Accessories under deleted prod category one is not displaying in the list");
			}else {
				LogFileControl.logFailwithScreenCapture(DriverManager.getDriver().getTitle(), "Accessories under deleted prod category one is still displaying in the list");
			}
		
		}
}
