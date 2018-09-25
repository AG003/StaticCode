package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.ClientRequestPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class ClientRequestTest 
{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	ClientRequestPage clientRequestPage;
	
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
	public void createClient()
	{
		loginPage = new LoginPage(driver);
		loginPage.loginAsSalesPerson();
		homePage = new HomePage(driver);
		homePage.clickOnClientRequest();
		clientRequestPage = new ClientRequestPage(driver);
		clientRequestPage.fillPersonalDetails();
	}
	
	@AfterMethod
	public void configAM()
	{
		homePage.logOut();
		driver.quit();
	}

}
