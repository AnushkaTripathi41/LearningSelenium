package com.orangehrm.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.test.BaseTest;
import com.report.ExtentReportUtils;


public class HomePage {
	
	@FindBy(xpath= "span[text()='Admin']")
	WebElement adminLink;
	
	@FindBy(xpath= "img[@alt='profile picture']")
	WebElement profilePic;
	
	@FindBy(linkText= "Logout")
	WebElement logoutLink;
	
	public HomePage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	 Logger log= LogManager.getLogger(HomePage.class);   //log4j
	
	public void clickOnAdminLink() {
		adminLink.click();
		log.info("Admin link is clicked.");
	}
	
	public void logoutFromApplication() {
		profilePic.click();
		log.info("Profile picture is clicked");   //log4j
		ExtentReportUtils.addStep("Profile picture is clicked.");   //ExtentReport
		
		logoutLink.click();
		log.info("Logout succefully done");              //log4j
		ExtentReportUtils.addStep("Logout is done");     //ExtentReport
	}

}
