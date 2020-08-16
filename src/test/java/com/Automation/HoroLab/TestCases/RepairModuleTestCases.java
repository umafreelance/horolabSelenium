package com.Automation.HoroLab.TestCases;

import org.testng.annotations.Test;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.Modules.LoginPage;
import com.Automation.HoroLab.Modules.PendingForRepairPage;
import com.Automation.HoroLab.Modules.PendingObservationPage;
import com.Automation.HoroLab.Modules.ReceiveModulePage;
import com.Automation.HoroLab.Modules.RepairPage;
import com.Automation.HoroLab.Modules.TechSheetPage;



public class RepairModuleTestCases extends Base{

//	@Test(priority=0, description="Craete Service Record , assign to Technician and validate details" ,groups = {"ReceiveModule"})
	public static void TestCase01_02() {
		LoginPage.logIn("pawan", "punshegde");
		ReceiveModulePage.clickReceive();
		ReceiveModulePage.searchButtonClick();
		ReceiveModulePage.keywordSearch("Uma Sasmal");
		ReceiveModulePage.selectCustomerClickReceive();
		ReceiveModulePage.receiveFormFill();
		RepairPage.testCase01();
		RepairPage.testCase02();
	}
//	@Test(priority=1, description="Technician Login Craete Service Record , assign to Technician and validate details" ,groups = {"ReceiveModule"})
	public static void TestCase03_04_05() {
		LoginPage.logIn("sangeeta", "sangeeta123");
		RepairPage.repairTabClick();
		RepairPage.testCase03();
		RepairPage.testCase04();
		RepairPage.testCase05();
	}
//	@Test(priority=2, description="Re-assign the record to a different technician" ,groups = {"ReceiveModule"})
//	public static void TestCase06() {
//		LoginPage.logIn("pawan", "punshegde");
//		RepairPage.testCase06FirstAssign();
//
//	}
//	@Test(priority=2, description="Re-assign the record to a different technician" ,groups = {"ReceiveModule"})
	public static void TestCase06() {
		LoginPage.logIn("pawan", "punshegde");
		RepairPage.testCase06FirstAssign();
		LoginPage.logOut();
		LoginPage.logIn("sangeeta", "sangeeta123");
		RepairPage.repairTabClick();
		RepairPage.pendingObservationClick();
		RepairPage.searchButtonClick();
		RepairPage.serviceRecordSearch();
		RepairPage.serviceRadioClick();
		RepairPage.observClick();
		PendingObservationPage.dateEnter();
		PendingObservationPage.reAssignproblemDetailEnter();
		PendingObservationPage.save();
		LoginPage.logOut();
		LoginPage.logIn("Neha", "neha123");
		RepairPage.repairTabClick();
		RepairPage.pendingObservationClick();
		RepairPage.searchButtonClick();
		RepairPage.serviceRecordSearch();
	}
	
	@Test(priority=3, description="cancel repair and reason as old model." ,groups = {"ReceiveModule"})
	public static void TestCase07() {
		LoginPage.logIn("pawan", "punshegde");
		RepairPage.testCase06FirstAssign();
		LoginPage.logOut();
		LoginPage.logIn("sangeeta", "sangeeta123");
		RepairPage.repairTabClick();
		RepairPage.pendingObservationClick();
		RepairPage.searchButtonClick();
		RepairPage.serviceRecordSearch();
		RepairPage.serviceRadioClick();
		RepairPage.observClick();
		PendingObservationPage.dateEnter();
		PendingObservationPage.reObservationDetailEnter();
//		PendingObservationPage.reAssignproblemDetailEnter();
		PendingObservationPage.save();
		PendingObservationPage.pendingforRepairClick();
		RepairPage.serviceRadioClick();
		PendingForRepairPage.reObserveButtonClick();
		PendingForRepairPage.cancelRepairWithReason();
		PendingObservationPage.save();
		//defect exist, Service is displaying in Repair Tab
		TechSheetPage.navigateToTechSheet();
		TechSheetPage.serviceClickandRepairStatus();
	}
}
