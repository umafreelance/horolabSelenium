package com.Automation.HoroLab.Modules;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.bcel.generic.StoreInstruction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.CommonUtil;
import com.Automation.HoroLab.DriverManager;
import com.Automation.HoroLab.Locators.Locator;
import com.Automation.HoroLab.LogFileControl;

public class ReceiveModulePage extends Base{

//	public static final String name_textbox_xpath="//input[@placeholder='Name']";
	public static final String receiveTabLink_xpath="//*[@role='img']/following-sibling::span[contains(text(),'Receive')]";
	public static final String receive_Link_xpath="//span[text()=' Receive ']";
	public static final String customerClarification_Link_xpath="//span[contains(text(),' Customer Clarification ')]";
	public static final String pendingReceiveFromVendor_Link_xpath="//span[contains(text(),' Pending/Receive from Vendor ')]";
	public static final String pendingCheckFromInternetCustomer_xpath="//span[contains(text(),' Pending Check from Internet Customer ')]";
	public static final String extraDetailsTabLink_xpath="//mat-panel-title[contains(text(),' Extra Details ')]";
	public static final String uploadKML_Link_xpath="//span[contains(text(),'Upload KML')]";
	public static final String uploadBills_Link_xpath="//span[contains(text(),'Upload Bills')]";
	public static final String dealerSatisfactionForm_Link_xpath="//span[contains(text(),' Dealer Satisfaction Form ')]";
	//Add, Search and Refresh
	public static final String addButton_xpath="//mat-icon[contains(text(),'add')]";
	public static final String searchButton_xpath="//mat-icon[contains(text(),'search')]";
	public static final String autoRenew_xpath="//mat-icon[contains(text(),'autorenew')]";

	public static final String productSale_xpath="//span[text()='Product Sale']";
	public static final String quickRepair_xpath="//span[text()='Quick Repair']";
	public static final String receive_xpath="//span[text()='Receive']";
	public static final String partSale_xpath="//span[text()='Part Sale']";
	public static final String bookProduct_xpath="//span[text()='Book Product']";
	public static final String bookPart_xpath="//span[text()='Book Part']";
	public static final String editCustomer_xpath="//span[text()='Edit Customer']";
	public static final String print_xpath="//span[text()='Print']";

	//Create new customer
	public static final String name_xpath="//input[@placeholder='Name']";
	public static final String userName_xpath="//input[@placeholder='Username']";
	public static final String mobileNo_xpath="//input[@placeholder='Mobile No']";
	public static final String email_xpath="//input[@placeholder='Email']";
	public static final String isWalkinCheckBox_xpath="//input[@type='checkbox']";
	public static final String password_xpath="//input[@placeholder='Password']";
	public static final String ConfirmPwd_xpath="//input[@placeholder='Confirm Password']";
	public static final String gstnNo_xpath="//input[@placeholder='GSTIN No']";
	public static final String altMobileNo_xpath="//input[@placeholder='Alt Mobile No']";
	public static final String birthDate_xpath="//input[@placeholder='Birth Date']";
	public static final String gender_xpath="//*[text()='Address Type']";
	//public static final String maritalStatus_xpath="//input[@placeholder='Name']";
	//public static final String anniversaryDate_xpath="//input[@placeholder='Name']";
	//public static final String branch_xpath="//input[@placeholder='Name']";
	public static final String addressType_xpath="//*[text()='Address Type']";
	public static final String home_xpath="//*[text()='HOME']";
	public static final String office_xpath="//*[text()='OFFICE']";
	public static final String billing_xpath="//*[text()='BILLING']";
	public static final String addressLine1_xpath="//input[@placeholder='Address Line 1']";
	public static final String addressLine2_xpath="//input[@placeholder='Address Line 2']";
	public static final String nearestLandMark_xpath="//input[@placeholder='Nearest LandMark']";
	public static final String phoneNo_xpath="//input[@placeholder='Phone No']";
	public static final String faxNo_xpath="//input[@placeholder='Fax No']";
	//public static final String state_xpath="//input[@placeholder='Name']";
	//public static final String city_xpath="//input[@placeholder='Name']";
	//public static final String area_xpath="//input[@placeholder='Name']";
	public static final String pinCode_xpath="//input[@placeholder='Pin Code']";
	//public static final String addMoreCustAddress="//span[contains(test(),' Add More Customer  Address')]";
	public static final String save_xpath="//span[text()='Save']";
	public static final String cancel_xpath="//span[text()='Cancel']";
	public static final String receiveError_xpath="//*[contains(@class,'mat-error')]";

	//Add More Address
	public static final String addMoreAddress_xpath="//span[text()='Add More Customer  Address']";


	//Error messages
	public static final String errorMsgNameMoreThan100Char_xpath="//mat-error[contains(text(),'more than 100')]";
	public static final String errorMsgNameOnlyAlphaAllow_xpath="//mat-error[contains(text(),' Only alphabets allowed, dots and spaces allowed in between alphabets')]";
	public static final String errorMsgMobileMoreThan13Digit_xpath="//mat-error[contains(text(),'more than 13')]";
	public static final String errorMsgMobileLessThan10Digit_xpath="//mat-error[contains(text(),'less than 10 characters')]";
	public static final String errorMsgMobile_xpath="//mat-error[contains(text(),'Can only be prefixed with optional')]";
	public static final String errorMsgFax_xpath="//mat-error[contains(text(),'Fax No cannot have more than 20 characters')]";
	public static final String errorMsgFax1_xpath="//mat-error[contains(text(),'Can only be prefixed with optional')]";
	public static final String errorMsgPinCodeLessThan4_xpath="//mat-error[contains(text(),'Pin Code cannot have less than 4 characters')]";
	public static final String errorMsgPinCodeMorethan10_xpath="//mat-error[contains(text(),'more than 10')]";
	public static final String errorMsgOnlyNumAllowed_xpath="//mat-error[contains(text(),' Only numbers are allowed')]";
	public static final String errorMsgValidEmail_xpath="//mat-error[contains(text(),'valid email id')]";


	public static final String searchName_xpath="//input[@placeholder='Name']";
	public static final String filtersearchbutton_xpath="//span[contains(text(),'Search')]";
	public static final String RecvsearchButton_xpath="//span[text()='Search']";
	public static final String customerSelectRadio_xpath="//button[text()='GSTIN No']/following::div[9]";//"//button[text()='Select']/following::mat-radio-button";
	public static final String quickRepairButton_xpath="//span[text()='Quick Repair']";
	public static final String Rcvdate_xpath="//input[@placeholder='Receive Date']";
	public static final String RcvRecNumber_xpath="//input[@placeholder='Service Record No']";
	public static final String RcvRecPath_xpath="//input[@placeholder='Service Record Path']/following::mat-icon[1]";
	public static final String companySelect_Xpath="(//mat-hint[text()='Single Selection Allowed'])[1]/preceding::mat-select[1]";

	public static final String COmpany_Xpath="//span[text()='CASIO']";
	public static final String CategorySelect_Xpath="(//mat-hint[text()='Single Selection Allowed'])[2]/preceding::mat-select[1]";
	public static final String Category_Xpath="//span[text()='CALCULATOR']";
	public static final String modelAddXpath="//input[@placeholder='Model No']/following::mat-icon[1]";
	public static final String compName="//h3[text()='Add New Model No']/following::mat-select[1]";
	public static final String ItmCatry="//h3[text()='Add New Model No']/following::mat-select[2]";
	public static final String modelNumber="//h3[text()='Add New Model No']/following::input[2]";


	public static void addModel(String modelNo) {
		try {
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, modelAddXpath);
			seleniumUtils.Click(Locator.XPATH, modelAddXpath, "Receive", "Model Add");
			Thread.sleep(4000);
			if(seleniumUtils.Size(Locator.XPATH, "//button[@class='mce-close']")>0)
				seleniumUtils.Click(Locator.XPATH, "//button[@class='mce-close']", "Add Model", "Close");
			seleniumUtils.DropDownSelect(Locator.XPATH, compName, "CASIO", "Add Model", "Company Name");
			Thread.sleep(3000);
			seleniumUtils.DropDownSelect(Locator.XPATH, ItmCatry, "CALCULATOR", "Add Model", "Category Name");
			seleniumUtils.SendKeys(Locator.XPATH, modelNumber, modelNo, "Add Model", "Model No");
			seleniumUtils.DropDownSelect(Locator.XPATH, "//mat-label[text()='Add Text Features']/preceding::mat-select[1]", "AVAILABLE", "Add Model", "Availabity");
			seleniumUtils.Click(Locator.XPATH, "//span[contains(text(),'Is Displayable')]", "Add Model", "Display");
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, "(//*[text()='Save'])[2]");
			seleniumUtils.Click(Locator.XPATH, "(//*[text()='Save'])[2]", "Add Model", "Save");
			Thread.sleep(3000);
			if(seleniumUtils.Size(Locator.XPATH, "(//*[text()='Cancel'])[2]")>0)
				seleniumUtils.Click(Locator.XPATH, "(//*[text()='Cancel'])[2]", "Add Model", "Cancel");
			Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void quickRepairFormFill(String date ,String RecvNumber ) {
		try {
			DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Rcvdate_xpath)));
//			seleniumUtils.Clear(Locator.XPATH, Rcvdate_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, Rcvdate_xpath, date, "Add Model", "Receive Date");
			seleniumUtils.SendKeys(Locator.XPATH, RcvRecNumber_xpath, RecvNumber, "Add Model", "Receive Number");
			WebElement serviceRecordPath = DriverManager.getDriver().findElement(By.xpath(RcvRecPath_xpath));
			String path=System.getProperty("user.dir") +"\\Attachment\\frontImage.jpg";
			serviceRecordPath.click();
			StringSelection data = new StringSelection
					(path);
			Clipboard cb = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			cb.setContents(data, data);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);        // C
			r.keyPress(KeyEvent.VK_V);    // : (colon)
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);    // / (slash)
			Thread.sleep(1500);
			r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
			r.keyRelease(KeyEvent.VK_ENTER);
			//serviceRecordPath.sendKeys(path);
			seleniumUtils.DropDownSelect(Locator.XPATH, companySelect_Xpath, "CASIO", "Quick Repair From", "Company Name");
			seleniumUtils.DropDownSelect(Locator.XPATH, CategorySelect_Xpath, "CALCULATOR", "Quick Repair From", "Category Name");
			String modelNo="CAL0011";
			addModel(modelNo);
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Model No']", modelNo, "Quick Repair From", "Model No");
			Thread.sleep(3000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "//*[text()='Under Warranty ']/following::div[8]", "MINOR REPAIR", "Quick Repair From", "Repair Undertaken");
			Thread.sleep(3000);
			seleniumUtils.Click(Locator.XPATH, "(//*[text()='Save'])", "Quick Repair From", "Save");
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}




	public static void selectCustomerClickRepair() {
		try {
			Thread.sleep(5000);
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, customerSelectRadio_xpath);
			seleniumUtils.MoveToElement(Locator.XPATH, customerSelectRadio_xpath);
			DriverManager.getDriver().findElement(By.xpath(customerSelectRadio_xpath)).click();
//			seleniumUtils.Click(Locator.XPATH, customerSelectRadio_xpath, "Receive", "Customer select");
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, quickRepairButton_xpath);
			seleniumUtils.Click(Locator.XPATH, quickRepairButton_xpath, "Receive", "Quick Repair");

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterSearchNameRecv(String custName) {
		try {
			DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchName_xpath)));
			Thread.sleep(2000);
			seleniumUtils.SendKeys(Locator.XPATH, searchName_xpath, custName, "Receive", "Search");
			seleniumUtils.Click(Locator.XPATH, RecvsearchButton_xpath, "Receive", "Search");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}



	public static void clickReceive() {
		try {
			Thread.sleep(9000);
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, receiveTabLink_xpath);
			seleniumUtils.Click(Locator.XPATH, receiveTabLink_xpath, "Home", "Receive Tab");

		} catch (Exception e) {
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}

	}
	

	public static void searchButtonClick(){
		try{
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, searchButton_xpath);
			seleniumUtils.Click(Locator.XPATH, searchButton_xpath, "Receive Tab", "Search");
		}
		catch(Exception e){
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	
	public static void keywordSearch(String keyword){
		try{
//			Thread.sleep(3000);
//			searchButtonClick();
			Thread.sleep(6000);
			seleniumUtils.SendKeys(Locator.XPATH, searchName_xpath, keyword, "Receive Tab", "Name Search");
			seleniumUtils.Click(Locator.XPATH, filtersearchbutton_xpath, "Receive Tab", "Search");
			
		}catch(Exception e) {
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}
	}
	public static void selectCustomerClickReceive() {
		try {
			Thread.sleep(5000);
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, customerSelectRadio_xpath);
			seleniumUtils.MoveToElement(Locator.XPATH, customerSelectRadio_xpath);
			DriverManager.getDriver().findElement(By.xpath(customerSelectRadio_xpath)).click();
//			seleniumUtils.Click(Locator.XPATH, customerSelectRadio_xpath, "Receive", "Customer select");
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, receive_xpath);
			seleniumUtils.Click(Locator.XPATH, receive_xpath, "Receive", "Receive Button");

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void billingAddressEnter() {
//		try {
//			seleniumUtils.Click(Locator.XPATH, "//mat-icon[text()='add_circle_outline']", "Received", "Add Billing Address");
//			seleniumUtils.DropDownSelect(Locator.XPATH, "//h3[text()='Add New Billing Address']/following::mat-select[1]", "HOME", "Received", "Address Type");
//			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Address Line 1']", "Panathur Road", "Recived", "Address1");
//			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Pin Code']", "560038", "Recived", "PIN");
//			seleniumUtils.DropDownSelect(Locator.XPATH, "//h3[text()='Add New Billing Address']/following::mat-select[2]", "1", "Received", "State");
//			seleniumUtils.DropDownSelect(Locator.XPATH, "//h3[text()='Add New Billing Address']/following::mat-select[3]", "1", "Received", "City");
//			seleniumUtils.DropDownSelect(Locator.XPATH, "//h3[text()='Add New Billing Address']/following::mat-select[4]", "1", "Received", "Area");
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public static void receiveFormFill() {
		try {
			Thread.sleep(7000);
			DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Rcvdate_xpath)));
			seleniumUtils.waitForPageLoad();
			seleniumUtils.DropDownSelect(Locator.XPATH, "//mat-label[text()='Customer Reg No']/preceding::mat-select", "2", "Receive", "Branch");
			
			//Currently hard coaded
//			String custName= seleniumUtils.GetText(Locator.XPATH, "//mat-label[text()='Customer Name']/preceding::input[1]");
//			storeData("Customer Name",custName);
			String customrReqNumber = seleniumUtils.GetText(Locator.XPATH, "//mat-label[text()='Customer Reg No']/preceding::input[1]");
			LogFileControl.logPass("Customer Reg No", customrReqNumber);
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, "//span[contains(text(),'Is Walkin')]");
			Thread.sleep(4000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "//span[contains(text(),'Is Walkin')]/following::mat-select[1]", "1", "Receive", "Billing Address");
			seleniumUtils.DropDownSelect(Locator.XPATH, "//span[contains(text(),'Is Walkin')]/following::mat-select[2]", "1", "Receive", "Pick up Address");
			seleniumUtils.DropDownSelect(Locator.XPATH, "//span[contains(text(),'Is Walkin')]/following::mat-select[3]", "1", "Receive", "Drop Address");
			//R102108365545762
			String serviceNo=CommonUtil.getDatetimeinSec();
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Service Record No']", serviceNo, "Receive", "Service Record Number");
			storeData("Service No",serviceNo);
			
			
			Thread.sleep(3000);
			WebElement serviceRecordPath = DriverManager.getDriver().findElement(By.xpath("//input[@placeholder='Service Record']/following::mat-icon[1]"));
			String path=System.getProperty("user.dir") +"\\Attachment\\frontImage.jpg";
			serviceRecordPath.click();
			StringSelection data = new StringSelection
					(path);
			Clipboard cb = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			cb.setContents(data, data);
			System.out.println(cb.getName());
			Thread.sleep(1500);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);        // C
			r.keyPress(KeyEvent.VK_V);    // : (colon)
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);    // / (slash)
			Thread.sleep(1500);
			r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
			r.keyRelease(KeyEvent.VK_ENTER);
			//serviceRecordPath.sendKeys(path);
			Thread.sleep(3000);
			seleniumUtils.Click(Locator.XPATH, "//input[@placeholder='Service Record']/following::mat-icon[1]", "Receive", "Upload File");
			Thread.sleep(5000);
			seleniumUtils.DropDownSelect(Locator.XPATH, "//h4[text()='Product Details']/following::mat-select[1]", "CASIO", "Receive", "Company Name");
			seleniumUtils.DropDownSelect(Locator.XPATH, "//h4[text()='Product Details']/following::mat-select[2]", "CALCULATOR", "Receive", "Category Name");
			String modelNo="CAL0011";
//			addModel(modelNo);
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Model No']", modelNo, "Receive", "Model No");
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, "//input[@placeholder='Claimed Mode Name']");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Claimed Mode Name']", "ClaimModel1123", "Receive", "Claim Model Number");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Serial No']", "12112233", "Receive", "Serial Number");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Customer Product Reference No']", "2000200", "Receive", "Customer Product Reference No");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Caliber No']", "2333212", "Receive", "Caliber Number");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Backcover No']", "70000123", "Receive", "Backcover No");
			
			seleniumUtils.Clear(Locator.XPATH, "//input[@placeholder='Approx Estimate']");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Approx Estimate']", "1000", "Receive", "Approx Estimate");
			
			seleniumUtils.Clear(Locator.XPATH, "//input[@placeholder='Advance Amount']");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Advance Amount']", "500", "Receive", "Advance");
			
			seleniumUtils.Clear(Locator.XPATH, "//input[@placeholder='PreApproved Amount']");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='PreApproved Amount']", "1500", "Receive", "PreApproved Amount");
			
			seleniumUtils.Clear(Locator.XPATH, "//input[@placeholder='Pickup/Delivery Amount']");
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Pickup/Delivery Amount']", "500", "Receive", "Delivery Amount");
			String date = CommonUtil.getDate("MM/dd/yyyy", 3);
			storeData("Future Date",date);
			seleniumUtils.SendKeys(Locator.XPATH, "//input[@placeholder='Expected Date']", date, "Receive", "Date");
			seleniumUtils.takeScreenshot();
			seleniumUtils.Click(Locator.XPATH, "//span[text()='Save']", "Receive", "Save");
			seleniumUtils.waitForPageLoad();
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//	public static void receiveAppearanceOfUI(){
//		try {
//			Assert.assertTrue(driver.findElement(By.xpath(receive_Link_xpath)).isDisplayed(),"Receive Link Not Displaying");
//			//driver.findElement(By.xpath(receive_Link_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(customerClarification_Link_xpath)).isDisplayed(),"Customer Clarification Link Not Displaying");
//			Assert.assertTrue(driver.findElement(By.xpath(pendingReceiveFromVendor_Link_xpath)).isDisplayed(),"Pending/Receive from Vendor Link Not Displaying");
//			Assert.assertTrue(driver.findElement(By.xpath(pendingCheckFromInternetCustomer_xpath)).isDisplayed(),"Pending Check From Internet Customer Link Not Displaying");
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(extraDetailsTabLink_xpath)));
//			Assert.assertTrue(driver.findElement(By.xpath(extraDetailsTabLink_xpath)).isDisplayed(),"Extra Details Tab is Not Displaying");
//			Thread.sleep(5000);;
//			driver.findElement(By.xpath(extraDetailsTabLink_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(uploadKML_Link_xpath)).isDisplayed(),"Upload KML Link is Not Displaying ");
//			Assert.assertTrue(driver.findElement(By.xpath(uploadBills_Link_xpath)).isDisplayed(),"Upload Bills is Not Displaying");
//			Assert.assertTrue(driver.findElement(By.xpath(dealerSatisfactionForm_Link_xpath)).isDisplayed(),"Dealer Satisfaction Form is Not Displaying");
//			Assert.assertTrue(driver.findElement(By.xpath(addButton_xpath)).isDisplayed(),"add Button Not Displaying");
//			Assert.assertTrue(driver.findElement(By.xpath(searchButton_xpath)).isDisplayed(),"Search Button Not Displaying");
//			Assert.assertTrue(driver.findElement(By.xpath(autoRenew_xpath)).isDisplayed(),"auto renew Button Not Displaying");
//
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//
//	}

	public static void clickAdd() {
		try {
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, addButton_xpath);
			seleniumUtils.Click(Locator.XPATH, addButton_xpath, "", "Add");
		} catch (Exception e) {
			System.out.println(e);
			LogFileControl.logFail("Fail : ", "Fail due to exception "+e.getMessage());
		}

	}

//	public static void addCustomer(String name, String mobile, String email, String gstnNo,String altMobileNo, String dob, String gender) {
//		try {
//			driver.findElement(By.xpath(name_xpath)).clear();
//			driver.findElement(By.xpath(name_xpath)).sendKeys(name);
//			driver.findElement(By.xpath(mobileNo_xpath)).clear();
//			driver.findElement(By.xpath(mobileNo_xpath)).sendKeys(mobile);
//			driver.findElement(By.xpath(email_xpath)).clear();
//			driver.findElement(By.xpath(email_xpath)).sendKeys(email);
//			//Thread.sleep(5000);
//			//if ( !driver.findElement(By.xpath(isWalkinCheckBox_xpath)).isSelected() )
//			//{
//			//Thread.sleep(5000);
//			//driver.findElement(By.xpath(isWalkinCheckBox_xpath)).click();
//			//}
//			driver.findElement(By.xpath(gstnNo_xpath)).clear();
//			driver.findElement(By.xpath(gstnNo_xpath)).sendKeys(gstnNo);
//			driver.findElement(By.xpath(altMobileNo_xpath)).clear();
//			driver.findElement(By.xpath(altMobileNo_xpath)).sendKeys(altMobileNo);
//			driver.findElement(By.xpath(birthDate_xpath)).clear();
//			driver.findElement(By.xpath(birthDate_xpath)).sendKeys(dob);
//			driver.findElement(By.xpath(gender_xpath)).sendKeys(gender);;
//			driver.findElement(By.xpath(save_xpath)).click();
//
//
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//	}
//
//	public static void validateReceiveErrorMsg() {
//		try {
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(receiveError_xpath)));
//			Assert.assertTrue(driver.findElement(By.xpath(receiveError_xpath)).isDisplayed()," Error Message is not displaying properly");
//		}catch(Exception e) {
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//	}
//
//	public static void validationLengthOfTextbox(){
//		nameInputValidation();
//		mobileInputValidation();
//		emailFieldInputValidation();
//		phoneInputValidation();
//		faxInputValidation();
//		pincodeFieldInputValidation();
//	}
//
//	public static void nameInputValidation(){
//		try{
//			String name = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//			String name1= "123asddd";
//			driver.findElement(By.xpath(name_xpath)).clear();
//			driver.findElement(By.xpath(name_xpath)).sendKeys(name);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgNameMoreThan100Char_xpath)).isDisplayed(),"Error not Displayed Properly");
//
//			driver.findElement(By.xpath(name_xpath)).clear();
//			driver.findElement(By.xpath(name_xpath)).sendKeys(name1);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgNameOnlyAlphaAllow_xpath)).isDisplayed(),"Error not Displayed Properly");
//
//		}catch(Exception e){
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//
//	}
//	public static void mobileInputValidation(){
//		try{
//			String mobile = "99999999999999";
//			String mobile1 = "9-9999999212";
//			String mobile2="2222";
//			driver.findElement(By.xpath(mobileNo_xpath)).clear();
//			driver.findElement(By.xpath(mobileNo_xpath)).sendKeys(mobile);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgMobileMoreThan13Digit_xpath)).isDisplayed(),"Error not Displayed Properly");
//			driver.findElement(By.xpath(mobileNo_xpath)).clear();
//			driver.findElement(By.xpath(mobileNo_xpath)).sendKeys(mobile1);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgMobile_xpath)).isDisplayed(),"Error not displaying properly");
//			driver.findElement(By.xpath(mobileNo_xpath)).clear();
//			driver.findElement(By.xpath(mobileNo_xpath)).sendKeys(mobile2);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgMobileLessThan10Digit_xpath)).isDisplayed(),"Error not displaying properly");
//		}catch(Exception e){
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//	}
//
//	public static void faxInputValidation(){
//		try{
//			String fax = "99999999999999999999555";
//			String fax1 = "22-9999";
//			driver.findElement(By.xpath(faxNo_xpath)).clear();
//			driver.findElement(By.xpath(faxNo_xpath)).sendKeys(fax);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgFax_xpath)).isDisplayed(),"Error not Displayed Properly");
//			driver.findElement(By.xpath(faxNo_xpath)).clear();
//			driver.findElement(By.xpath(faxNo_xpath)).sendKeys(fax1);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgFax1_xpath)).isDisplayed(),"Error not displaying properly");
//		}catch(Exception e){
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//	}
//
//	public static void phoneInputValidation(){
//		try{
//			String phone = "99999999999999";
//			String phone1 = "9-9999999212";
//			String phone2 = "9000";
//			driver.findElement(By.xpath(phoneNo_xpath)).clear();
//			driver.findElement(By.xpath(phoneNo_xpath)).sendKeys(phone);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgMobileMoreThan13Digit_xpath)).isDisplayed(),"Error not Displayed Properly");
//			driver.findElement(By.xpath(phoneNo_xpath)).clear();
//			driver.findElement(By.xpath(phoneNo_xpath)).sendKeys(phone1);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgMobile_xpath)).isDisplayed(),"Error not displaying properly");
//			driver.findElement(By.xpath(phoneNo_xpath)).clear();
//			driver.findElement(By.xpath(phoneNo_xpath)).sendKeys(phone2);
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgMobileLessThan10Digit_xpath)).isDisplayed(),"Error not displaying properly");
//		}catch(Exception e){
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//	}
//
//	public static void emailFieldInputValidation() {
//		try {
//			driver.findElement(By.xpath(email_xpath)).clear();
//			driver.findElement(By.xpath(email_xpath)).sendKeys("abc@gmaiccc");
//			driver.findElement(By.xpath(save_xpath)).click();
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgValidEmail_xpath)).isDisplayed(),"Valid Email Id error message is not displaying");
//
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//
//	}
//
//	public static void pincodeFieldInputValidation(){
//		try{
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pinCode_xpath)));
//			driver.findElement(By.xpath(pinCode_xpath)).sendKeys("1");
//			driver.findElement(By.xpath(save_xpath)).click();
//			String errorMsg = driver.findElement(By.xpath(errorMsgPinCodeLessThan4_xpath)).getText();
//			System.out.println(errorMsg);
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgPinCodeLessThan4_xpath)).isDisplayed(),"Pin Code TextBox Less than 4 Error Message is Not Displaying");
//			driver.findElement(By.xpath(pinCode_xpath)).clear();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pinCode_xpath)));
//			driver.findElement(By.xpath(pinCode_xpath)).sendKeys("123123123456");
//			driver.findElement(By.xpath(save_xpath)).click();
//			String errorMsg2 = driver.findElement(By.xpath(errorMsgPinCodeMorethan10_xpath)).getText();
//			System.out.println(errorMsg2);
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgPinCodeMorethan10_xpath)).isDisplayed(),"Pin Code TextBox More than 10 Error Message is Not Displaying");
//			driver.findElement(By.xpath(pinCode_xpath)).clear();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pinCode_xpath)));
//			driver.findElement(By.xpath(pinCode_xpath)).sendKeys("asdcv");
//			driver.findElement(By.xpath(save_xpath)).click();
//			String successMsg = driver.findElement(By.xpath(errorMsgOnlyNumAllowed_xpath)).getText();
//			System.out.println(successMsg);
//			Assert.assertTrue(driver.findElement(By.xpath(errorMsgOnlyNumAllowed_xpath)).isDisplayed(),"Pin Code TextBox Only Numbers Allowed Message is Not Displaying");
//
//		}catch(Exception e){
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//
//	}
//
//	public static void customerAddress(String type, String address, String pincode) {
//		try {
//			//Actions action = new Actions(driver);
//			//WebElement link=driver.findElement(By.xpath(addressType_xpath));
//			//action.doubleClick(link).click();
//			String temp_type=type + "_xpath";
//			driver.findElement(By.xpath(addressType_xpath)).click();
//			//driver.findElement(By.linkText(temp_type)).click();
//			//driver.findElement(By.xpath(addressLine1_xpath)).sendKeys(address);
//			//driver.findElement(By.xpath(pinCode_xpath)).sendKeys(pincode);
//
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//
//	}
//
//	public static void customerAddMoreAddress(String type) {
//		try {
//			driver.findElement(By.xpath(addMoreAddress_xpath)).click();
//
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//
//	}
//
//	public static void cancelReceive() {
//		try {
//			driver.findElement(By.xpath(cancel_xpath)).click();
//
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail("Fail due to exception "+e.getMessage());
//		}
//
//	}
}
