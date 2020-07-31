package com.cjnet;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseConfiguraion {

	public AndroidDriver<MobileElement> androidDriver;
	public WebDriverWait wait;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		desiredCapabilities.setCapability("autoGrantPermissions", true);
		desiredCapabilities.setCapability("appPackage", "com.cjnet.news");
		desiredCapabilities.setCapability("appActivity","com.cjnet.news.MainActivity");
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		androidDriver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
		wait = new WebDriverWait(androidDriver,20);
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		androidDriver.quit();
	}

	
}
