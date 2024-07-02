package com.orangehrm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.test.BaseTest;
import com.report.ExtentReportUtils;

public class LoginPage {
	
	//username
	@FindBy(name= "username")
	WebElement userNameTextBox;
	
	//password
	@FindBy(name= "password")
	WebElement pwdTextBox;
	
	//login
	@FindBy(xpath= "button[@type='submit']")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	//Log4J Logger 
	Logger log= LogManager.getLogger(LoginPage.class);
	
	public void loginToApplication(String username, String password) {
		userNameTextBox.sendKeys(username);
		log.info("Username is entered in username text box");    //log4j
		ExtentReportUtils.addStep("Username is entered");        //ExtentReport
		
		pwdTextBox.sendKeys(password);
		log.info("Password is entered in password textbox.");     //log4j
		ExtentReportUtils.addStep("Password value is entered");   //ExtentReport
		
		loginButton.click();
		log.info("Login button is clicked");     //log4j
		ExtentReportUtils.addStep("Login button is clicked");    //ExtentReport
	}

}
