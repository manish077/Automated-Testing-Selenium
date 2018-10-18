import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Shopping {
	@FindBy(name="FormsButton2")
	private WebElement formsButton;
	
	@FindBy(linkText = "Menu")
	private WebElement getMenu;
	
	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000451955160")
	private WebElement list;
	
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Red Tea'])[1]/following::strong[1]")
	private WebElement list2;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000451959280\"]/div")
	private WebElement clickButton;
	
	public void getMenu() {
		getMenu.click();
	}
	
	public WebElement showList1() {
		return list;
	}
	
	public void ShowList3() {
		list.isDisplayed();
	}
	
	public void showList2() {
		list2.isDisplayed();
	}
	
	public void clickButton() {
		clickButton.click();
		
	}
}


