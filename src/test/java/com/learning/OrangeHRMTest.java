package com.learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	ChromeDriver driver;
	
	@Test
	public void login() {
		
		//open chrome
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		//open application
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//enter username
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		//enter password
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		//click login button
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
			
	}
	
	@Test
	public void testAdmin() {
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		boolean isDisplayedStatus= driver.findElement(By.xpath("//h5[text()='System Users']")).isDisplayed();
		
		Assert.assertTrue(isDisplayedStatus);
	}
	
	@Test
	public void testLogout() {
		
		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
