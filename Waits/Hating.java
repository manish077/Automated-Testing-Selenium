import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Hating {
	
	@FindBy(xpath="//*[@id=\"shafeeq\"]")
	private WebElement checking;
	
	public WebElement checking() {
		return checking;
	}
	
	public WebElement getElement(WebDriver driver) {
	WebElement element = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("//*[@id=\"shafeeq\"]/h1")));
	return element;
	}
}


