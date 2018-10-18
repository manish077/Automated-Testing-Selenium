
import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTReadWrite {
	ExtentTest test;
	public static ExtentReports report;

	public WebDriver driver = null;
	String LoginData = "";
	
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
	public void excelTest() throws IOException, InterruptedException{
	

		FileInputStream file = new FileInputStream("/Users/Manish/Desktop/Spreadsheet/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Details det = PageFactory.initElements(driver, Details.class);
		
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);
			Cell expected = sheet.getRow(i).getCell(2);
			Cell result = sheet.getRow(i).getCell(3);
			
			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();
			String exp = expected.getStringCellValue();
			
			driver.get(Constants.registerURL);
			
			det.enterName(user);
			det.enterPass(pass);
			det.confirm();
			Thread.sleep(1000);
			
			det.lognav();
			det.enterName(user);
			det.enterPass(pass);
			det.confirm();
			
			ExcelUtils.setCellData("Pass", i, 3);
			
			
//			FileOutputStream fileOut = new FileOutputStream(Constants.pathTestData + Constants.fileTestData);
//
//			workbook.write(fileOut);
//
//			fileOut.flush();
//
//			fileOut.close();
			//result.setCellValue("PASS");
			assertEquals(exp, det.checking().getText());
			
			
		}
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
