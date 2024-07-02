package com.learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMSauceLabsCloud {
	
	RemoteWebDriver driver;
	
	@Test
	public void login() throws MalformedURLException {
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", "oauth-tripathianushka41-8993b");
		sauceOptions.put("accessKey", "059d4b32-6246-406b-a964-afad5dac10d4");
		sauceOptions.put("build", "MavenProject");
		sauceOptions.put("name", "Sanity test");
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		
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
