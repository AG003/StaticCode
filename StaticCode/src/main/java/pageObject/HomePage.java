package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Client Request")
	private WebElement link_ClientRequest;
	
	@FindBy(how = How.LINK_TEXT, using = "Product Request")
	private WebElement link_ProductRequest;
	
	@FindBy(how = How.LINK_TEXT, using = "Trading Account")
	private WebElement link_TradingRequest;
	
	@FindBy(how = How.NAME, using = "logout")
	private WebElement btn_LogOut;
	
	@FindBy(how = How.LINK_TEXT, using = "CDD")
	private WebElement link_CDD;
	
	@FindBy(how = How.NAME, using = "QC")
	private WebElement link_QC;
	
	@FindBy(how = How.NAME, using = "RR")
	private WebElement link_RR;
	
	public void clickOnRR()
	{
		link_RR.click();
	}
	
	public void clickOnClientRequest()
	{
		link_ClientRequest.click();
	}
	
	public void clickOnLogoutButton()
	{
		btn_LogOut.click();
	}
	
	public void logOut()
	{
		clickOnLogoutButton();
	}
	
	public void clickOnCDD()
	{
		link_CDD.click();
	}
	
	public void clickOnQC()
	{
		link_QC.click();
	}

}




