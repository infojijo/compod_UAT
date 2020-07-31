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
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("android:id/icon")));
			androidDriver.findElementById("android:id/icon").click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.google.android.gm:id/send")));
			androidDriver.findElementById("com.google.android.gm:id/send").click();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}

