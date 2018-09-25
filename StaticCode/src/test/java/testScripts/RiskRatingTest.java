package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RiskRatingPage;

public class RiskRatingTest 
{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	RiskRatingPage riskRatingPage;
	
	
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
	public void RRTask()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		riskRatingPage = new RiskRatingPage(driver);
		
		loginPage.loginAsAnalyst();
		homePage.clickOnRR();
		riskRatingPage.fillDetails();
		riskRatingPage.clickOnSubmit();
	}
	
	@AfterMethod
	public void configAM()
	{
		homePage.logOut();
		driver.quit();
	}

}
