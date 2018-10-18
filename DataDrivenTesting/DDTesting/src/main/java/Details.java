import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Details {

	
	@FindBy(name  = "username")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement passWord;
	@FindBy(name="FormsButton2")
	private WebElement formsButton;
	
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement lognav;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement checking;

	
	public void enterName(String text) {
		userName.sendKeys(text);
	}
	
	public void enterPass(String text) {
		passWord.sendKeys(text);
	}
	
	public void confirm() {
		formsButton.click();
	}
	
	public WebElement checking() {
		return checking;
	}
	
	public void lognav() {
		lognav.click();
	}
	
}
