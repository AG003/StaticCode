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
import pageObject.QualityControlPage;

public class QualityControlTest extends DriverManager
{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	QualityControlPage qualityControlPage;
	PageManager pageManager;
	
	
	
	
	@Test
	public void QCTask()
	{
		pageManager = new PageManager(driver);
		loginPage = pageManager.getLoginPage();
		homePage = pageManager.getHomePage();
		qualityControlPage = pageManager.getQualityControlPage();
		
		loginPage.loginAsManager(); // login into the application as manager
		homePage.clickOnQC(); // move to the Quality control page
		qualityControlPage.openRequest(); // Verify the details
		qualityControlPage.clickOnNextButton(); // Verify the details on another page
		qualityControlPage.clickOnSubmitButton(); // It will push the data into database and trigger the Risk Rating, which will go the Analyst
		homePage.logOut(); //logout 
	}
	
	

}
