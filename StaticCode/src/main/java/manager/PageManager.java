package manager;

import org.openqa.selenium.WebDriver;

import pageObject.ClientRequestPage;
import pageObject.CustomerDueDeligence;
import pageObject.CustomerDueDeligencePreviewPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.QualityControlPage;
import pageObject.RiskRatingPage;

public class PageManager 
{
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private ClientRequestPage clientRequestPage;
	private CustomerDueDeligence customerDueDeligence;
	private CustomerDueDeligencePreviewPage customerDueDeligencePreviewPage;
	private QualityControlPage qualityControlPage;
	private RiskRatingPage riskRatingPage;
	
	public PageManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage getLoginPage()
	{
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public HomePage getHomePage()
	{
		homePage = new HomePage(driver);
		return homePage;
	}
	
	public ClientRequestPage getClientRequestpage()
	{
		clientRequestPage = new ClientRequestPage(driver);
		return clientRequestPage;
	}
	
	public CustomerDueDeligence getCustomerDueDeligence()
	{
		customerDueDeligence = new CustomerDueDeligence(driver);
		return customerDueDeligence;
	}
	
	public CustomerDueDeligencePreviewPage getCustomerDueDeligencePreviewPage()
	{
		customerDueDeligencePreviewPage = new CustomerDueDeligencePreviewPage(driver);
		return customerDueDeligencePreviewPage;
	}
	
	public QualityControlPage getQualityControlPage()
	{
		qualityControlPage = new QualityControlPage(driver);
		return qualityControlPage;
	}
	
	public RiskRatingPage getRiskRatingPage()
	{
		riskRatingPage = new RiskRatingPage(driver);
		return riskRatingPage;
	}

}
