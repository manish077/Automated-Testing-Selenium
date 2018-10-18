import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HateYou {
	
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
		report = new ExtentReports("/Users/Manish/Desktop/Empty/waitingssss.html", true);
	}
	
	@Test
	public void automatedTest() throws InterruptedException, IOException{
		test = report.startTest("Search Test"); // start test
		
		driver.get("https://chrisperrins95.github.io/AutomatedTestingExample/");
		
		test.log(LogStatus.INFO, "Page Opened"); // opened
		
		Hating waitPage = PageFactory.initElements(driver, Hating.class);
		
	    if (waitPage.getElement(driver).getText().equals("I HATE YOU!")) {
	    	test.log(LogStatus.PASS, "text has been found"); // text found
	    	
	    }
	    
	    else {test.log(LogStatus.FAIL,"Did not find text");}// not found
		
		
		report.endTest(test); // end test 
	    assertEquals("I HATE YOU!",waitPage.getElement(driver).getText());
		
		
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}
	
}
