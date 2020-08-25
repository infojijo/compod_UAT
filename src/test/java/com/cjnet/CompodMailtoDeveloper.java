package com.cjnet;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CompodMailtoDeveloper extends BaseConfiguration{
	@Test

	public void mailDeveloper()
	{
		try
		{

			waitExcplicit(1,"com.cjnet.news:id/fab");
			actionClick(1, "com.cjnet.news:id/fab");	
			//commented because these lines wont work in emulator.
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("android:id/icon")));
			//androidDriver.findElementById("android:id/icon").click();
			waitExcplicit(1, "com.google.android.gm:id/send");
			actionClick(1, "com.google.android.gm:id/send");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}

