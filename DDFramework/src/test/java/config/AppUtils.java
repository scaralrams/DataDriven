package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AppUtils {
	public static WebDriver driver;
	public static Properties property;

	@BeforeMethod
	public void launch() throws Exception {
		property = new Properties();
		FileInputStream fi = new FileInputStream("./PropertyFiles/Environment.properties");
		property.load(fi);
		String browser = property.getProperty("browser");
		if (browser.equals("CHROME")) 
		{
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			driver.get(property.getProperty("url"));
			Reporter.log("Chrome Browser Launched", true);

		}
		if (browser.equals("MSEDGE")) 
		{
			driver = new EdgeDriver();
			
			driver.get(property.getProperty("url"));
			Reporter.log("Edge Browser Launched", true);
		} 
	}

	@AfterMethod
	public void closingDriver() {
		driver.quit();
		Reporter.log("Chrome Browser Closed", true);
	}

}
