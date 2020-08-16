package com.Automation.HoroLab;


import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Automation.HoroLab.SuppotLibrary;
import com.relevantcodes.extentreports.LogStatus;

public class Base {

	public static Utils seleniumUtils = new SeleniumUtils();
	public static DriverManager driverManager = new DriverManager();
	public static ReadCSV readCSV = new ReadCSV();
	public static SuppotLibrary suppotLibrary = new SuppotLibrary();
	public static WriteConfig writeConfig = new WriteConfig();
	public static ThreadLocal<String> threadscriptId=new ThreadLocal<String>() ;
	public static ThreadLocal<String> threadmethodName=new ThreadLocal<String>() ;
	public static DataProvider dataProvider= new DataProvider();
	static Base base=new Base();
	public static String url=null , browser = null, environment = null, group = null,parallelCount =null;
	//	public static ExtentReports extentReports;

	public static String getScriptId(){
		return (threadscriptId.get());
	}
	public static void setScriptId(String value) {
		threadscriptId.set(new String(value));
		LogFileControl.setScriptId_report(value);
	}


	private static final ThreadLocal<String> csvFileName = new ThreadLocal<String>();

	public static String getCSVFileName() {
		return (csvFileName.get());
	}

	public void setCSVFileName(String value) {
		csvFileName.set(new String(value));
	}

	public static String getPropertyData(String key){

		String value=dataProvider.getPropertyvalue("DataStore",key);
		return value;

	}
	public static void storeData(String key,String value){

		writeConfig.writeData(key,value,"DataStore");
	}
	
	@SuppressWarnings("deprecation")
	@BeforeSuite(alwaysRun=true)
	public void extentSetup(ITestContext context) {
		try {
			ExtentManager.setOutputDirectory(context);
			ExtentTestManager.extent = ExtentManager.getInstance();
			org.apache.log4j.PropertyConfigurator.configure(System.getProperty("user.dir") + "\\Log4j.properties");
			LogFileControl.logInfo(context.getSuite().getName()+" Suite Started");
			group=System.getProperty("groupToRun");
			//System.out.println("Group is " +group);
			String group1=System.getProperty("groupToRun1");
			//System.out.println("Group is " +group1);
			url=System.getProperty("url");
			//System.out.println("URL is " +url);
			browser = System.getProperty("browser");
			environment = System.getProperty("environment");
			parallelCount=System.getProperty("threadCount");
//			parallelCount="3";
			if(parallelCount==null){
				context.getSuite().getXmlSuite().setParallel(System.getProperty("parallel", "false"));
			}else{
				context.getSuite().getXmlSuite().setParallel("classes");
				if(Integer.valueOf(parallelCount)>10){
					context.getSuite().getXmlSuite().setThreadCount(10);
				}else{
					context.getSuite().getXmlSuite().setThreadCount(Integer.valueOf(parallelCount));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

//	@BeforeClass(alwaysRun=true)
	protected void testClassStart(ITestContext context){
		try{
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@BeforeMethod (alwaysRun=true)
	protected void testMethodStart(Method method){
		try{
			if(browser!=null){
				DriverManager.setupDriver(browser);
			}else{
				DriverManager.setupDriver("Chrome");
			}
			if(url!=null){
				DriverManager.getDriver().get(url);
			}else{
				DriverManager.getDriver().get("http://qa.horolab.in/#/ecommerce/home");
			}
			LogFileControl.logInfo("test method........  "+this.getClass().getName()+"  ............  "+method.getName()+"  ............  "+DriverManager.getDriver());
//			System.out.println("test method........  "+this.getClass().getName()+"  ............  "+method.getName()+"  ............  "+DriverManager.getDriver()+".........."+Thread.currentThread().getId());
			setScriptId(method.getName());
			ExtentTestManager.setlogger(ExtentTestManager.startTest(getScriptId()));
			System.out.println(".............UmaSasmal...............");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun=true)
	public void testMethodEnd(ITestResult result){
		try{
			if(result.getStatus() == ITestResult.FAILURE){
				System.out.println("TEST******");
			}
			ExtentTestManager.getlogger().log(LogStatus.INFO, "Last Visible Screen of Current Execution", "Final Screenshot" +ExtentTestManager.getlogger().addScreenCapture(suppotLibrary.screenCapture(DriverManager.getDriver(),getScriptId())));
			ExtentTestManager.endTest();  // new
			ExtentTestManager.extent.flush();
			tearDown();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@AfterClass(alwaysRun=true)
	public void tearDown(){
		try {
			DriverManager.quitDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite(ITestContext context) {
		try{
			ExtentTestManager.extent.close();
			LogFileControl.logInfo(context.getSuite().getName()+" Suite Ended");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public String getCSVData(String colmnName) throws Exception{
		String data = null;
		try{

			data = readCSV.getCSVValue(Base.getCSVFileName(),Base.getScriptId(),colmnName,1);
		}catch(Exception e){}
		return data;
	}


	
}


	









