package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manager.PageManager;
import pageObject.ClientRequestPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class ClientRequestTest 
{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public ClientRequestPage clientRequestPage;
	public PageManager pageManager;
	
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
		pageManager = new PageManager(driver);
		loginPage = pageManager.getLoginPage();
		homePage = pageManager.getHomePage();
		clientRequestPage = pageManager.getClientRequestpage();
		
		loginPage.loginAsSalesPerson(); // login as salesperson
		homePage.clickOnClientRequest(); // click on client request
		clientRequestPage.fillPersonalDetails(); // fill all the details
		clientRequestPage.clickOnSubmitButton(); // save the details
		homePage.logOut(); //logout
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
