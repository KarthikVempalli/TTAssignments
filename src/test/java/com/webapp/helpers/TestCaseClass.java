package com.webapp.helpers;


import automation.core.utils.data.ExcelDataReader;
import com.webapp.pages.*;


//import junit.framework.Assert;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCaseClass {
	
	public static void sauceCart_BuyValidation(String testCaseID, String dataSheet) throws Exception {
		LinkedHashMap<String, String> data = ExcelDataReader.readTCBinding(testCaseID,dataSheet);
		LoginPage.loginValidation(data);
		InventoryPage.selectProduct();
		CartPage.cartValidation();
		CheckOutStepOnePage.checkinValidation(data);
		CheckOutStepTwoPage.checkinValidation();
		CheckOutCompletePage.checkinValidation();
		InventoryPage.logoutValidation();
	}
	
	public static void postEndPointsValidation(String testCaseID, String dataSheet) throws Exception {
		LinkedHashMap<String, String> data = ExcelDataReader.readTCBinding(testCaseID,dataSheet);
		TypicodePage.createUserId_PostMethod(data);
		
	}

	
	
}
