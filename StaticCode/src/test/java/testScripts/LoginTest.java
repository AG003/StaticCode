package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import manager.PageManager;
import pageObject.HomePage;
import pageObject.LoginPage;

public class LoginTest extends DriverManager
{
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public PageManager pageManager;
	
	
	@Test
	public void login()
	{
		pageManager = new PageManager(driver);
		loginPage = pageManager.getLoginPage();
		homePage = pageManager.getHomePage();
		
		loginPage.loginAsSalesPerson(); // login as salesperson
		homePage.logOut(); // logout 
	}
	
	
}
