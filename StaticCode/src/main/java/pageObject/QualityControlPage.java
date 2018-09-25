package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualityControlPage 
{
	public WebDriver driver;
	
	public QualityControlPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "requestId")
	private WebElement txtbx_RequestId;
	
	@FindBy(how = How.NAME, using = "searchButton")
	private WebElement btn_Search;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'REQ')]")
	private WebElement link_RequestId;
	
	@FindBy(how = How.NAME, using = "Submit")
	private WebElement btn_Submit;
	
	@FindBy(how = How.NAME, using = "Reject")
	private WebElement btn_Reject;
	
	@FindBy(how = How.NAME, using = "Next")
	private WebElement btn_Next;
	
	public void enterRequestedId(String requestId)
	{
		txtbx_RequestId.sendKeys(requestId);
	}
	
	public void clickOnSearchButton()
	{
		btn_Search.click();
	}
	
	public void searchForRequest(String reqId)
	{
		enterRequestedId(reqId);
		clickOnSearchButton();
	}
	
	public void openRequest()
	{
		searchForRequest("REQ0000123");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(link_RequestId));
		link_RequestId.click();
	}
	
	public void clickOnSubmitButton()
	{
		btn_Submit.click();
	}
	
	public void clickOnRejecButton()
	{
		btn_Reject.click();
	}
	
	public void clickOnNextButton()
	{
		btn_Next.click();
	}

}
