package NaveenAutomationLabs.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NaveenAutomationLabs.AbstractMethods.AbstractMethod;

public class RegisterPage extends AbstractMethod{
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		super(driver);
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
	@FindBy(xpath="//div[@class='pull-right']")
	WebElement continueBtn;
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right']//li)[5]")
	WebElement logout;
	@FindBy(xpath="(//span[@class='hidden-xs hidden-sm hidden-md'])[3]")
	WebElement myAct2;
	public void RegisterNewUser(String Name,String LName,String Email, String TelPhn,String Password)
	{
		myActBtn.click();
		loginBtn.click();
		//WaitForVisibleElement(By.id("input-lastname"));
		fName.sendKeys(Name);
		lName.sendKeys(LName);
		email.sendKeys(Email);
		telPhone.sendKeys(TelPhn);
		pass.sendKeys(Password);
		confimPass.sendKeys(Password);
		checbox.click();
		cntBtn.click();
	}
	public void logOut()
	{
		WaitForVisibleElement(By.xpath("//div[@class='pull-right']"));
		continueBtn.click();
		myAct2.click();
		logout.click();
	}
}
