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
import pageObject.RiskRatingPage;

public class RiskRatingTest extends DriverManager
{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	RiskRatingPage riskRatingPage;
	PageManager pageManager;
	
	
	
	@Test
	public void RRTask()
	{
		pageManager = new PageManager(driver);
		loginPage = pageManager.getLoginPage();
		homePage = pageManager.getHomePage();
		riskRatingPage = pageManager.getRiskRatingPage();
		
		loginPage.loginAsAnalyst(); // login as analyst
		homePage.clickOnRR(); // move to risk rating page
		riskRatingPage.fillDetails(); // enter the details required 
		riskRatingPage.clickOnSubmit(); // click on submit button
		homePage.logOut(); //logout 
	}
	


}
