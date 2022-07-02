package com.webapp.pages;

import com.webapp.commonDef.CommonDef;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

public class LoginPage {

	static By userNameBy =  By.xpath("//input[@id='user-name']");
	static By passwordBy = By.xpath("//input[@id='password']");
	static By logInBtnBy = By.xpath("//input[@id='login-button']");


	// User login into saucedemo with credentials read from Execution// RunManager.xls file with LinkedHashMap object
	public static boolean loginValidation(LinkedHashMap<String, String> data) {
		boolean login = false;
		try {
			CommonDef.sendKeys(userNameBy, data.get("UserName"));
			CommonDef.sendKeys(passwordBy, data.get("Password"));
			CommonDef.click(logInBtnBy);
			login = true;

		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return login;
	}
}
