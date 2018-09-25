package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.CustomerDueDeligence;
import pageObject.CustomerDueDeligencePreviewPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class KnowYourCustomerTest 
{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public CustomerDueDeligence customerDueDeligence; 
	public CustomerDueDeligencePreviewPage customerDueDeligencePreviewPage;
	
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
	public void completKYC()
	{
		loginPage = new LoginPage(driver);
		customerDueDeligencePreviewPage = new CustomerDueDeligencePreviewPage(driver);
		loginPage.loginAsAnalyst();
		homePage.clickOnCDD();
		customerDueDeligence.openRequest();
		customerDueDeligence.enterQuestionsDetails();
		customerDueDeligence.clickOnNextButton();
		customerDueDeligencePreviewPage.clickOnSubmitButton();
	}
	
	
	@AfterMethod
	public void configAM()
	{
		homePage.logOut();
		driver.quit();
	}

}
