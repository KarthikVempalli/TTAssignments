package com.webapp.pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.webapp.commonDef.CommonDef;

public class CheckOutStepOnePage {
	static By pageHeddingBy =  By.xpath("//span[@class='title']");
	static By firstNameBy =  By.xpath("//input[@id='first-name']");
	static By lastNameBy = By.xpath("//input[@id='last-name']");
	static By postalCodeBy = By.xpath("//input[@id='postal-code']");
	static By continueBtnBy = By.xpath("//input[@id='continue']");


	// User will navigate to checkoutpage one and user will provide data which is read from Execution// RunManager.xls file with LinkedHashMap object
	public static boolean checkinValidation(LinkedHashMap<String, String> data) {
		boolean place = false;
		try {
			Assert.assertTrue(CommonDef.getText(pageHeddingBy).equalsIgnoreCase("Checkout: Your Information"));
			CommonDef.sendKeys(firstNameBy, data.get("First Name"));
			CommonDef.sendKeys(lastNameBy, data.get("Last Name"));
			CommonDef.sendKeys(postalCodeBy, data.get("Postal Code"));
			CommonDef.moveToElement(continueBtnBy);
			CommonDef.click(continueBtnBy);
			place = true;
		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return place;
	}
}
