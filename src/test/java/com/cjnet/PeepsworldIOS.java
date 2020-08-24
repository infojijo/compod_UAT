package com.cjnet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class PeepsworldIOS {
	
	public WebDriverWait wait;
	
	@Test
	public void TestBrowser() throws MalformedURLException, InterruptedException {
		
		 DesiredCapabilities cap = new DesiredCapabilities();
		 
		 
		  
		  cap.setCapability("platformName", "iOS");
		  cap.setCapability("platformVersion", "13.2");
		  cap.setCapability("deviceName", "iPhone 11");
		  cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
		  //cap.setCapability("app", "/Users/remyaabraham/Library/Developer/Xcode/DerivedData/WebDriverAgent-alwvnomvwrdtzoaxbbkniqrpcdpp/Build/Products/Debug-iphonesimulator/IntegrationApp.app");
		 
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		  IOSDriver iOSDriver = new IOSDriver<>(url,cap);
	
		  wait = new WebDriverWait(iOSDriver,20);
		  
		  iOSDriver.get("http://cjnet.in/news");
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='username']"))); 		  
		  //iOSDriver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"username\"]")).sendKeys("admin");		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		  
		  iOSDriver.findElement(By.name("username")).sendKeys("admin");
		  iOSDriver.findElement(By.name("password")).sendKeys("admin2020");
		  iOSDriver.findElement(By.name("login")).click();

		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Content")));	  
		  iOSDriver.findElement(By.linkText("Add Content")).click();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("contentTitle")));	  
		  iOSDriver.findElement(By.name("contentTitle")).sendKeys("Automation Input - Title");
		  iOSDriver.findElement(By.name("contentCategory")).click();
		  iOSDriver.findElement(By.name("contentForKids")).click();
		  List<MobileElement> shownList = iOSDriver.findElements(By.name("contentShown"));
		  shownList.get(1).click(); 
		  iOSDriver.findElement(By.name("contentIsNews")).click();		  
		  iOSDriver.findElement(By.name("contentSubText")).sendKeys("Automation Input - Sub Title");
		  
		  iOSDriver.findElement(By.name("submit")).click();			  
		  
	}
	

}
