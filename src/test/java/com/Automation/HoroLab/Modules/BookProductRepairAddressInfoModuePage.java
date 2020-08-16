package com.Automation.HoroLab.Modules;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.Locators.Locator;
import com.Automation.HoroLab.LogFileControl;

public class BookProductRepairAddressInfoModuePage extends Base{
		
		public static final String addressType_xpath="//mat-select[@formcontrolname='addressType']";
		public static final String addressTypeHome_xpath="//span[contains(text(),'HOME')]";
		public static final String addr1_xpath="//textarea[@formcontrolname='addressLine1']";
		public static final String addr2_xpath="//textarea[@formcontrolname='addressLine2']";
		public static final String state_xpath="//mat-select[@formcontrolname='stateId']";
		public static final String stateSelectKarnataka_xpath="//span[contains(text(),'KARNATAKA')]";
		public static final String city_xpath="//mat-select[@formcontrolname='cityId']";
		public static final String citySelectedBangalore_xpath="//span[contains(text(),'BENGALURU')]";
		public static final String area_xpath="//mat-select[@formcontrolname='areaId']";
		public static final String areaSelectedMarathahalli_xpath="//span[contains(text(),'MARATHAHALLI')]";
		public static final String fax_xpath="//input[@formcontrolname='faxNo']";
		public static final String landMarkXpath="//input[@formcontrolname='nearestLandMark']";
		public static final String phoneNumberxpath="//input[@formcontrolname='phoneNo']";
		public static final String pinCode_xpath="//input[@formcontrolname='pinCode']";
		public static final String save_xpath="//span[contains(text(),'Save')]";
		
		
		
		
		
		
		/**
		 * @author Uma Sasmal
		 */
		public static void bookProductRepairAddressEnter() {
			try {
				seleniumUtils.waitforElementToBeClickable(Locator.XPATH, addressType_xpath);
				seleniumUtils.DropDownSelect(Locator.XPATH, addressType_xpath, "HOME", "Book Product Repair", "Address Type");
				seleniumUtils.SendKeys(Locator.XPATH, addr1_xpath, "Kundanahalli Palace", "Book Product Repair", "Address 1");
				seleniumUtils.SendKeys(Locator.XPATH, addr2_xpath, "Varthur Road", "Book Product Repair", "Address 2");
				seleniumUtils.DropDownSelect(Locator.XPATH, state_xpath, "KARNATAKA", "Book Product Repair", "State");
				Thread.sleep(3000);
				seleniumUtils.DropDownSelect(Locator.XPATH, city_xpath, "BENGALURU", "Book Product Repair", "City");
				Thread.sleep(3000);
				seleniumUtils.DropDownSelect(Locator.XPATH, area_xpath, "MARATHAHALLI", "Book Product Repair", "Area");
				seleniumUtils.SendKeys(Locator.XPATH, fax_xpath, "08078978978", "Book Product Repair", "FAX");
				seleniumUtils.SendKeys(Locator.XPATH, landMarkXpath, "Brookfield Mall", "Book Product Repair", "Land Mark");
				seleniumUtils.SendKeys(Locator.XPATH, phoneNumberxpath, "9739456456", "Book Product Repair", "Phone Number");
				seleniumUtils.SendKeys(Locator.XPATH, pinCode_xpath, "560037", "Book Product Repair", "PIN Code");
				seleniumUtils.Click(Locator.XPATH, save_xpath, "Book Product Repair", "Save");
				Thread.sleep(6000);
				seleniumUtils.waitforVisibilityOfElement(Locator.XPATH, "//h1[contains(text(),'Congratulations')]/following::span");
				if(seleniumUtils.IsDisplayed(Locator.XPATH, "//h1[contains(text(),'Congratulations')]/following::span")) {
					String reg=seleniumUtils.GetText(Locator.XPATH, "//h1[contains(text(),'Congratulations')]/following::span");
					
					LogFileControl.logPass("Book Product Repair", "Booking Done Succesfully, Success Message: "+reg);
					
				}
				else
					LogFileControl.logFail("Book Product Repair", "Booking not Done Succesfully");
			} catch (Exception e) {
				LogFileControl.logFail("Book Product Repair","Fail due to exception "+e.getMessage());
			}
		}


}
