package NaveenAutomationLabs.ScenariosTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import NaveenAutomationLabs.BaseTest.BaseTest;
import NaveenAutomationLabs.PageObject.RegisterPage;

public class RegisterNegevetiveTest extends BaseTest{

	@Test
	public void EmailAlreadyExistTC1()
	{
		RegisterPage register = new RegisterPage(driver);
		register.AlreadyAvailableEmail("Naveen", "Kamath", "naveen173@gmail.com", "Abcd@1234", "Abcd@1234");
		String Actual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(Actual, "Warning: E-Mail Address is already registered!");
	}
}
