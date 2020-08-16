package com.Automation.HoroLab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import com.Automation.HoroLab.Locators.Locator;
import com.Automation.HoroLab.Locators.Selector;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;




//public class SeleniumUtils extends Base{

/**
 * @author Uma Sasmal
 *
 */
public class SeleniumUtils implements Utils {

	//		private WebDriverManager.getDriver() DriverManager.getDriver();
	//		//private Actions action;
	//		public SeleniumUtils(WebDriverManager.getDriver() DriverManager.getDriver()){
	//			this.DriverManager.getDriver()=DriverManager.getDriver();
	//			
	//		}
	//	
	
	static SuppotLibrary suppotLibrary = new SuppotLibrary();
	public static String noElementFound = "Element Not Found";
	public static String elementStatus = "No Such Element with ";
	
	/**
	 * @version 1.01
	 * @description 
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	WebElement webElement(Locator locatorType,String locatorValue){
		waitForPageLoad();
		WebElement element = null;
		try{
			//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
			element=DriverManager.getDriver().findElement(selector(locatorType,locatorValue));
		}catch(NoSuchElementException e){
			element = null;
		}catch (WebDriverException e1){
		}
		return element;

	}

	List<WebElement> webElements(Locator locatorType,String locatorValue){
		waitForPageLoad();
		List<WebElement> element= null;
		try{
			//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
			element=DriverManager.getDriver().findElements(selector(locatorType,locatorValue));
		}catch(NoSuchElementException e){
			element = null;
		}
		return element;
	}

	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#MoveToElement(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Move the cursor to the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#MoveToElement(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  void MoveToElement(Locator locatorType,String locatorValue){
		try{
			//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
			Actions action= new Actions(DriverManager.getDriver()); 
			action.moveToElement(webElement(locatorType,locatorValue)).build().perform();
		}catch(NoSuchElementException e){

		}
		catch(Exception e){

		}
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#DoubleClickToElement(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Double click on the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#DoubleClickToElement(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  void DoubleClickToElement(Locator locatorType,String locatorValue){
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				Actions action= new Actions(DriverManager.getDriver()); 
				action.moveToElement(webElement(locatorType,locatorValue)).doubleClick().build().perform();
			}catch(Exception e){}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 

	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Click(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Click on the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Click(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public  void Click(Locator locatorType,String locatorValue,String pageName,String elementName){
		WebElement element=webElement(locatorType,locatorValue);
		if(element==null){
			try {
				DriverManager.getDriver().switchTo().alert().accept();
			} catch (NoAlertPresentException e) {}
			element=webElement(locatorType,locatorValue);
		}
		if(element!=null){
			try{
				scrollToElementAllCondition(element);
				element.click();
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				Actions action= new Actions(DriverManager.getDriver()); 
				action.moveToElement(element).click().build().perform();
			}
			LogFileControl.logPass(pageName+" Page, Click on "+elementName, "Clicked");
//			LogFileControl.logInfo(pageName+" Page, Click on "+elementName, "Clicked");
			//                  ExtentTestManager.getlogger().log(LogStatus.INFO, pageName+" Page, Click on "+elementName, "Clicked");
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}


	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#WaitForElementToBeAvailable(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Wait for an element to be available
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#WaitForElementToBeAvailable(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  void WaitForElementToBeAvailable(Locator locatorType,String locatorValue){
		try{
			DriverManager.getWait().until(ExpectedConditions.presenceOfElementLocated(selector(locatorType,locatorValue)));
		}catch(Exception e){

		}
	}

	@Override
	public String DropDownSelect(Locator locatorType,String locatorValue,String dropdownValue,String pageName,String elementName) {
		try {
			waitForPageLoad();
			WebElement e = webElement(locatorType, locatorValue);
			Click(locatorType, locatorValue, pageName, elementName);
			waitForPageLoad();
			//e.click();
			int i=0;
			int s = Size(Locator.XPATH, "//div[@class='cdk-overlay-pane']/div/mat-option");
			if(s==0) {
				s = Size(Locator.XPATH, "//div[@class='cdk-overlay-pane']/div/div/mat-option");
			}
			int j =0,k;
			Thread.sleep(100);
			boolean flag = false;
			String text;
			try {
				text = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/mat-option[1]/span")).getText();
			} catch (Exception e2) {
				text = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/div/mat-option[1]/span")).getText();
			}
			if(text.toLowerCase().contains("none"))
				k=2;
				else
					k=1;
			while(s<k &&  i<=40) {
				Thread.sleep(1500);
				try {
					DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/mat-option[1]")).click();
				} catch (Exception e2) {
					DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/div/mat-option[1]")).click();
				}
				
				e.click();
				s = Size(Locator.XPATH, "//div[@class='cdk-overlay-pane']/div/mat-option");
				if(s==0) {
					s = Size(Locator.XPATH, "//div[@class='cdk-overlay-pane']/div/div/mat-option");
				}
				i++;
			}
			try {
				j =Integer.valueOf(dropdownValue);
				try {
					dropdownValue = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/mat-option["+j+"]/span")).getText();
					if(dropdownValue.toLowerCase().contains("none")) {
						j=j+1;
						Thread.sleep(500);
						dropdownValue = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/mat-option["+j+"]/span")).getText();
						
					}
					DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/mat-option["+j+"]")).click();
				} catch (Exception e2) {
					dropdownValue = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/div/mat-option["+j+"]/span")).getText();
					if(dropdownValue.toLowerCase().contains("none")) {
						j=j+1;
						Thread.sleep(500);
						dropdownValue = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/div/mat-option["+j+"]/span")).getText();
						
					}
					DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/div/mat-option["+j+"]")).click();
				}
				System.out.println(j);
			} catch (Exception e2) {
				WebElement e1 = webElement(Locator.XPATH, "//div[@class='cdk-overlay-pane']/div/mat-option/span[text()='"+dropdownValue+"']");
				if(e1==null) {
					e1=webElement(Locator.XPATH, "//div[@class='cdk-overlay-pane']/div/div/mat-option/span[text()='"+dropdownValue+"']");
				}
				if(e1==null) {
					e1=webElement(Locator.XPATH, "//span[contains(text(),'"+dropdownValue+"')]");
				}
				//div[@class='cdk-overlay-pane']/div/mat-option/span[text()='ODISHA']
				e1.click();
			}
			
			LogFileControl.logInfo(pageName, elementName+" selected as: "+dropdownValue);
		} catch (Exception e) {
			try {
				System.out.println(e.getMessage());
				LogFileControl.logFailwithScreenCapture(pageName, elementName+" : "+dropdownValue+" is not available");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			}
		}
		return dropdownValue;
	}
	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Clear(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Clear a Textbox
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Clear(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  void Clear(Locator locatorType,String locatorValue){
		try{
			WebElement element=webElement(locatorType,locatorValue);
			if(element==null){
				try {
					DriverManager.getDriver().switchTo().alert().accept();
				} catch (NoAlertPresentException e) {}
				element=webElement(locatorType,locatorValue);
			}
			if(element!=null){
				try{
					webElement(locatorType,locatorValue).clear();
					String value = null;
					try{
						value=GetAttribute(locatorType, locatorValue, "value");
					}catch(Exception e){}
					if(!value.equals(null)){
						DoubleClickToElement(locatorType, locatorValue);
						webElement(locatorType,locatorValue).sendKeys(Keys.chord(Keys.DELETE));
					}
				}catch(Exception e){
					
				}
			}else{
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} 
		}
		catch(Exception e){}
	}
	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#SendKeys(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Populate a Textbox
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param value Value with Textbox to be populated
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#SendKeys(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public  void SendKeys(Locator locatorType,String locatorValue,String value,String pageName,String elementName){
		WebElement element=webElement(locatorType,locatorValue);
		if(element==null){
			try {
				DriverManager.getDriver().switchTo().alert().accept();
			} catch (NoAlertPresentException e) {}
			element=webElement(locatorType,locatorValue);
		}
		if(element!=null){
			try{
				element.clear();
				element.sendKeys(Keys.chord(Keys.HOME));
				element.sendKeys(value);
			}catch(Exception e){
				element.clear();
				MoveToElement(locatorType,locatorValue);
				element.sendKeys(Keys.chord(Keys.HOME));
				element.sendKeys(value);
			}
			LogFileControl.logPass(pageName+" Page, "+elementName+" Text Box", "Data entered as "+value);
//			LogFileControl.logInfo(pageName+" Page, "+elementName+" Text Box", "Data entered as "+value);
			element.sendKeys(Keys.chord(Keys.TAB));
			waitForPageLoad();
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#SendKeys(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description perform keybord action like press TAB, HOME keys 
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param value Value with Textbox to be populated
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#SendKeysSpecialChar(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String)
	 */
	public  void SendKeysSpecialChar(Locator locatorType,String locatorValue,String value){
		WebElement element=webElement(locatorType,locatorValue);
		if(element==null){
			try {
				DriverManager.getDriver().switchTo().alert().accept();
			} catch (NoAlertPresentException e) {}
			element=webElement(locatorType,locatorValue);
		}
		if(element!=null){
			try{
				element.sendKeys(value);
			}catch(Exception e){
				MoveToElement(locatorType,locatorValue);
				element.sendKeys(value);
			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture("No Such Element: with "+locatorType+" :" +locatorValue, "Element Not Found");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Size(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns Size of the the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return int Size of the element(s)
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Size(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  int Size(Locator locatorType,String locatorValue){
		int size=0;
		try{
			size=webElements(locatorType,locatorValue).size();
		}catch(Exception e){}
		return size;
	}

	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsEnabled(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is enabled
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsEnabled(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  boolean IsEnabled(Locator locatorType,String locatorValue){
		boolean flag=false;
		try{
			if(webElement(locatorType,locatorValue).isEnabled()){
				flag=true;
			}
		}catch(NoSuchElementException e){
			flag=false;
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsDisplayed(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is displayed
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsDisplayed(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  boolean IsDisplayed(Locator locatorType,String locatorValue){
		boolean flag=false;
		try{
			if(webElement(locatorType,locatorValue).isDisplayed()){
				flag=true;
			}
		}catch(Exception e)
		{
			System.out.println();
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsSelected(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is selected from a dropdown
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsSelected(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  boolean IsSelected(Locator locatorType,String locatorValue){
		boolean flag=false;
		try{
			if(webElement(locatorType,locatorValue).isSelected()){
				flag=true;
			}
		}catch(Exception e){
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetText(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns the text of the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return String Text of the element
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetText(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  String GetText(Locator locatorType,String locatorValue){
		String text=null;
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				text=element.getText();
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				MoveToElement(locatorType, locatorValue);
				text=element.getText();
			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return text;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetAttribute(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Returns the value of the element attribute specified
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param attributeName Attribute whose value is required
	 * @return String Value of the element attribute specified
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetAttribute(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String)
	 */
	@Override
	public  String GetAttribute(Locator locatorType,String locatorValue,String attributeName){
		String text=null;
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				text=element.getAttribute(attributeName);
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				MoveToElement(locatorType, locatorValue);
				text=element.getAttribute(attributeName);
			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return text;
	}

	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetTagName(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns the tagname of the element specified
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return String Tagname of the element specified
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetTagName(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public  String GetTagName(Locator locatorType,String locatorValue){
		String text=null;
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				text=element.getTagName();
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				MoveToElement(locatorType, locatorValue);
				text=element.getTagName();
			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return text;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetCssValue(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Returns the CSSValue of the element specified
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param propertyName Property whose CSSValue is required
	 * @return String CSSValue of the element specified
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetCssValue(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String)
	 */
	@Override
	public  String GetCssValue(Locator locatorType,String locatorValue,String propertyName){
		String text=null;
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				text=element.getCssValue(propertyName);
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				MoveToElement(locatorType, locatorValue);
				text=element.getCssValue(propertyName);
			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return text;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Submit(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Submits the specified element 
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the page
	 * @param elementName Name of the element
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Submit(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public  void Submit(Locator locatorType,String locatorValue,String pageName,String elementName){
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				element.submit();
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				MoveToElement(locatorType, locatorValue);
				element.submit();
			}
			LogFileControl.logInfo(pageName+" Page, Click on "+elementName, "Clicked");
			//ExtentTestManager.getlogger().log(LogStatus.INFO, pageName+" Page, Click on "+elementName);
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	By selector(Locator locatorType,String locatorValue){
		By by = null;
		switch(locatorType){
		case CLASSNAME:
			by=By.className(locatorValue);
			break;
		case CSSSELECTOR:
			by=By.cssSelector(locatorValue);
			break;
		case ID:
			by=By.id(locatorValue);
			break;
		case LINKTEXT:
			by=By.linkText(locatorValue);
			break;
		case NAME:
			by=By.name(locatorValue);
			break;
		case PARTIALLINKTEXT:
			by=By.partialLinkText(locatorValue);
			break;
		case TAGNAME:
			by=By.tagName(locatorValue);
			break;
		case XPATH:
			by=By.xpath(locatorValue);
			break;
		default:
			break;
		}

		return by;

	}

	public Locator getLocator(String locatorType,String elementName){
		Locator loc = null;
		try {
			switch (locatorType) {
			case "ID":
				loc = Locator.ID;
				break;
			case "NAME":
				loc = Locator.NAME;
				break;
			case "CLASSNAME":
				loc = Locator.CLASSNAME;
				break;
			case "CSSSELECTOR":
				loc = Locator.CSSSELECTOR;
				break;
			case "LINKTEXT":
				loc = Locator.LINKTEXT;
				break;
			case "PARTIALLINKTEXT":
				loc = Locator.PARTIALLINKTEXT;
				break;
			case "TAGNAME":
				loc = Locator.TAGNAME;
				break;
			case "XPATH":
				loc = Locator.XPATH;
				break;
			default:
				
				LogFileControl.logFail("Locator Type Invalid","Web Element of the element "+elementName +" is not Proper" );;
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return loc;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Select(com.Automation.HoroLab.Locators.Locator, java.lang.String, com.Automation.HoroLab.Locators.Selector, java.lang.String)
	 * @Version 1.01
	 * @description Selects a value from drop down
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param selectType (By Value, By VisibleText, By Index )
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Select(com.Automation.HoroLab.Locators.Locator, java.lang.String, com.Automation.HoroLab.Locators.Selector, java.lang.String)
	 */
	@Override
	public  void Select(Locator locatorType,String locatorValue,Selector selectType,String value){
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				Select select=new Select(element);
				switch(selectType){
				case DESELECTALL:
					select.deselectAll();
					break;
				case DESELECTBYINDEX:
					select.deselectByIndex(Integer.parseInt(value.trim()));
					break;
				case DESELECTBYVALUE:
					select.deselectByValue(value);
					break;
				case DESELECTBYVISIBLTTEXT:
					select.deselectByVisibleText(value);
					break;
				case SELECTBYINDEX:
					select.selectByIndex(Integer.parseInt(value.trim()));
					LogFileControl.logInfo("Index Selected as "+value);
					break;
				case SELECTBYVALUE:
					select.selectByValue(value);
					LogFileControl.logInfo("Value Selected as "+value);
					break;
				case SELECTBYVISIBLTTEXT:
					select.selectByVisibleText(value);
					LogFileControl.logInfo("VisibleText Selected as "+value);
					break;
				default:
					break;

				}
			}catch(Exception e){
				try {
					LogFileControl.logFailwithScreenCapture("Not able to Select with "+selectType, "Select not Done with value "+value);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#getSelectedOption(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns the selected Option of specified drop down
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param attributeName Attribute whose value is required
	 * @return String Selected value from the drop down
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#getSelectedOption(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public String getSelectedOption(Locator locatorType,String locatorValue){
		String text = null;
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				Select select=new Select(element);
				WebElement option = select.getFirstSelectedOption();
				text=option.getText();
			}catch(Exception e){

			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return text;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#getAllDropDownOptions(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns all the available options under the specified drop down
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return List<String> All the available options under a drop down
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#getAllDropDownOptions(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public List<String> getAllDropDownOptions(Locator locatorType,String locatorValue){
		ArrayList<String> text = new ArrayList<String>();
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				Select select=new Select(element);
				List<WebElement> options = select.getOptions();
				for(int i=0;i<options.size();i++)
				{
					text.add(options.get(i).getText());
				}  
			}catch(Exception e){

			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return text;
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#verifyTitle(java.lang.String)
	 * @Version 1.01
	 * @description Verifies the title of the page with the expected title
	 * @param expectedTitle Expected Title
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#verifyTitle(java.lang.String)
	 */
	@Override
	public void verifyTitle(String expectedTitle){
		try{
			String title = DriverManager.getDriver().getTitle();
			if(expectedTitle.trim().equals(title.trim())){
				LogFileControl.logPass("Verify Title", "Title is displaying as Expected");
				//ExtentTestManager.getlogger().log(LogStatus.PASS, "Verify Title", "Title is displaying as Expected");
			}else{
				LogFileControl.logFail("Verify Title","Title is displaying as "+title+" ,It is not as Expected");
				//				ExtentTestManager.getlogger().log(LogStatus.FAIL, "Verify Title","Title is displaying as "+title+" ,It Is Expected");
			}
		}catch(Exception e){}
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#navigateToUrl(java.lang.String)
	 * @Version 1.01
	 * @description Navigates to the specified URL
	 * @param url URL to be navigated to
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#navigateToUrl(java.lang.String)
	 */
	@Override
	public void navigateToUrl(String url){
		try{
			DriverManager.getDriver().get(url);
		}catch(Exception e){}
	}

	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#verifyCurrentUrl(java.lang.String)
	 * @Version 1.01
	 * @description Verifies the Current URL with the expected
	 * @param expectedURL Expected URL
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#verifyCurrentUrl(java.lang.String)
	 */
	@Override
	public void verifyCurrentUrl(String expectedURL){
		try{
			String url = DriverManager.getDriver().getCurrentUrl();
			if(expectedURL.trim().equals(url.trim())){
				LogFileControl.logPass("Verify Current URL","Current URL is displaying as Expected");
				//				ExtentTestManager.getlogger().log(LogStatus.PASS, "Verify Current URL","Current URL is displaying as Expected");
			}else{
				LogFileControl.logFail("Verify Current URL","Current URL is displaying as "+url+" ,It Is Expected");
				//				ExtentTestManager.getlogger().log(LogStatus.FAIL, "Verify Current URL","Current URL is displaying as "+url+" ,It Is Expected");
			}
		}catch(Exception e){}
	}

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#waitForPageLoad()
	 * @Version 1.01
	 * @description Wait for the page to be loaded
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#waitForPageLoad()
	 */
	@Override
	public  void waitForPageLoad(){
		try{
			DriverManager.getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loader']")));
		}catch(Exception e){}
		try{
			Thread.sleep(50);
		}catch(Exception e){}
	}

	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#quitBrowser()
	 * @Version 1.01
	 * @description Quits the browser
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#quitBrowser()
	 */
	@Override
	public  void quitBrowser(){
		//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
		DriverManager.getDriver().quit();
	}

	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#isDisabled(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is disabled
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#isDisabled(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 */
	@Override
	public boolean isDisabled(Locator locatorType, String locatorValue){
		boolean flag = false;
		try{
			String classStatus = null,otherStatus = null;
			try{
				classStatus = GetAttribute(locatorType, locatorValue, "class").toLowerCase();
			}catch(Exception e){}
			try{
				otherStatus = GetAttribute(locatorType, locatorValue, "disabled").toLowerCase();
			}catch(Exception e){}
			if(classStatus.contains("disable") || otherStatus.contains("disable")|| otherStatus.contains("true")){
				flag = true;
			}
		}catch(Exception e){}
		return flag;
	}
	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#scrollToElement(org.openqa.selenium.WebElement)
	 */
	@Override
	public void scrollToElement(WebElement element){
		try{
			if(!isVisibleInViewport(element)){
				JavascriptExecutor je = (JavascriptExecutor) DriverManager.getDriver();
				je.executeScript("arguments[0].scrollIntoView(true);",element);
			}
		}catch(Exception e){}

	}
	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#scrollToElementAllCondition(org.openqa.selenium.WebElement)
	 */
	@Override
	public void scrollToElementAllCondition(WebElement element){
		try{
//			if(!isVisibleInViewport(element)){
				JavascriptExecutor je = (JavascriptExecutor) DriverManager.getDriver();
				je.executeScript("arguments[0].scrollIntoView()", element); 
//			}
		}catch(Exception e){}

	}
	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#isVisibleInViewport(org.openqa.selenium.WebElement)
	 */
	@Override
	public Boolean isVisibleInViewport(WebElement element) {
		return (Boolean)((JavascriptExecutor)DriverManager.getDriver()).executeScript(
				"var elem = arguments[0],                 " +
						"  box = elem.getBoundingClientRect(),    " +
						"  cx = box.left + box.width / 2,         " +
						"  cy = box.top + box.height / 2,         " +
						"  e = document.elementFromPoint(cx, cy); " +
						"for (; e; e = e.parentElement) {         " +
						"  if (e === elem)                        " +
						"    return true;                         " +
						"}                                        " +
						"return false;                            "
						, element);
	}  
	
	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#ClickwithScroll(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Click on an element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the Page
	 * @param elementName Name of the element
	 */
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#ClickwithScroll(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public  void ClickwithScroll(Locator locatorType,String locatorValue,String pageName,String elementName){
		WebElement element=webElement(locatorType,locatorValue);
		if(element==null){
			waitForPageLoad();
			element=webElement(locatorType,locatorValue);
		}
		if(element!=null){
			try{
				MoveToElement(locatorType, locatorValue);
				scrollToElement(element);
				element.click();
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				Actions action= new Actions(DriverManager.getDriver()); 
				action.moveToElement(element).click().build().perform();
			}
			if(elementName.startsWith("Log")|| elementName.startsWith("log")){
				DriverManager.getWait().until(ExpectedConditions.alertIsPresent());
				DriverManager.getDriver().switchTo().alert().accept();
			}else{
				waitForPageLoad();
			}
			LogFileControl.logInfo(pageName+" Page, Click on "+elementName, "Clicked");
			//                  ExtentTestManager.getlogger().log(LogStatus.INFO, pageName+" Page, Click on "+elementName, "Clicked");
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//                  ExtentTestManager.getlogger().log(LogStatus.FAIL, elementStatus+locatorType+" :" +locatorValue, noElementFound );
		} 
	}
	
	public int invocationCount(ITestContext testContext,String ScriptId){
		int invocationCount = 0;
		int size = testContext.getAllTestMethods().length;
		for(int i =0;i<size;i++){
			if(ScriptId.contentEquals(testContext.getAllTestMethods()[i].getMethodName())){
				invocationCount=testContext.getAllTestMethods()[i].getCurrentInvocationCount()+1;
				break;
			}
		}
		return invocationCount;
	}
	
	public void waitforVisibilityOfElement(Locator locatorType,String locatorValue){
		By element = selector(locatorType,locatorValue);
		DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void waitforElementToBeClickable(Locator locatorType,String locatorValue){
		By element = selector(locatorType,locatorValue);
		DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitforElementToBeSelected(Locator locatorType,String locatorValue){
		By element = selector(locatorType,locatorValue);
		DriverManager.getWait().until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waitforInvisibilityOfElement(Locator locatorType,String locatorValue){
		By element = selector(locatorType,locatorValue);
		DriverManager.getWait().until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	
	@Override
	public void takeScreenshot() {
		// TODO Auto-generated method stub
		try {
			ExtentTestManager.getlogger().log(LogStatus.INFO, "ScreenShot Captured", "User Selected Screenshot" +ExtentTestManager.getlogger().addScreenCapture(suppotLibrary.screenCapture(DriverManager.getDriver(),LogFileControl.getScriptId_report())));
			//			ExtentTestManager.getlogger().addScreenCapture(suppotLibrary.screenCapture(DriverManager.getDriver(),LogFileControl.getScriptId_report()));
		} catch (Exception e) {
			// TODO: handle exception
		}	}

}

