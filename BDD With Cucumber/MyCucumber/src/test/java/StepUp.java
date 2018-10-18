import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepUp {
	public WebDriver driver = null;
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/Manish/Desktop/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	

	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		Shopping shop = PageFactory.initElements(driver, Shopping.class);
		
		driver.get(Constant.URL1);
		assertEquals("Welcome", driver.getTitle());
		
//		driver.get(Constant.URL2);
//		assertEquals("Check Out", driver.getTitle());
		
	   
	}
	
	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		Shopping shop = PageFactory.initElements(driver, Shopping.class);
		driver.get(Constant.URL3);
		assertEquals("Menu", driver.getTitle());
		Thread.sleep(1000);
		
	}
	
	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		Shopping shop = PageFactory.initElements(driver, Shopping.class);
		driver.get(Constant.URL3);
		assertEquals(shop.showList1(),driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451955160")));

	}
	
	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		Shopping shop = PageFactory.initElements(driver, Shopping.class);
	    // Write code here that turns the phrase above into concrete actions
		driver.get(Constant.URL4);
	  //  shop.clickButton();
	    
	}
	
	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Check Out", driver.getTitle());
	    
	}


}
