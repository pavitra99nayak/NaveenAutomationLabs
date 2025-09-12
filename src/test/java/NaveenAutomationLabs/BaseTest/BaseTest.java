package NaveenAutomationLabs.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import NaveenAutomationLabs.PageObject.LaunchApplication;

public class BaseTest{
	protected WebDriver driver;
	
	public void initiatlization()
	{				
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	public List<HashMap<String, String>> dataReader(String FilePath) throws IOException
	{
		//json to String
		//String FilePath = System.getProperty("user.die")+"\\src\\test\\java\\NaveenAutomationLabs\\BaseTest\\RegisterDate.json";
		String JsonToString = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
		
		//String to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> reader = mapper.readValue(JsonToString, new TypeReference<List<HashMap<String,String>>> (){});
		return reader;
	}
	
	public String TakeScreenshot(String MethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File FileSrc = ts.getScreenshotAs(OutputType.FILE);
		String FileDest = System.getProperty("user.dir")+"\\src\\ScreenShots\\"+MethodName+".png";
		FileUtils.copyFile(FileSrc, new File(FileDest));
		return FileDest;
	}
	
	@BeforeTest
	public void LaunchApplication()
	{
		initiatlization();
		LaunchApplication launchApp = new LaunchApplication(driver);
		launchApp.goTo();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
