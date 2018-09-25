package driverManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import configReader.ConfigReader;

public class DriverManager 
{
	public WebDriver driver;
	public ConfigReader readData;
	
	@BeforeMethod
	public void configBM() throws IOException
	{
		readData = new ConfigReader();
		String key = readData.getConfigReader("key");
		String address = readData.getConfigReader("pathValue");
		System.setProperty(key, address);
		
		String browserName = readData.getConfigReader("browserName");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		String url = readData.getConfigReader("url");
		driver.get(url);
	}
	
	@AfterMethod
	public void configAM()
	{
		if(driver != null)
		{
			driver.quit(); // if driver is not null quit the browser
		}
	}

}
