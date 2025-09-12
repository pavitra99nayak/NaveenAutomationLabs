package NaveenAutomationLabs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//li[@class='dropdown'])[1]")
	WebElement myActBtn;
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right']//li)[2]")
	WebElement loginBtn;
	
	public void loginWithValidCreds()
	{
		myActBtn.click();
		loginBtn.click();
	}
}
