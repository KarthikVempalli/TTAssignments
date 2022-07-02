package com.webapp.pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.webapp.commonDef.CommonDef;

public class CartPage {
	
	static By pageHeddingBy =  By.xpath("//span[@class='title']");
	static By productOnCartBy = By.xpath("//div[@class='inventory_item_name']");
	static By checkOutBy = By.xpath("//button[@id='checkout']");
	
	// User will enter Cart page and checks cart and clicks on select any product from inventory Page
	public static boolean cartValidation() {
		boolean checkOut = false;
		try {
			Assert.assertTrue(CommonDef.getText(pageHeddingBy).equalsIgnoreCase("Your Cart"));
			Assert.assertTrue(CommonDef.getText(productOnCartBy).equalsIgnoreCase("Sauce Labs Backpack"));
			CommonDef.moveToElement(checkOutBy);
			CommonDef.click(checkOutBy);
			checkOut =true;

		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return checkOut;
	}
}
