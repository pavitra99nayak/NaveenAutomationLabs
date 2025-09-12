package NaveenAutomationLabs.ScenariosTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NaveenAutomationLabs.BaseTest.BaseTest;
import NaveenAutomationLabs.PageObject.RegisterPage;

public class RegisterTest extends BaseTest{

	@Test(dataProvider="DataSet")
	public void ValidRegisterTC1(HashMap<String,String> input)
	{
		RegisterPage Register = new RegisterPage(driver);
		Register.RegisterNewUser(input.get("FName"), input.get("LName"), input.get("Email"), input.get("TelePhone"), input.get("Password"));
	}
	
	@DataProvider
	public Object[][] DataSet() throws IOException
	{
		String FilePath = System.getProperty("user.dir")+"\\src\\test\\java\\NaveenAutomationLabs\\BaseTest\\RegisterDate.json";
		List<HashMap<String,String>> input = dataReader(FilePath);
		return new Object[][] {{input.get(0)},{input.get(1)}};
	}
}
