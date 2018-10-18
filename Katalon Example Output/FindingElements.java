
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.*;

public class FindingElements {
	
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
		report = new ExtentReports("/Users/Manish/Desktop/Empty/BingWebpageTest.html", true);
	}
	
	@Test
	public void searchText	() throws InterruptedException, IOException {
		
		test = report.startTest("Search Test");
		
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Bing Opened");
		
		BingLandingPage bingPage = PageFactory.initElements(driver, BingLandingPage.class);
		BingSearchedPage bingSearchPage = PageFactory.initElements(driver, BingSearchedPage.class);
		
		bingPage.search("Selenium");
		test.log(LogStatus.INFO, "Search Run");
		
		if (bingSearchPage.getSearch().getText().equals("Selenium")) {
			test.log(LogStatus.PASS, "Search Text Was Found");
		}
		else {
			test.log(LogStatus.FAIL,"Search text was not found");
		}
		
		Thread.sleep(500);
		report.endTest(test);
		assertEquals("Selenium", bingSearchPage.getSearch().getText());	
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

