package com.webapp.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.webapp.commonDef.CommonDef;

public class CheckOutCompletePage {
	static By pageHeddingBy =  By.xpath("//span[@class='title']");
	static By completeHeaderBy =  By.xpath("//h2[@class='complete-header']");
	static By backHomeBtbBy = By.xpath("//button[@id='back-to-products']");


	// User will navigate to checkout Complete Page and user will click on finish
	public static boolean checkinValidation() {
		boolean back = false;
		try {
			Assert.assertTrue(CommonDef.getText(pageHeddingBy).equalsIgnoreCase("Checkout: Complete!"));
			CommonDef.moveToElement(completeHeaderBy);
			Assert.assertTrue(CommonDef.getText(completeHeaderBy).equalsIgnoreCase("THANK YOU FOR YOUR ORDER"));
			CommonDef.logs(CommonDef.getText(completeHeaderBy));
			CommonDef.moveToElement(backHomeBtbBy);
			CommonDef.click(backHomeBtbBy);
			back = true;
		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return back;
	}

}
