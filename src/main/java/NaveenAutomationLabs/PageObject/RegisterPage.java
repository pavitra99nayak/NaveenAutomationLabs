package NaveenAutomationLabs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//li[@class='dropdown'])[1]")
	WebElement myActBtn;
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right']//li)[1]")
	WebElement loginBtn;
	@FindBy(id="input-firstname")
	WebElement fName;
	@FindBy(id="input-lastname")
	WebElement lName;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-telephone")
	WebElement telPhone;
	@FindBy(id="input-password")
	WebElement pass;
	@FindBy(id="input-confirm")
	WebElement confimPass;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checbox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement cntBtn;
	public void RegisterNewUser(String Name,String LName,String Email, String TelPhn,String Password)
	{
		myActBtn.click();
		loginBtn.click();
		fName.sendKeys(Name);
		lName.sendKeys(LName);
		email.sendKeys(Email);
		telPhone.sendKeys(TelPhn);
		pass.sendKeys(Password);
		confimPass.sendKeys(Password);
		checbox.click();
		cntBtn.click();
	}
}
