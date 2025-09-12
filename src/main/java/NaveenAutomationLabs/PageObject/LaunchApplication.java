package NaveenAutomationLabs.PageObject;

import org.openqa.selenium.WebDriver;

public class LaunchApplication {
	WebDriver driver;
	public LaunchApplication(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void goTo()
	{
		driver.get("https://naveenautomationlabs.com/opencart/index.php");
	}
}
