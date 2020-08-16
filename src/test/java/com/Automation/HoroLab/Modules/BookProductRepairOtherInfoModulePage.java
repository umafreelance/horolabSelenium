package com.Automation.HoroLab.Modules;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.CommonUtil;
import com.Automation.HoroLab.DriverManager;
import com.Automation.HoroLab.LogFileControl;
import com.Automation.HoroLab.Locators.Locator;

public class BookProductRepairOtherInfoModulePage extends Base{
	
	public static final String warentyYes_xpath="//span[contains(text(),'Product Warra')]/following::div[6]";
	public static final String warentyCard_xpath="//span[contains(text(),'arranty Card Im')]/following::input[1]";
	public static final String remarks_xpath="//textarea[@formcontrolname='warrantyRemarks']";
	public static final String NoProductRerepair_xpath="//span[contains(text(),'ReRepai')]/following::div[12]";
	public static final String blockDetails_xpath="//span[text()='Block Details']";
	public static final String BlockDetaisKeyBoard_xpath="//span[contains(text(),'KEYBOARD')]";
	
	public static final String Selectphenomenondetails_xpath="//span[contains(text(),'KB-ALL KEYS CANNOT MAKE SO')]";
	public static final String GetPhenomenon_xpath="//span[contains(text(),'Get')]";
	public static final String PhenomenonDetails_xpath="//span[contains(text(),'Phenomenon Details')]";
	public static final String AccessoryDetails_xpath="//mat-select[@formcontrolname='accessoriesIds']";
	public static final String nextButton_xpath="(//span[contains(text(),'Next')])[2]";
//	public static final String ProductCompany_xpath="//mat-select[@formcontrolname='brandId']";
//	public static final String ProductCompany_xpath="//mat-select[@formcontrolname='brandId']";
//	public static final String ProductCompany_xpath="//mat-select[@formcontrolname='brandId']";
	
	/**
	 * @author Uma Sasmal
	 * @throws Exception 
	 */
	
	
	public static void otherInfoEnter() {
		try {
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, warentyYes_xpath);
			seleniumUtils.Click(Locator.XPATH, warentyYes_xpath, "Öther Info", "Yes");
			WebElement WarentyCardUpload = DriverManager.getDriver().findElement(By.xpath(warentyCard_xpath));
			String path=System.getProperty("user.dir") +"\\Attachment\\frontImage.jpg";
			WarentyCardUpload.sendKeys(path);
			seleniumUtils.SendKeys(Locator.XPATH, remarks_xpath, "My Keyboard is not working", "Öther Info", "Remarks");
			seleniumUtils.Click(Locator.XPATH, NoProductRerepair_xpath, "Öther Info", "No Product Rerepair");
			Thread.sleep(2000);
			seleniumUtils.DropDownSelect(Locator.XPATH, blockDetails_xpath, "KEYBOARD", "Öther Info", "Block Deatils");
			Thread.sleep(3000);
			CommonUtil.tabPress();
			seleniumUtils.Click(Locator.XPATH, GetPhenomenon_xpath, "Öther Info", "Get Phenomenon");
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, PhenomenonDetails_xpath);
			Thread.sleep(3000);
			seleniumUtils.DropDownSelect(Locator.XPATH, PhenomenonDetails_xpath, "KB-ALL KEYS CANNOT MAKE SO", "Öther Info", "Phenomenon Details");
			CommonUtil.escPress();
			Thread.sleep(3000);
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, AccessoryDetails_xpath);
			seleniumUtils.DropDownSelect(Locator.XPATH, AccessoryDetails_xpath, "SLIDE CASES", "Öther Info", "Accessory Details");
			CommonUtil.escPress();
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, nextButton_xpath);
			seleniumUtils.Click(Locator.XPATH, nextButton_xpath, "Öther Info", "Next");
		} catch (Exception e) {
			LogFileControl.logFail("Book Product","Fail due to exception "+e.getMessage());
		}
	}


}
