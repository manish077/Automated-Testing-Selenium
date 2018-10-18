import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	public class enterDetails {

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
	  public void testUntitledTestCase() throws Exception {
		  
		 test = report.startTest("Search Test");
	    driver.get("http://thedemosite.co.uk/addauser.php");
	    
	    
	    test.log(LogStatus.INFO, "Login Opened");
	    
	    
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).sendKeys("test123");
	    driver.findElement(By.name("password")).sendKeys("test123");
	    driver.findElement(By.name("FormsButton2")).click();
	    
	    test.log(LogStatus.INFO, "Created username");
	    
	    driver.findElement(By.linkText("4. Login")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).sendKeys("test123");
	    driver.findElement(By.name("password")).sendKeys("test123");
	    driver.findElement(By.name("FormsButton2")).click();
	    
	    test.log(LogStatus.INFO, "logged in");
	   
	    if (driver.
	    		findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='The status was:'])[1]/following::b[1]"))
	    		.getText()
	    		.matches("^[\\s\\S]*[\\s\\S]*Successful Login[\\s\\S]*[\\s\\S]*$")) {
	    	test.log(LogStatus.PASS, "Search Text Was Found");
	    	
	    }
	    else {
	    	test.log(LogStatus.FAIL,"Search text was not found");
	    }
	    report.endTest(test);
	    assertTrue(driver.
	    		findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='The status was:'])[1]/following::b[1]"))
	    		.getText()
	    		.matches("^[\\s\\S]*[\\s\\S]*Successful Login[\\s\\S]*[\\s\\S]*$"));
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

