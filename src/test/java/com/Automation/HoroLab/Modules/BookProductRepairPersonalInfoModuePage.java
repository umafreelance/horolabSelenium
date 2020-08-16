package com.Automation.HoroLab.Modules;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.LogFileControl;
import com.Automation.HoroLab.Locators.Locator;

public class BookProductRepairPersonalInfoModuePage extends Base{
	
	public static final String name_xpath="//input[@formcontrolname='name']";
	public static final String mobileNumber_xpath="//input[@formcontrolname='mobileNo']";
	public static final String userName_xpath="//input[@formcontrolname='username']";
	public static final String emailID_xpath="//input[@formcontrolname='emailId']";
	public static final String password_xpath="//input[@formcontrolname='password']";
	public static final String confinrmPassword_xpath="//input[@formcontrolname='confirmPassword']";
	public static final String NextButton_xpath="(//button//span[contains(text(),'Next')])[3]";
	
	/**
	 * @author Uma Sasmal
	 */
	public static void bookProductRepairPersonalInfoEnter() {
		try {
			seleniumUtils.WaitForElementToBeAvailable(Locator.XPATH, name_xpath);
			seleniumUtils.waitforVisibilityOfElement(Locator.XPATH, name_xpath);
			seleniumUtils.SendKeys(Locator.XPATH, name_xpath, "Uma Sasmal", "Personal Info", "Name");
			seleniumUtils.SendKeys(Locator.XPATH, mobileNumber_xpath, "9879879879", "Personal Info", "Mobile no");
			seleniumUtils.SendKeys(Locator.XPATH, userName_xpath, "umasasmal", "Personal Info", "User Name");
			seleniumUtils.SendKeys(Locator.XPATH, emailID_xpath, "uma.sasmal@horolab.com", "Personal Info", "Email");
			seleniumUtils.SendKeys(Locator.XPATH, password_xpath, "Test@12345", "Personal Info", "Password");
			seleniumUtils.SendKeys(Locator.XPATH, confinrmPassword_xpath, "Test@12345", "Personal Info", "Confirm Password");
			seleniumUtils.Click(Locator.XPATH, NextButton_xpath, "Personal Info", "Next");
		} catch (Exception e) {
			LogFileControl.logFail("Book Product","Fail due to exception "+e.getMessage());
		}
	}

}
