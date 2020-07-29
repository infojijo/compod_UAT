package com.cjnet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * cjnet News app automation
 * 
 */
/*
 */

public class CompodActionsTest {

	private AndroidDriver<MobileElement> androidDriver;
	private String output;

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
	}

	@AfterMethod
	@AfterTest
	public void tearDown() {
		androidDriver.quit();
	}



	@Test(priority = 1)
	public void checkAlreadyMarked() throws InterruptedException {

		try {
			waitCommon();
			androidDriver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
			Thread.sleep(3000);
			androidDriver.findElementById("com.cjnet.news:id/text_google").click();
			Thread.sleep(3000);
			androidDriver.findElementById("com.google.android.gms:id/account_name").click();
			Thread.sleep(3000);
			androidDriver.navigate().back();
			Thread.sleep(3000);

			List<MobileElement> gridItems =  androidDriver.findElementsById("com.cjnet.news:id/imgGrid");
			Thread.sleep(3000);
			System.out.println("items here->"+gridItems.size());
			gridItems.get(2).click();	
			waitCommon();
			androidDriver.findElementById("com.cjnet.news:id/textTitle").click();
			waitCommon();
			String first = androidDriver.findElementById("com.cjnet.news:id/btn_mark_as_read").getText();
			System.out.println(first);
			waitCommon();

			if (first.equals( "MARK"))
			{
				androidDriver.findElementById("com.cjnet.news:id/btn_mark_as_read").click();
				waitCommon();

			}
			else {
				System.out.println("Already Marked as Read");
			}
			String afterclicked = androidDriver.findElementById("com.cjnet.news:id/btn_mark_as_read").getText();

			assert afterclicked.equals("MARKED AS READ") : " MARKED, SUCCESS : " + first + "Expected : MARKED AS READ";

			System.out.println("PRINTING THE RESULT");
			Thread.sleep(3000);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	public void waitCommon() {

		androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


}
