package com.cjnet;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class PeepsworldIOS {
	
	
	@Test
	public void TestBrowser() throws MalformedURLException {
		
		 DesiredCapabilities cap = new DesiredCapabilities();
		  
		  cap.setCapability("platformName", "iOS");
		  cap.setCapability("platformVersion", "13.2");
		  cap.setCapability("deviceName", "iPhone 11");
		  //cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
		  cap.setCapability("app", "/Users/remyaabraham/Library/Developer/Xcode/DerivedData/WebDriverAgent-alwvnomvwrdtzoaxbbkniqrpcdpp/Build/Products/Debug-iphonesimulator/IntegrationApp.app");
		 
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		  IOSDriver iOSDriver = new IOSDriver(url,cap);
		
	
		  
		  
		  
		  
		  
	}
	

}
