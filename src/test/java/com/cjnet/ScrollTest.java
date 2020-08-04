package com.cjnet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollTest extends BaseConfiguration{

	@Test
	public void TestScroll() {

		waitExcplicit(1,"com.cjnet.news:id/imgGrid");

		List<MobileElement> gridItems =  androidDriver.findElementsById("com.cjnet.news:id/imgGrid");
		gridItems.get(0).click();
		waitExcplicit(1, "com.cjnet.news:id/textTitle");
		
		//androidScroll();
		
		List<MobileElement> listItems = androidDriver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
				+ "new UiSelector().textContains(\"Color\"));");

		listItems.get(0).click();

		for(int i=0; i<listItems.size();i++) {
			System.out.println("Items"+listItems.get(i).getText());
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
