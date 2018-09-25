package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import manager.PageManager;
import pageObject.ClientRequestPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class ClientRequestTest extends DriverManager
{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public ClientRequestPage clientRequestPage;
	public PageManager pageManager;
	
	
	
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
	
	
}
