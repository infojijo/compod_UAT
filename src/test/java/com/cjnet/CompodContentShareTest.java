package com.cjnet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CompodContentShareTest extends BaseConfiguration{

	@Test
	public void contentShare() {

		try {
			waitExcplicit(1,"com.cjnet.news:id/imgGrid");

			List<MobileElement> gridItems =  androidDriver.findElementsById("com.cjnet.news:id/imgGrid");
			gridItems.get(2).click();
			waitExcplicit(1, "com.cjnet.news:id/textTitle");
			List<MobileElement> listItems = androidDriver.findElementsById("com.cjnet.news:id/textTitle");		
			listItems.get(2).click();
			waitExcplicit(1, "com.cjnet.news:id/btn_share");
			androidDriver.findElementById("com.cjnet.news:id/btn_share").click();
			waitExcplicit(1, "android:id/text1");
			//androidDriver.findElementsByName("WhatsApp");

			List<MobileElement> shareApps = androidDriver.findElementsById("android:id/text1");

			for(int i=0;i<shareApps.size();i++) {
				System.out.println("ShareApps-->"+shareApps.get(i).getText());
				if(shareApps.get(i).getText().equals("WhatsApp")) {
					shareApps.get(i).click();
					break;
				}
			}


			androidScroll();
				
				
			waitExcplicit(1,"com.whatsapp:id/contactpicker_row_name");
			List<MobileElement> chats = androidDriver.findElementsById("com.whatsapp:id/contactpicker_row_name");


			for(int i=0;i<chats.size();i++) {

				System.out.println("Chats->"+chats.get(i).getText());
				if(chats.get(i).getText().equals("Remya")) {
					chats.get(i).click();
				}
			}

			waitExcplicit(1, "com.whatsapp:id/send");
			actionClick(1, "com.whatsapp:id/send");

			System.out.println("Reached Here!");

			waitExcplicit(1, "com.whatsapp:id/send");
			actionClick(1, "com.whatsapp:id/send");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}


	}

	public void androidScroll() {

		TouchAction t = new TouchAction<>(androidDriver);

		Dimension dim = androidDriver.manage().window().getSize();
		int x = dim.getWidth()/2;
		int startY = (int) (dim.getHeight() *0.8);
		int endY = (int) (dim.getHeight()*0.2);

		t.press(PointOption.point(x, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(x,endY))
		.release()
		.perform();
	}

}





















