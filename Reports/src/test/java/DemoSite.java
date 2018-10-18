import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoSite {
	
	ExtentTest test;
	public static ExtentReports report;

	public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/Manish/Desktop/chromedriver");
		driver = new ChromeDriver();
	}
	
	@BeforeClass
	public static void initial() {
		report = new ExtentReports("/Users/Manish/Desktop/Empty/LoginTest.html", true);
	}
	
	
	@Test
	public void  enterDetails() throws InterruptedException, IOException{
		test = report.startTest("Search Test");
		driver.get(DemoConstant.URL1);
		 
		 test.log(LogStatus.INFO, "Login Opened");
		
		fillDetails cUser = PageFactory.initElements(driver, fillDetails.class);
		LoginPage lUser = PageFactory.initElements(driver, LoginPage.class);
		
		cUser.enterName("test123");
		cUser.enterPass("test123");
		test.log(LogStatus.INFO, "Created username");
		   
		
		driver.get(DemoConstant.URL2);
		
		lUser.enterName("test123");
		lUser.enterPass("test123");
		test.log(LogStatus.INFO, "logged in");
		
	    if (lUser.checking().getText().equals("**Successful Login**")) {
	    	test.log(LogStatus.PASS, "Search Text Was Found");
	    	
	    }
	    else {
	    	test.log(LogStatus.FAIL,"Search text was not found");
	    }
	    
	    report.endTest(test);
	    assertEquals("**Successful Login**", lUser.checking().getText());
	    		
	}
	
	
	@AfterClass
	public static void end() {
		report.flush();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
