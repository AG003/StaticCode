package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;

public class LoginTest
{
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeMethod
	public void configBM()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://url");
	}
	
	@Test
	public void login()
	{
		loginPage = new LoginPage(driver);
		loginPage.loginAsSalesPerson();
	}
	
	@AfterMethod
	public void configAM()
	{
		homePage = new HomePage(driver);
		homePage.logOut();
		driver.quit();
	}
	
}
