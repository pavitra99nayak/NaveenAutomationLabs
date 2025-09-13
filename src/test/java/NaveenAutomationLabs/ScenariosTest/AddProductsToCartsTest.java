package NaveenAutomationLabs.ScenariosTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NaveenAutomationLabs.BaseTest.BaseTest;
import NaveenAutomationLabs.PageObject.CartPage;
import NaveenAutomationLabs.PageObject.LoginPage;

public class AddProductsToCartsTest extends BaseTest{
	
	@Test(dataProvider="dataset")
	public void Login(HashMap<String,String> input)
	{
		LoginPage login = new LoginPage(driver);
		login.loginWithValidCreds(input.get("Email"), input.get("Password"));
	}
	
	@Test(dependsOnMethods="Login")
	public void AddToCart()
	{
		CartPage cart = new CartPage(driver);
		cart.Cart("Desktops", "Mac");
		String[] Actual = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText().split("×");
		String item = driver.findElement(By.xpath("//div[@class='caption']//h4")).getText();
		Assert.assertEquals(Actual[0].trim(), "Success: You have added "+item+" to your shopping cart!");
	}
	
	@DataProvider
	public Object[][] dataset() throws IOException
	{
		String FilePath = System.getProperty("user.dir")+"/src/test/java/NaveenAutomationLabs/BaseTest/RegisterDate.json";
		List<HashMap<String,String>> input = dataReader(FilePath);
		return new Object[][] {{input.get(0)}};
	}
}
