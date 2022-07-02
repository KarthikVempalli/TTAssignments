package com.webapp.pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.webapp.commonDef.CommonDef;

public class InventoryPage {

	static By pageHeddingBy =  By.xpath("//span[@class='title']");
	static By backPackAddBtnBy = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	static By cartLinkBy = By.xpath("//a[@class='shopping_cart_link']");
	static By burgerMenuBy = By.xpath("//button[@id='react-burger-menu-btn']");
	static By LogOutBy = By.xpath("//a[text()='Logout']");



	// User will select any product from inventory Page
	public static boolean selectProduct() {
		boolean select = false;
		try {
			Assert.assertTrue(CommonDef.getText(pageHeddingBy).equalsIgnoreCase("Products"));
			CommonDef.click(backPackAddBtnBy);
			CommonDef.moveToElement(cartLinkBy);
			CommonDef.click(cartLinkBy);
			select = true;
		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return select;
	}

	// User will logout form inventory Page
	public static boolean logoutValidation() {
		boolean logout = false;
		try {
			Assert.assertTrue(CommonDef.getText(pageHeddingBy).equalsIgnoreCase("Products"));
			CommonDef.click(burgerMenuBy);
			CommonDef.click(LogOutBy);
			logout = true;
		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return logout;
	}

}
