package com.Automation.HoroLab;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;

import com.Automation.HoroLab.Locators.Locator;
import com.Automation.HoroLab.Locators.Selector;


public interface Utils {

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#MoveToElement(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Move the cursor to the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	void MoveToElement(Locator locatorType, String locatorValue);

	/* @see com.Automation.HoroLab.Utils#DoubleClickToElement(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * Double click on the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	void DoubleClickToElement(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Click(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Click on the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	void Click(Locator locatorType, String locatorValue, String pageName, String elementName);

	/* @see com.Automation.HoroLab.Utils#WaitForElementToBeAvailable(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 *Wait for an element to be available
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	void WaitForElementToBeAvailable(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Clear(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Clear a Textbox
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	void Clear(Locator locatorType, String locatorValue);

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
	void SendKeys(Locator locatorType, String locatorValue, String value, String pageName, String elementName);
	
	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#SendKeysSpecialChar(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description perform keybord action like press TAB, HOME keys 
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param value Value with Textbox to be populated
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	void SendKeysSpecialChar(Locator locatorType, String locatorValue, String value);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Size(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns Size of the the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return int Size of the element(s)
	 */
	int Size(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsEnabled(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is enabled
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	boolean IsEnabled(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsDisplayed(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is displayed
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	boolean IsDisplayed(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#IsSelected(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is selected from a dropdown
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	boolean IsSelected(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetText(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns the text of the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return String Text of the element
	 */
	String GetText(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetAttribute(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Returns the value of the element attribute specified
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param attributeName Attribute whose value is required
	 * @return String Value of the element attribute specified
	 */
	String GetAttribute(Locator locatorType, String locatorValue, String attributeName);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetTagName(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns the tagname of the element specified
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return String Tagname of the element specified
	 */
	String GetTagName(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#GetCssValue(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Returns the CSSValue of the element specified
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param propertyName Property whose CSSValue is required
	 * @return String CSSValue of the element specified
	 */
	String GetCssValue(Locator locatorType, String locatorValue, String propertyName);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Submit(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Submits the specified element 
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the page
	 * @param elementName Name of the element
	 */
	void Submit(Locator locatorType, String locatorValue, String pageName, String elementName);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#Select(com.Automation.HoroLab.Locators.Locator, java.lang.String, com.Automation.HoroLab.Locators.Selector, java.lang.String)
	 * @Version 1.01
	 * @description Selects a value from drop down
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param selectType (By Value, By VisibleText, By Index )
	 */
	void Select(Locator locatorType, String locatorValue, Selector selectType, String value);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#getSelectedOption(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns the selected Option of specified drop down
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param attributeName Attribute whose value is required
	 * @return String Selected value from the drop down
	 */
	String getSelectedOption(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#getAllDropDownOptions(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns all the available options under the specified drop down
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return List<String> All the available options under a drop down
	 */
	List<String> getAllDropDownOptions(Locator locatorType, String locatorValue);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#verifyTitle(java.lang.String)
	 * @Version 1.01
	 * @description Verifies the title of the page with the expected title
	 * @param expectedTitle Expected Title
	 */
	void verifyTitle(String expectedTitle);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#navigateToUrl(java.lang.String)
	 * @Version 1.01
	 * @description Navigates to the specified URL
	 * @param url URL to be navigated to
	 */
	void navigateToUrl(String url);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#verifyCurrentUrl(java.lang.String)
	 * @Version 1.01
	 * @description Verifies the Current URL with the expected
	 * @param expectedURL Expected URL
	 */
	void verifyCurrentUrl(String expectedURL);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#waitForPageLoad()
	 * @Version 1.01
	 * @description Wait for the page to be loaded
	 */
	void waitForPageLoad();

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#quitBrowser()
	 * @Version 1.01
	 * @description Quits the browser
	 */
	void quitBrowser();

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#isDisabled(com.Automation.HoroLab.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is disabled
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	boolean isDisabled(Locator locatorType, String locatorValue);

	/**
	 * @author uma.sasmal
	 * @param element Element to be scrolled upto
	 * @description to scroll upto the element
	 */
	void scrollToElement(WebElement element);

	/**
	 * @author uma.sasmal
	 * @param element Element to be scrolled upto
	 * @description to scroll upto the element
	 */
	void scrollToElementAllCondition(WebElement element);

	/**
	 * @author uma.sasmal
	 * @param element Element to be checked if present
	 * @description To check if element is present
	 */
	Boolean isVisibleInViewport(WebElement element);

	/* (non-Javadoc)
	 * @see com.Automation.HoroLab.Utils#ClickwithScroll(com.Automation.HoroLab.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Click on an element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the Page
	 * @param elementName Name of the element
	 */
	void ClickwithScroll(Locator locatorType, String locatorValue, String pageName, String elementName);
	
	int invocationCount(ITestContext testContext,String ScriptId);
	
	void waitforVisibilityOfElement(Locator locatorType,String locatorValue);
	
	void waitforElementToBeClickable(Locator locatorType,String locatorValue);
	
	void waitforElementToBeSelected(Locator locatorType,String locatorValue);
	
	void waitforInvisibilityOfElement(Locator locatorType,String locatorValue);
}