package NaveenAutomationLabs.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NaveenAutomationLabs.AbstractMethods.AbstractMethod;

public class CartPage extends AbstractMethod{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//div[@class='button-group']//button)[1]")
	WebElement cartBtn;
	public void Cart(String Category, String Item)
	{
		driver.findElement(By.xpath("//a[text()='"+Category+"']")).click();
		driver.findElement(By.xpath("//ul[@class='list-unstyled']//li//a[contains(normalize-space(), '"+Item+"')]")).click();
		cartBtn.click();
		WaitForVisibleElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
	}
}
