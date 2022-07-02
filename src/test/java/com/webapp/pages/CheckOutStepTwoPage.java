package com.webapp.pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.webapp.commonDef.CommonDef;

public class CheckOutStepTwoPage {
	static By pageHeddingBy =  By.xpath("//span[@class='title']");
	static By totalBy =  By.xpath("//div[@class='summary_total_label']");
	static By finishBtnBy = By.xpath("//button[@id='finish']");


	// User will navigate to checkoutpage two and user verify order and click on finish
	public static boolean checkinValidation() {
		boolean finish = false;
		try {
			Assert.assertTrue(CommonDef.getText(pageHeddingBy).equalsIgnoreCase("Checkout: Overview"));
			CommonDef.moveToElement(totalBy);
			CommonDef.logs(CommonDef.getText(totalBy));
			CommonDef.moveToElement(finishBtnBy);
			CommonDef.click(finishBtnBy);
			finish = true;
		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return finish;
	}
}
