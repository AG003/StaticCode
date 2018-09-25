package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import manager.PageManager;
import pageObject.CustomerDueDeligence;
import pageObject.CustomerDueDeligencePreviewPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class KnowYourCustomerTest extends DriverManager
{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public CustomerDueDeligence customerDueDeligence; 
	public CustomerDueDeligencePreviewPage customerDueDeligencePreviewPage;
	public PageManager pageManager;
	
	
	
	@Test
	public void completKYC()
	{
		pageManager = new PageManager(driver);
		loginPage = pageManager.getLoginPage();
		customerDueDeligence = pageManager.getCustomerDueDeligence();
		customerDueDeligencePreviewPage = pageManager.getCustomerDueDeligencePreviewPage();
		
		loginPage.loginAsAnalyst(); // login as analyst
		homePage.clickOnCDD(); // click on customer due deligence
		customerDueDeligence.openRequest(); // open the request
		customerDueDeligence.enterQuestionsDetails(); // enter the required questions details
		customerDueDeligence.clickOnNextButton(); // click on next
		customerDueDeligencePreviewPage.clickOnSubmitButton(); // just to verify all the details
		homePage.logOut(); //logout 
	}
	
	
	

}
