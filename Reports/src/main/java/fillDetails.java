import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class fillDetails {
	
	@FindBy(name  = "username")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement passWord;
	@FindBy(name="FormsButton2")
	private WebElement formsButton;
	
	public void enterName(String text) {
		userName.sendKeys(text);
	}
	
	public void enterPass(String text) {
		passWord.sendKeys(text);
		formsButton.click();
	}

}
