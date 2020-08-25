package com.cjnet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;


//{
//	"app": "/Users/remyaabraham/Library/Developer/Xcode/DerivedData/WebDriverAgent-alwvnomvwrdtzoaxbbkniqrpcdpp/Build/Products/Debug-iphonesimulator/IntegrationApp.app",
//	"platformName": "iOS",
//	"deviceName": "iPhone 11",
//	"automationName": "XCUITest"
//}

public class iOS_NativeAPP_Test1 {
	
public WebDriverWait wait;
	
	@Test
	public void TestBrowser() throws MalformedURLException, InterruptedException {
		
		  DesiredCapabilities cap = new DesiredCapabilities();
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		  
		  cap.setCapability("platformName", "iOS");
		  cap.setCapability("platformVersion", "13.2");
		  cap.setCapability("deviceName", "iPhone 11");  
		  cap.setCapability("app", "/Users/remyaabraham/Library/Developer/Xcode/DerivedData/WebDriverAgent-alwvnomvwrdtzoaxbbkniqrpcdpp/Build/Products/Debug-iphonesimulator/IntegrationApp.app");
		  cap.setCapability("automationName", "XCUITest");
		  
	 
		  IOSDriver iOSDriver = new IOSDriver<>(url,cap);
		  wait = new WebDriverWait(iOSDriver,20);	  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Attributes")));
		  //iOSDriver.findElement(By.name("Attributes")).sendKeys("admin");
		  iOSDriver.findElement(By.name("Attributes")).click();

		  		  
		  
	}
	

}
