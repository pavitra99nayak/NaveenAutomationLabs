package NaveenAutomationLabs.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NaveenAutomationLabs.AbstractMethods.AbstractMethod;

public class LoginPage extends AbstractMethod {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//li[@class='dropdown'])[1]")
	WebElement myActBtn;
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right']//li)[2]")
	WebElement loginBtn;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginBtn;
	@FindBy(xpath="//div[@class='pull-right']")
	WebElement continueBtn;
	@FindBy(xpath="(//span[@class='hidden-xs hidden-sm hidden-md'])[3]")
	WebElement myAct2;
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right']//li)[5]")
	WebElement logout;
	public void loginWithValidCreds(String Email, String Password)
	{
		myActBtn.click();
		loginBtn.click();
		email.sendKeys(Email);
		password.sendKeys(Password);
		LoginBtn.click();
	}
	
	public void logOut()
	{
		WaitForVisibleElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]"));
		myAct2.click();
		logout.click();
	}
}
