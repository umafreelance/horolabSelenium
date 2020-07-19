package com.Automation.HoroLab.Modules;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.DriverManager;
import com.Automation.HoroLab.Locators.Locator;
import com.Automation.HoroLab.LogFileControl;



public class LoginPage extends Base {
	public static final String loginLink_xpath="(//span[text()='Login/Register'])[1]";
	public static final String userName_id="mat-input-0";
	public static final String passWord_xpath="//input[@formcontrolname='Password']";
	public static final String signIn_xpath="//span[text()='Sign In']";
	public static final String homePage_xpath="//*[contains(@class,'sidenav-content')]";
	public static final String loginErrorMsg_xpath="//*[text()='Login Failed, Reason : Bad credentials']";
	public static final String forgotPassword_class="forget-password";
	public static final String registerFormLink_xpath = "//div[contains(text(),'Register Form')]";
	
	/**
	 * @author Uma Sasmal
	 * @param username
	 * @param password
	 */
	public static void logIn(String username,String password) {
		try {   
			seleniumUtils.Click(Locator.XPATH, loginLink_xpath, "Landing", "Login Link");
			seleniumUtils.SendKeys(Locator.ID, userName_id, username, "Login", "User Name");
			seleniumUtils.SendKeys(Locator.XPATH, passWord_xpath, password, "Login", "Password");
			seleniumUtils.Click(Locator.XPATH, signIn_xpath, "Login", "Sign In");
		}catch(Exception e) {
			System.out.println(e);
			//Assert.fail("Fail due to exception "+e.getMessage());
		}
	}
	
	/**
	 * @author Uma Sasmal
	 */
	public static void validateHomePage() {
		try {         
			seleniumUtils.IsDisplayed(Locator.XPATH, homePage_xpath);
			if(seleniumUtils.IsDisplayed(Locator.XPATH, homePage_xpath)) {
				LogFileControl.logPass("Login Success Validation", "Home Page is displaying");
			}else {
				LogFileControl.logFail("Login Success Validation", "Home Page is not displaying");
			}
		}catch(Exception e) {
			System.out.println(e);
			//Assert.fail("Fail due to exception "+e.getMessage());
		}
	}
	
	/**
	 * @author Uma Sasmal
	 */
	public static void validateLoginErrorMsg() {
		try {
			DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginErrorMsg_xpath)));
			if(seleniumUtils.IsDisplayed(Locator.XPATH, loginErrorMsg_xpath)) {
				LogFileControl.logPass("Login Error Validation", "Login Error Message is displaying properly");
			}else {
				LogFileControl.logFail("Login Error Validation", "Login Error Message is not displaying properly");
			}
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("Fail due to exception "+e.getMessage());
		}
	}

}
