package com.orangehrm.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.utility.ExcelUtility;
import com.utility.PropertiesUtility;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginWithValidUsernameAndValidPassword() throws InvalidFormatException, IOException {
		
		LoginPage loginPage=new LoginPage();
		//loginPage.loginToApplication(ExcelUtility.getTestData(1, 0), ExcelUtility.getTestData(1, 1));
		
		loginPage.loginToApplication(PropertiesUtility.getData("username"), PropertiesUtility.getData("password"));
	}

}
