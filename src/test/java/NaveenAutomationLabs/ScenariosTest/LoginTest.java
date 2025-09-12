package NaveenAutomationLabs.ScenariosTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NaveenAutomationLabs.BaseTest.BaseTest;
import NaveenAutomationLabs.PageObject.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider="dataset")
	public void ValidLogin(HashMap<String,String> input)
	{
		LoginPage login = new LoginPage(driver);
		login.loginWithValidCreds(input.get("Email"), input.get("Password"));
		login.logOut();
	}
	
	@DataProvider
	public Object[][] dataset() throws IOException
	{
		String FilePath = System.getProperty("user.dir")+"/src/test/java/NaveenAutomationLabs/BaseTest/RegisterDate.json";
		List<HashMap<String,String>> input = dataReader(FilePath);
		return new Object[][] {{input.get(0)},{input.get(1)}};
	}

}
