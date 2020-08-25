package com.cjnet;


import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * cjnet News app automation
 * 
 */
/*
 */

public class CompodActionsTest extends BaseConfiguration{

private String MARK = "MARK";
private String MARKED = "MARKED AS READ";

	@Test(priority = 1)
	public void checkAlreadyMarked() throws InterruptedException {

		try {

			waitExcplicit(2,"//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
			actionClick(2, "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
			waitExcplicit(1, "com.cjnet.news:id/text_google");
			actionClick(1, "com.cjnet.news:id/text_google");
			waitExcplicit(1, "com.google.android.gms:id/account_name");
			actionClick(1, "com.google.android.gms:id/account_name");
			Thread.sleep(3000);
			androidDriver.navigate().back();	
			waitExcplicit(1,"com.cjnet.news:id/imgGrid");
			List<MobileElement> gridItems =  androidDriver.findElementsById("com.cjnet.news:id/imgGrid");
			waitExcplicit(1,"com.cjnet.news:id/imgGrid");
			System.out.println("items here->"+gridItems.size());
			gridItems.get(2).click();	
			
			waitExcplicit(1, "com.cjnet.news:id/textTitle");
			List<MobileElement> listItems = androidDriver.findElementsById("com.cjnet.news:id/textTitle");		
			listItems.get(2).click();
			//actionClick(1, "com.cjnet.news:id/textTitle");
			waitExcplicit(1, "com.cjnet.news:id/btn_mark_as_read");
			String first = androidDriver.findElementById("com.cjnet.news:id/btn_mark_as_read").getText();
			System.out.println(first);

			if (first.equals(MARK)){
				actionClick(1, "com.cjnet.news:id/btn_mark_as_read");
			}
			else {
				System.out.println("Already Marked as Read");
			}
			waitExcplicit(1, "com.cjnet.news:id/btn_mark_as_read");
			String afterclicked = androidDriver.findElementById("com.cjnet.news:id/btn_mark_as_read").getText();
			assert afterclicked.equals(MARKED) : " MARKED, SUCCESS : " + first + "Expected : MARKED AS READ";
			androidDriver.navigate().back();
			androidDriver.navigate().back();
			System.out.println("PRINTING THE RESULT");

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}



}
