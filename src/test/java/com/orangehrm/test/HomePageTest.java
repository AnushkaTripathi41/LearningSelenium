package com.orangehrm.test;

import com.orangehrm.pages.HomePage;

public class HomePageTest extends BaseTest {
	
	public void logout() {
		
		HomePage homePage=new HomePage();
		homePage.logoutFromApplication();
	}

}
