package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.QualityControlPage;

public class QualityControlTest 
{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	QualityControlPage qualityControlPage;
	
	
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
	public void QCTask()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		qualityControlPage = new QualityControlPage(driver);
		
		loginPage.loginAsManager(); // login into the application as manager
		homePage.clickOnQC(); 
		qualityControlPage.openRequest(); // Verify the details
		qualityControlPage.clickOnNextButton(); // Verify the details on another page
		qualityControlPage.clickOnSubmitButton(); // It will push the data into database and trigger the Risk Rating, which will go the Analyst	
	}
	
	@AfterMethod
	public void configAM()
	{
		homePage.logOut();
		driver.quit();
	}

}
