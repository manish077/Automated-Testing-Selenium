
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class paint {
	
	public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/Manish/Desktop/chromedriver");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void testUntitledTestCase() throws InterruptedException, IOException {
		
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.youidraw.com/apps/painter/");
		
		driver.findElement(By.id("brush")).click();
		
		action.moveByOffset(500, 100).clickAndHold().moveByOffset(0,500).release().perform();
		action.moveByOffset(0, -500).clickAndHold().moveByOffset(300,0).release().perform();
		

	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}

}

