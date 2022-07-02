package com.webapp.tests;


import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.webapp.helpers.TestCaseClass;

import automation.core.testng.BaseTest;

public class AllTests extends BaseTest {
	
	
	
	@Test(groups = { "P1" }, description = "Sauce Product Buy online")
	public void sauceProductOnlineBuyingEndToEndTransaction() throws Exception {
		TestCaseClass.sauceCart_BuyValidation(testID,sheetName);
	}
	
	@Test(groups = { "P1" }, description = "Automation of the posts endpoints")
	public void apiAutomationForPostEndPoints() throws Exception {
		TestCaseClass.postEndPointsValidation(testID, sheetName);
	}

 	
}
