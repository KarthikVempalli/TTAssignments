package automation.core.testng;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import automation.core.utils.data.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners({DriverListener.class})
public class BaseTest {
	public static String reportFolder;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports  report;
	public static ExtentTest test;
	protected static WebDriver driver = null;
	public  static String testID;
	public  static String sheetName;
	

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		String datetimestamp =new SimpleDateFormat("yyyyMMddHHmmss" ).format(new Date());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Test-Output"+datetimestamp+".html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);


	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {

	}

	@BeforeTest(alwaysRun = true)
	@Parameters({ "testCaseID", "dataSheet" })
	public void launchBrowser(String testCaseID, String dataSheet) throws Exception {

		testID=testCaseID;
		sheetName=dataSheet;
		 test = report.createTest("TestCase ID : "+testID);
		if(!testCaseID.equalsIgnoreCase("TC002"))
		{
			driverManager();
			driver.navigate().to(ProjectConfig.getPropertyValue("SauceDemo_URL"));
		}
	
	}

	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
	
		if(!testID.equalsIgnoreCase("TC002"))
		{
			driver.quit();
		}
		report.flush();
	}

	public ChromeOptions chromeOptions()
	{
		Map prefs = new HashMap();
		prefs.put("profile.default_content_settings.cookies", 2);
		ChromeOptions options = new ChromeOptions();
		return options.setExperimentalOption("prefs", prefs);
	}
	public void driverManager()
	{
		WebDriverManager.chromedriver().setup(); // Can be used to manage browser and Driver versions
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions());
		driver.manage().window().maximize();
	}


}
