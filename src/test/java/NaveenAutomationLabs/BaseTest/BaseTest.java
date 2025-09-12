package NaveenAutomationLabs.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import NaveenAutomationLabs.PageObject.LaunchApplication;

public class BaseTest{
	public WebDriver driver;
	
	public void initiatlization() throws IOException
	{	
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/NaveenAutomationLabs/BaseTest/GlobalParam.properties");
		prop.load(fis);
		//String BrowserName = prop.getProperty("browser");
		String BrowserName = System.getProperty("browser") != null ? System.getProperty("browser"):prop.getProperty("browser");
		if(BrowserName.contains("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);		
		}
		
//		else if (BrowserName.contains("edge"))
//		{
//			EdgeOptions option = new EdgeOptions();
//			option.addArguments("--incognito");
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver(option);		
//		}
//		
//		else if (BrowserName.contains("firefox"))
//		{
//			FirefoxOptions option = new FirefoxOptions();
//			option.addArguments("--incognito");
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver(option);
//		}
		driver.manage().window().maximize();
	}
	
	public List<HashMap<String, String>> dataReader(String FilePath) throws IOException
	{
		//json to String
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
		String FileDest = System.getProperty("user.dir")+"/ScreenShots/"+MethodName+".png";
		FileUtils.copyFile(FileSrc, new File(FileDest));
		return FileDest;
	}
	
	@BeforeTest(alwaysRun=true)
	public void LaunchApplication() throws IOException
	{
		initiatlization();
		LaunchApplication launchApp = new LaunchApplication(driver);
		launchApp.goTo();
	}
	
	
	  @AfterTest(alwaysRun=true) 
	  public void tearDown() 
	  { 
		  if (driver != null) {
	        driver.quit();
	    }
	  }
	 
}
