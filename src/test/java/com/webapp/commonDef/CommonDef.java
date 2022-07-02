package com.webapp.commonDef;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import automation.core.testng.BaseTest;

public class CommonDef extends BaseTest{


	public static WebDriver getCurrentDriver()
	{
		return driver;
		
	}

	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void navigateBack()
	{
		driver.navigate().back();
	}
	// Method to check element displayed or not returns boolean
	public static boolean isElementDisplay(By by)
	{
		try {
			implicitWait();
			Assert.assertTrue(driver.findElement(by).isDisplayed());
			return true;
		} catch (Exception e) {

			Assert.fail("Element not present"+by);
			test.log(Status.ERROR, "Element not present "+by );
			return false;
		}

	}

	public static void click(By by) throws IOException {
		try {
			implicitWait();
			WebElement element = getCurrentDriver().findElement(by);
			new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			test.log(Status.PASS, "Element Clicked "+by);
		} catch (Exception e) {
			Assert.fail("Element not Clicked"+ by);
			test.log(Status.ERROR, "Element not Clicked "+by);
			
		}

	}
	public static void clear(By by) throws IOException {
		try {
			implicitWait();
			WebElement element = getCurrentDriver().findElement(by);
			new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			test.log(Status.PASS,"Element cleared Successfully -"+by);
		} catch (Exception e) {
			Assert.fail("Element not Cleared"+ by);
			test.log(Status.ERROR, "Element not Cleared");
		}

	}


	public static String getText(By by) throws IOException {
		String text = null;
		try {
			text = getCurrentDriver().findElement(by).getText();
		} catch (Exception e) {
			Assert.fail("LocatorNotFound "+by);
			test.log(Status.ERROR, "locator not Found");
		}

		return text;
	}
	public static void sleep(long time) throws IOException {

		try {
			Thread.sleep(time);
		} catch (Exception e) {
			test.log(Status.ERROR, "");
		}

	}


	public static void sendKeys(By by, String keysToSend) throws IOException {
		try {
			implicitWait();
			click(by);
			clear(by);
			getCurrentDriver().findElement(by).sendKeys(keysToSend);
			test.log(Status.PASS, "Element is Clicked");

		} catch (Exception E) {
			Assert.fail("Value : "+keysToSend+" - Not send into "+by);

		}
	}

	public static void sendKeyswithEnter(By by, String keysToSend) throws IOException {
		try {

			Actions action = new Actions(getCurrentDriver());
			getCurrentDriver().findElement(by).sendKeys(keysToSend);
			action.sendKeys(Keys.ENTER).build().perform();
			test.log(Status.PASS,"Value "+keysToSend+" Successfully on -"+by);
		} catch (Exception E) {
			Assert.fail("Value : "+keysToSend+" - Not send into "+by);
			test.log(Status.FAIL,"~~~~~~Exception occurred~~~~~~");
		}
	}

	public static void waitForPageLoad(By elementToBeFound) {


		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable((elementToBeFound)));
		} catch (Exception E) {
			Assert.fail( "Page Load Condition failed. Continuing with test");
			test.log(Status.FAIL,"~~~~~~Exception occurred~~~~~~");
		}
	}

	public static void stringCompare(By by,String text)  throws IOException {
		try {
			Assert.assertEquals(getText(by),text);
			test.log(Status.PASS,"WebElementFound" +  by);
		} catch (Exception e) {
			Assert.fail("Assert not equal "+ by);
			test.log(Status.FAIL,"TextMissMatch-- Expected :"+text + "Actual :" +getText(by)  +  by);
		}
	}

	public static WebElement findElement(By by)  throws IOException {
		try {

			test.log(Status.PASS,"WebElementFound" +  by);
			return getCurrentDriver().findElement(by);
			

		} catch (Exception e) {
			Assert.fail("WebElementNotFound "+ by);
			return null;
		}
	}
	
	public static List<WebElement> findElements(By by)  throws IOException {
		try {

			//Report.logScreenshot(driver,"WebElementFound" +  by);
			return getCurrentDriver().findElements(by);

		} catch (Exception e) {
			Assert.fail("WebElementNotFound "+ by);
			return null;
		}
	}

	



	public static void logs(String message){
		try {
			test.log(Status.PASS, message);
		} catch (Exception E) {
			
		}
	}
	
	
	public static By replaceXXXXFromString(By by,String replaceWith) {

		String s= by.toString().substring(by.toString().lastIndexOf(": ") + 2, by.toString().length());
		return By.xpath(s.replace("XXXX", replaceWith));

	}

	public  static boolean moveToElement(By element) {
		try {
        WebElement webElement =getCurrentDriver().findElement(element);
        Assert.assertNotNull(webElement);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getCurrentDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", webElement);
        return true;
		}catch (Exception E) {
			test.log(Status.PASS,"Failed to move to elament"+element);
			return false;
		}

    }
	 public static String rightPadding(String input)
	    {
	  
	        String result= String.format("%" + (-10) + "s", input).replaceAll("0.000", "  -  ");
	  
	        // Return the resultant string
	        return result;
	    }


}
