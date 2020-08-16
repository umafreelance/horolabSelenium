package com.Automation.HoroLab.Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.CommonUtil;
import com.Automation.HoroLab.DriverManager;
import com.Automation.HoroLab.Locators.Locator;
import com.Automation.HoroLab.LogFileControl;

public class BookProductRepairModulePage extends Base{

	
	public static final String bookProductLink_xpath="//span[contains(text(),'Book Produc')]";
	public static final String ProductCompany_xpath="//mat-select[@formcontrolname='brandId']";
	public static final String ProductCategory_xpath="//mat-select[@formcontrolname='itemCategoryId']";
	public static final String ModelNumber_xpath="//input[@placeholder='Model No']";
	public static final String ClaimModel_xpath="//input[@placeholder='Claimed Model']";
	public static final String SerialNo_xpath="//input[@placeholder='Serial No']";
	public static final String CustomerProductReference_xpath="//input[@placeholder='Customer Product Reference No']";
	public static final String CaliberNo_xpath="//input[@placeholder='Caliber No']";
	public static final String BackCoverNo_xpath="//input[@placeholder='Back Cover No']";
	public static final String FrontImage_xpath="//input[@placeholder='Upload Front Image...']";
	public static final String BackImage_xpath="//input[@placeholder='Upload Back Image...']";
	public static final String SideImage_xpath="//input[@placeholder='Upload Side Image...']";
	public static final String NextButton_xpath="(//button//span[contains(text(),'Next')])[1]";
	
	/**
	 * @author Uma Sasmal
	 */
	public static void bookProductRepairClick() {
		try {
			if(seleniumUtils.IsDisplayed(Locator.XPATH, bookProductLink_xpath)) {
				LogFileControl.logInfo("Landing Page", "Book Product Repair is Displaying");
				seleniumUtils.Click(Locator.XPATH, bookProductLink_xpath, "Landing Page", "Book Product");
				seleniumUtils.waitforVisibilityOfElement(Locator.XPATH, NextButton_xpath);
				if(seleniumUtils.IsEnabled(Locator.XPATH, NextButton_xpath)) {
					LogFileControl.logInfo("Book Product","Next Button is Enabled");
				}else {
					LogFileControl.logFail("Book Product","Next Button is not Enabled");
				}
			}else {
				LogFileControl.logFail("Landing Page", "Book Product Repair is Not Displaying");
			}
		} catch (Exception e) {
			LogFileControl.logFail("Book Product","Fail due to exception "+e.getMessage());
		}
	}
	public static void bookProductRepairProductInfo() {
		try {
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, ProductCompany_xpath);
			seleniumUtils.DropDownSelect(Locator.XPATH, ProductCompany_xpath, "CASIO", "Product Info", "Product Company");
			seleniumUtils.waitforElementToBeClickable(Locator.XPATH, ProductCategory_xpath);
			seleniumUtils.DropDownSelect(Locator.XPATH, ProductCategory_xpath, "CALCULATOR", "Product Info", "Product Category");
			String modelNumber = CommonUtil.randomName(10);
			seleniumUtils.SendKeys(Locator.XPATH, ModelNumber_xpath, modelNumber, "Product Info", "Model Number");
			seleniumUtils.SendKeys(Locator.XPATH, ClaimModel_xpath, "UMACLAIM", "Product Info", "Claim Model");
			seleniumUtils.SendKeys(Locator.XPATH, SerialNo_xpath, "7897894564", "Product Info", "Serial Number");
			Thread.sleep(3000);
			seleniumUtils.SendKeys(Locator.XPATH, CustomerProductReference_xpath, "UmaReference9090", "Product Info", "Customer Product Reference");
			seleniumUtils.SendKeys(Locator.XPATH, CaliberNo_xpath, "UmaCaliber123", "Product Info", "Caliber Number");
			seleniumUtils.SendKeys(Locator.XPATH, BackCoverNo_xpath, "UmaCaliber1232", "Product Info", "Back Cover Number");
			Thread.sleep(3000);
			WebElement upload = DriverManager.getDriver().findElement(By.xpath(FrontImage_xpath));
			WebElement uploadBack = DriverManager.getDriver().findElement(By.xpath(BackImage_xpath));
			WebElement uploadSide = DriverManager.getDriver().findElement(By.xpath(SideImage_xpath));
			String path=System.getProperty("user.dir") +"\\Attachment\\frontImage.jpg";
			String pathBack=System.getProperty("user.dir") +"\\Attachment\\BackImage.jpg";
			String pathSide=System.getProperty("user.dir") +"\\Attachment\\sideImage.jpg";
	        // Enter the file path onto the file-selection input field
	        upload.sendKeys(path);
	        uploadBack.sendKeys(pathBack);
	        uploadSide.sendKeys(pathSide);
	        seleniumUtils.waitforElementToBeClickable(Locator.XPATH, NextButton_xpath);
	        seleniumUtils.Click(Locator.XPATH, NextButton_xpath, "Product Info", "Next Button");

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
