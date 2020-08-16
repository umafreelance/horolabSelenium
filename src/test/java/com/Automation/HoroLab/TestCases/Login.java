package com.Automation.HoroLab.TestCases;

import org.testng.annotations.Test;

import com.Automation.HoroLab.Base;
import com.Automation.HoroLab.Modules.LoginPage;

public class Login extends Base{

	
	@Test(priority=0, description="Verify Login with Valid Username and Valid Password")
	public void Tc_Login_001() {
		LoginPage.logIn("pawan", "punshegde");
		LoginPage.validateHomePage();
		//homePage.logOut();
	}
	
	@Test(priority=1, description="Verify Login with Valid Username and Invalid Password")
	public void Tc_Login_002() {
		LoginPage.logIn("", "");
		LoginPage.validateLoginErrorMsg();
	}
}
